package ch.nation.rest.logic.controller;

import ch.nation.core.clients.services.games.GameServiceClient;
import ch.nation.core.clients.services.moves.MoveServiceClient;
import ch.nation.core.clients.services.moves.values.MoveValueServiceClient;
import ch.nation.core.clients.services.skills.SkillEffectServiceClient;
import ch.nation.core.clients.services.skills.SkillServiceClient;
import ch.nation.core.clients.services.units.UnitServiceClient;
import ch.nation.core.clients.services.users.UserServiceClient;
import ch.nation.core.clients.services.users.runtime.UserGameRuntimeServiceClient;
import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.core.model.position.Vector3Int;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GameLogicService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final GameServiceClient gameServiceClient;
    private final MoveServiceClient playerMoveServiceClient;
    private final UserServiceClient userResourceService;
    private final UnitServiceClient unitResourceService;
    private final UserGameRuntimeServiceClient userRuntimeServiceClient;
    private final SkillServiceClient skillResourceService;
    private final MoveValueServiceClient moveMoveValueResourceService;
    private final SkillEffectServiceClient skillEffectsResourceService;
    private final static String AP_RESET_SKILL_IDENTIFIER = "reset_caster_ap";


    @Autowired
    public GameLogicService(GameServiceClient gameServiceClient, MoveServiceClient moveServiceClient, UserServiceClient userServiceClient, UnitServiceClient unitServiceClient, UserGameRuntimeServiceClient userGameRuntimeServiceClient,
                            SkillServiceClient skillServiceClient, MoveValueServiceClient moveValueServiceClient, SkillEffectServiceClient skillEffectServiceClient) {
        this.gameServiceClient = gameServiceClient;
        this.playerMoveServiceClient = moveServiceClient;
        this.userResourceService = userServiceClient;
        this.unitResourceService = unitServiceClient;
        this.userRuntimeServiceClient = userGameRuntimeServiceClient;
        this.skillResourceService = skillServiceClient;
        this.moveMoveValueResourceService = moveValueServiceClient;
        this.skillEffectsResourceService = skillEffectServiceClient;
    }


    public ResponseEntity<Boolean> endGame(final String sessionToken, final String gameUuid, final String uuidWinner) throws Exception {
        LOGGER.info(String.format("START | Finish Game | game : %s | Winner:", gameUuid), uuidWinner);
        boolean wasOk = false;
        ResponseEntity<GameDto> currentGameOptional = gameServiceClient.findById(sessionToken, gameUuid, QueryProjection.def);
        ResponseEntity<UserDto> winnerPlayer = userResourceService.findById(sessionToken, uuidWinner, QueryProjection.def);
        if (currentGameOptional.getBody() == null)
            throw new Exception(String.format("Could not end game! Game [%s] does not exist!", gameUuid));
        if (winnerPlayer.getBody() == null)
            throw new Exception(String.format("Could not end game! User [%s] does not exist!", gameUuid));
        GameDto game = currentGameOptional.getBody();
        game.setStatus(GameStatus.Finished);
        game.setWinner(uuidWinner);

        final ResponseEntity<GameDto> updatedGame = gameServiceClient.updatePut(sessionToken, game, QueryProjection.def);

        //TODO DELETE UserRuntimes

        //TODO Update Stats of Units and Player
        if (updatedGame.getBody() != null) wasOk = true;


        LOGGER.info(String.format("STOP | Finish Game | game : %s | Winner:", gameUuid), uuidWinner);
        return new ResponseEntity<>(wasOk, HttpStatus.OK);
    }


    public ResponseEntity<?> endTurn(final String sessionToken, final String gameUuid, final GameUserRuntimeInfoDto currentPlayerGameRuntimeInfo) throws Exception {
        LOGGER.info(String.format("START | END Player Move | game : %s ", gameUuid));
        final ResponseEntity<GameDto> gameInstanceOptional = gameServiceClient.findById(sessionToken, gameUuid, QueryProjection.def);
        if (gameInstanceOptional.getBody() == null) throw new Exception("Error could find game by uuid " + gameUuid);
        GameDto gameInstance = gameInstanceOptional.getBody();
        ResponseEntity<GameUserRuntimeInfoDto> runtime = userRuntimeServiceClient.findById(sessionToken, currentPlayerGameRuntimeInfo.getId(), QueryProjection.def);
        if (runtime.getBody() == null)
            throw new Exception("Error could find runtime by player uuid " + gameInstance.getCurrentPlayerUuid());


        //RESET AP of current player
        resetAP(sessionToken, gameUuid, gameInstance, currentPlayerGameRuntimeInfo);

        // Update Skill of player
        updateSkillCooldownCounter(sessionToken, runtime.getBody());

        //Start updating GameState
        updateGameState(sessionToken, currentPlayerGameRuntimeInfo, gameInstance, runtime.getBody());

        LOGGER.info(String.format("STOP | END Player Move | game : %s ", gameUuid));
        return new ResponseEntity<>(Boolean.valueOf(true), HttpStatus.OK);

    }

    public ResponseEntity<Boolean> isUserCurrentUserInGame(final String sessionToken, final String gameUuid, final String playerUuid) {
        LOGGER.info(String.format("START | Check if Player is current player | game : %s | player: %s", gameUuid, playerUuid));
        final ResponseEntity<GameDto> game = gameServiceClient.findById(sessionToken, gameUuid, QueryProjection.def);
        final boolean isCurrent = game.getBody().getCurrentPlayerUuid().equals(playerUuid);
        LOGGER.info(String.format("Player: %s is current player of game %s -> %b", playerUuid, gameUuid, isCurrent));
        LOGGER.info(String.format("STOP | Check if Player is current player | game : %s | player: %s", gameUuid, playerUuid));
        return new ResponseEntity<>(isCurrent, HttpStatus.OK);
    }

    private void updateGameState(final String sessionToken, final GameUserRuntimeInfoDto currentPlayerGameRuntimeInfo, final GameDto gameInstance, final GameUserRuntimeInfoDto runtime) {
        GameUserRuntimeInfoDto runtimeInfoDto = runtime;
        runtimeInfoDto.setConsiderationTime(currentPlayerGameRuntimeInfo.getConsiderationTime());
        userRuntimeServiceClient.updatePatch(sessionToken, runtimeInfoDto, QueryProjection.def);


        String currentPlayerUuid = gameInstance.getCurrentPlayerUuid();
        String nextPlayerUuid = gameInstance.getNextPlayerUuid();
        int round = gameInstance.getRound();

        gameInstance.setNextPlayerUuid(currentPlayerUuid);
        gameInstance.setCurrentPlayerUuid(nextPlayerUuid);
        LOGGER.info("Next Player is: " + nextPlayerUuid);
        if (nextPlayerUuid.equals(gameInstance.getFirstPlayerUuid())) {
            gameInstance.setRound((round + 1));
            LOGGER.info("Updated Round Counter to" + (round + 1));
        }
        ResponseEntity<GameDto> updatedState = gameServiceClient.updatePut(sessionToken, gameInstance, QueryProjection.def);
        LOGGER.debug("State was updated");
    }

    private void updateSkillCooldownCounter(final String sessionToken, final GameUserRuntimeInfoDto runtime) {
        LOGGER.debug("Try to get all moves with skill count greater than 0");
        ResponseEntity<List<AbstractPlayerMoveDto>> movesToUpdate = playerMoveServiceClient.getMovesByGameRuntimeAndCooldownCounterGraterThan(runtime.getId(), 0, QueryProjection.def);


        for (AbstractPlayerMoveDto move :
                movesToUpdate.getBody()) {


            int currentCooldownCounter = ((SkillPlayerMoveDto) move).getCooldownCounter();
            int newCounter = currentCooldownCounter - 1;
            ((SkillPlayerMoveDto) move).setCooldownCounter(newCounter);
            playerMoveServiceClient.updatePut(sessionToken, (SkillPlayerMoveDto) move, QueryProjection.def);
            LOGGER.debug("Updated counter");
        }
    }


    private void resetAP(final String sessionToken, final String gameUuid, GameDto game, GameUserRuntimeInfoDto userRuntimeInfoDto) throws Exception {
        LOGGER.info(String.format("START | Resetting AP By Player | game : %s | player: %s", gameUuid, userRuntimeInfoDto.getPlayerUuid()));
        final String playerUuid = userRuntimeInfoDto.getPlayerUuid();
        final ResponseEntity<SkillDto> skillDto = skillResourceService.findByIdentifier(sessionToken, AP_RESET_SKILL_IDENTIFIER, QueryProjection.max);
        if (skillDto == null && skillDto.getBody() == null) throw new Exception("Could not find AP_RESET SKILL!");
        final SkillDto resetAP = skillDto.getBody();
        final ResponseEntity<UserDto> user = userResourceService.findById(sessionToken, playerUuid, QueryProjection.max);
        final ResponseEntity<List<AbstractDto>> unitsResponse = userResourceService.getChildrenByResourceType(sessionToken, playerUuid, "units", QueryProjection.max);
        final List<AbstractDto> units = unitsResponse.getBody();

        for (int i = 0; i < units.size(); i++) {
            LOGGER.debug(String.format("Processing unit : [%d|%d] -> Name: ", (i + 1), units.size(), units.get(i)));
            SkillPlayerMoveDto move = new SkillPlayerMoveDto(SkillPlayerMoveDto.TYPE_IDENTIFER_SKILL);
            move.setSkillDto(resetAP);
            move.setUser(user.getBody());
            move.setCaster((UnitDto) units.get(i));
            move.setSkillCost(resetAP.getCost());
            move.setCooldownCounter(resetAP.getCooldown());
            move.setGameDto(game);
            StatSkillPlayerMoveSkillValueDto value = new StatSkillPlayerMoveSkillValueDto(StatSkillPlayerMoveSkillValueDto.TYPE_IDENTIFIER);
            value.setAppliedOn(resetAP.getSkillEffects().get(0).getApplyCalculationOnStat());
            value.setValue(((UnitDto) units.get(i)).getCharacterClass().getActionPoints().getMaxValue());
            value.setTarget((UnitDto) units.get(i));
            value.setEffectDto((SkillEffectDto) resetAP.getSkillEffects().get(0));
            List<BasePlayerMoveValueDto> moveValueDtos = new ArrayList<>(1);

            moveValueDtos.add(value);
            move.setEffectValues(moveValueDtos);
            addMove(sessionToken, gameUuid, playerUuid, move);

        }


        LOGGER.info(String.format("STOP | Resetting AP By Player | game : %s | player: %s", gameUuid, playerUuid));
    }


    public ResponseEntity<?> addMove(final String sesssionToken, final String gameUuid, final String playerUuid, final BasePlayerMoveDto move) throws Exception {
        LOGGER.info(String.format("START | Adding unit move By Name | game : %s | player: %s", gameUuid, playerUuid));


        final ResponseEntity<GameDto> gameResponse = gameServiceClient.findById(sesssionToken, gameUuid, QueryProjection.max);
        if (gameResponse.getBody() == null)
            throw new IllegalArgumentException("Game with uuid " + gameUuid + " does not exist");
        GameDto dto = gameResponse.getBody();
        GameUserRuntimeInfoDto info = dto.getUserGameUserRuntimeInfo().stream().filter(x -> x.getPlayerUuid().equals(playerUuid)).findFirst().get();
        int currentCountOfMovesOfPlayer = playerMoveServiceClient.getCountOfMovesOfGameByGameRuntimeUuid(info.getId());

        List<AbstractDto> moves = new ArrayList<>();
        move.setRound(dto.getRound());
        move.setSequenceIdentifier(currentCountOfMovesOfPlayer + 1);
        moves.add(move);


        ResponseEntity children = userRuntimeServiceClient.createChildren(sesssionToken, moves, QueryProjection.max);


        //TODO Add Support for reversal skills


        if (move instanceof SkillPlayerMoveDto) {


            AbstractDto savedMove = ((ArrayList<AbstractDto>) children.getBody()).get(0);
            //TODO Check why it is not possible to set skill cost during creation???
            //     ((SkillPlayerMoveDto) savedMove).setSkillCost(((SkillPlayerMoveDto)move).getSkillCost());
            ((SkillPlayerMoveDto) savedMove).setSkillCost(((SkillPlayerMoveDto) move).getSkillCost());
            ((SkillPlayerMoveDto) savedMove).setCooldownCounter(((SkillPlayerMoveDto) move).getSkillDto().getCooldown());
            ((SkillPlayerMoveDto) savedMove).setSequenceIdentifier(move.getSequenceIdentifier());
            // playerMoveEntityService.updatePut((BasePlayerMoveDto)savedMove,QueryProjection.def);
            playerMoveServiceClient.updatePut(sesssionToken, (BasePlayerMoveDto) savedMove, QueryProjection.def);
            //Fetch Association targets
            ResponseEntity<UnitDto> caster = unitResourceService.findById(sesssionToken, move.getCaster().getId(), QueryProjection.def);
            ResponseEntity<SkillDto> skill = skillResourceService.findById(sesssionToken, move.getSkillDto().getId(), QueryProjection.def);
            ResponseEntity<UserDto> user = userResourceService.findById(sesssionToken, move.getUser().getId(), QueryProjection.def);

            //Add associations
            playerMoveServiceClient.createAssociation(sesssionToken, savedMove.getId(), caster.getBody(), "caster", QueryProjection.min);
            playerMoveServiceClient.createAssociation(sesssionToken, savedMove.getId(), skill.getBody(), "skill", QueryProjection.min);
            playerMoveServiceClient.createAssociation(sesssionToken, savedMove.getId(), user.getBody(), "user", QueryProjection.min);

            final List<AbstractDto> childrensList = new ArrayList<>();

            for (AbstractMoveSkillEffectValueDto value :
                    ((SkillPlayerMoveDto) move).getEffectValues()) {
                ResponseEntity<UnitDto> target = unitResourceService.findById(sesssionToken, value.getTarget().getId(), QueryProjection.def);
                value.setTarget(target.getBody());
                ResponseEntity<SkillEffectDto> effectDto = skillEffectsResourceService.findById(sesssionToken, value.getEffectDto().getId(), QueryProjection.def);
                value.setEffectDto(effectDto.getBody());


                ResponseEntity<AbstractMoveSkillEffectValueDto> createdValue = moveMoveValueResourceService.create(sesssionToken, value, QueryProjection.def);

                childrensList.add(createdValue.getBody());

            }


            playerMoveServiceClient.createAssociation(sesssionToken, savedMove.getId(), childrensList, "values", QueryProjection.def);

            childrensList.clear();


//ADD move to user-runtime!
            ResponseEntity updatedParent = userRuntimeServiceClient.createAssociation(sesssionToken, info.getId(), (List<AbstractDto>) children.getBody(), "moves", QueryProjection.max);


            ResponseEntity<BasePlayerMoveDto> moveDto = playerMoveServiceClient.findById(sesssionToken, savedMove.getId(), QueryProjection.max);

            if (moveDto.getBody() == null) throw new Exception("Could not create entry!");
            return new ResponseEntity<>(moveDto.getBody(), HttpStatus.OK);
        }
        LOGGER.info(String.format("FINISH | Adding unit move By Name | game : %s | player: %s", gameUuid, playerUuid));


        return new ResponseEntity<>(Optional.empty(), HttpStatus.OK);
    }

    public ResponseEntity createNewGame(final String sesssionToken, final String playerUuid, final String playerTwoUuid) throws Exception {
        LOGGER.info("*** START to create new Game ***");
        ResponseEntity<GameDto> gameDtoResponseEntity = null;
        gameDtoResponseEntity = gameServiceClient.createGame(playerUuid, playerTwoUuid, QueryProjection.max);

        if (gameDtoResponseEntity.getStatusCode() != HttpStatus.CREATED) {
            throw new Exception("Could create game! Entity from game service was null!");
        }

        // Reset AP for All Units
        final GameDto game = gameDtoResponseEntity.getBody();

        GameUserRuntimeInfoDto playerOne = null;
        GameUserRuntimeInfoDto playerTwo = null;

        for (int idx = 0; idx < game.getUserGameUserRuntimeInfo().size(); idx++) {
            if (game.getUserGameUserRuntimeInfo().get(idx).getPlayerUuid().equals(playerUuid)) {
                playerOne = game.getUserGameUserRuntimeInfo().get(idx);
            } else if (game.getUserGameUserRuntimeInfo().get(idx).getPlayerUuid().equals(playerTwoUuid)) {
                playerTwo = game.getUserGameUserRuntimeInfo().get(idx);
            }
        }

        LOGGER.info(String.format("Reset AP of Player %s", playerOne.getPlayerUuid()));

        resetAP(sesssionToken, game.getId(), game, playerOne);
        LOGGER.info(String.format("Reset AP of Player %s", playerTwo.getPlayerUuid()));
        resetAP(sesssionToken, game.getId(), game, playerTwo);


        LOGGER.info(String.format("Load updated data from DB | Game UUID: %s", game.getId()));
        ResponseEntity<GameDto> updatedState = gameServiceClient.findById(sesssionToken, game.getId(), QueryProjection.newgame);
        LOGGER.info("*** FINISH to create new Game ***");
        return updatedState;
    }


    public ResponseEntity<Boolean> updateFogOfWarByPlayerAndGame(final String sessionToken, final String gameUuid, final String playerUuid, final List<Vector3Int> uncoveredTilePositions) throws Exception {
        if (!gameServiceClient.existsById(sessionToken, gameUuid).getBody())
            throw new Exception(String.format("Game with uuid %s does not exist", gameUuid));
        if (!userResourceService.existsById(sessionToken, playerUuid).getBody())
            throw new Exception(String.format("User with uuid %s does not exist", playerUuid));


        if (uncoveredTilePositions.size() != 0) {

            ResponseEntity<GameUserRuntimeInfoDto> info = userRuntimeServiceClient.getUserRuntimeInfoByGameUuidAndByPlayerUuid(gameUuid, playerUuid, QueryProjection.min);

            if (info.getBody() == null) return new ResponseEntity<>(false, HttpStatus.OK);


            GameUserRuntimeInfoDto infoDto = info.getBody();

            uncoveredTilePositions.stream().forEach((x) -> infoDto.addFogOfWarTilePositon(x));

            ResponseEntity<GameUserRuntimeInfoDto> updated = userRuntimeServiceClient.updatePatch(sessionToken, infoDto, QueryProjection.def);

            if (updated.getBody() == null) return new ResponseEntity<>(true, HttpStatus.OK);


        } else {
            LOGGER.info("Enttiy was not updated the list is empty!");
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
