package ch.nation.rest.logic.controller;

import ch.nation.core.clients.services.games.GameServiceClient;
import ch.nation.core.clients.services.moves.MoveServiceClient;
import ch.nation.core.clients.services.moves.SkillMoveServiceClient;
import ch.nation.core.clients.services.moves.values.MoveValueServiceClient;
import ch.nation.core.clients.services.moves.values.StatMoveValueServiceClient;
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
import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.core.model.position.Vector3Int;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GameLogicService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final GameServiceClient gameService;
    private final MoveServiceClient playerMoveEntityService;
    private final UserServiceClient userResourceService;
    private final UnitServiceClient unitResourceService;
    private final UserGameRuntimeServiceClient gameUserRuntimeInfoService;
    private final SkillServiceClient skillResourceService;
    private final MoveValueServiceClient moveMoveValueResourceService;
    private final SkillEffectServiceClient skillEffectsResourceService;



    @Autowired
    public GameLogicService(final GameServiceClient gameService, final MoveServiceClient playerMoveEntityService, final UserServiceClient userResourceService, final UnitServiceClient unitResourceService,
                            final UserGameRuntimeServiceClient gameUserRuntimeInfoService, final SkillServiceClient skillResourceService,
                           final MoveValueServiceClient valueResourceService, MoveValueServiceClient skillPlayerMoveResourceService, SkillMoveServiceClient moveMoveValueResourceService, StatMoveValueServiceClient statPlayerMoveValueResourceService, SkillEffectServiceClient skillEffectsResourceService, SkillMoveServiceClient playerMoveResourceService) {
        this.gameService = gameService;
        this.playerMoveEntityService = playerMoveEntityService;
        this.userResourceService = userResourceService;
        this.unitResourceService = unitResourceService;
        this.gameUserRuntimeInfoService = gameUserRuntimeInfoService;
        this.skillResourceService = skillResourceService;
        this.moveMoveValueResourceService = valueResourceService;
        this.skillEffectsResourceService = skillEffectsResourceService;

    }




    public ResponseEntity<Boolean> endGame(final String gameUuid, final String uuidWinner) throws Exception {
        LOGGER.info(String.format("START | Finish Game | game : %s | Winner:", gameUuid),uuidWinner);
        boolean wasOk = false;
        ResponseEntity<GameDto> currentGameOptional = gameService.findById(gameUuid,QueryProjection.def);
        ResponseEntity<UserDto> winnerPlayer = userResourceService.findById(uuidWinner,QueryProjection.def);
        if(currentGameOptional.getBody()==null) throw new Exception(String.format("Could not end game! Game [&s] does not exist!",gameUuid));
        if(winnerPlayer.getBody()==null) throw new Exception(String.format("Could not end game! User [&s] does not exist!",gameUuid));
        GameDto game = currentGameOptional.getBody();
        game.setStatus(GameStatus.Finished);
        game.setWinner(uuidWinner);

        final ResponseEntity<GameDto> updatedGame= gameService.updatePut(game,QueryProjection.def);

        //TODO DELETE UserRuntimes

        //TODO Update Stats of Units and Player
        if(updatedGame.getBody()!=null) wasOk = true;



        LOGGER.info(String.format("STOP | Finish Game | game : %s | Winner:", gameUuid),uuidWinner);
        return new ResponseEntity<>(wasOk,HttpStatus.OK);
    }



    public ResponseEntity<?> endTurn(final String gameUuid, final GameUserRuntimeInfoDto currentPlayerGameRuntimeInfo) throws Exception {
        LOGGER.info(String.format("START | END Player Move | game : %s ", gameUuid));
        final ResponseEntity<GameDto> gameInstanceOptional = gameService.findById(gameUuid,QueryProjection.def);
        if(gameInstanceOptional.getBody()==null) throw new Exception("Error could find game by uuid "+gameUuid);
        GameDto gameInstance = gameInstanceOptional.getBody();
        ResponseEntity<GameUserRuntimeInfoDto> runtime= gameUserRuntimeInfoService.findById(currentPlayerGameRuntimeInfo.getId(),QueryProjection.def);
        if(runtime.getBody()==null) throw new Exception("Error could find runtime by player uuid "+gameInstance.getCurrentPlayerUuid());


        //Start updating GameState

        updateGameState(currentPlayerGameRuntimeInfo, gameInstance, runtime.getBody());


        // Update Skill of player
        updateSkillCooldownCounter(runtime.getBody());


        LOGGER.info(String.format("STOP | END Player Move | game : %s ", gameUuid));
        return new ResponseEntity<>(Boolean.valueOf(true),HttpStatus.OK);

    }

    private void updateGameState(final GameUserRuntimeInfoDto currentPlayerGameRuntimeInfo, final GameDto gameInstance, final GameUserRuntimeInfoDto runtime) {
        GameUserRuntimeInfoDto runtimeInfoDto  = runtime;
        runtimeInfoDto.setConsiderationTime(currentPlayerGameRuntimeInfo.getConsiderationTime());
        gameUserRuntimeInfoService.updatePatch(runtimeInfoDto,QueryProjection.def);


        String currentPlayerUuid = gameInstance.getCurrentPlayerUuid();
        String nextPlayerUuid = gameInstance.getNextPlayerUuid();
        int round = gameInstance.getRound();

        gameInstance.setNextPlayerUuid(currentPlayerUuid);
        gameInstance.setCurrentPlayerUuid(nextPlayerUuid);
        LOGGER.info("Next Player is: "+nextPlayerUuid);
        if(nextPlayerUuid.equals(gameInstance.getFirstPlayerUuid())) {
            gameInstance.setRound((round + 1));
            LOGGER.info("Updated Round Counter to"+(round+1));
        }
        ResponseEntity<GameDto> updatedState= gameService.updatePut(gameInstance,QueryProjection.def);
        LOGGER.debug("State was updated");
    }

    private void updateSkillCooldownCounter(final GameUserRuntimeInfoDto runtime) {
        LOGGER.debug("Try to get all moves with skill count greater than 0");
        ResponseEntity<List<AbstractPlayerMoveDto>> movesToUpdate = playerMoveEntityService.getMovesByGameRuntimeAndCooldownCounterGraterThan(runtime.getId(),0, QueryProjection.def);


        for (AbstractPlayerMoveDto move:
                movesToUpdate.getBody()) {


            int currentCooldownCounter= ((SkillPlayerMoveDto)move).getCooldownCounter();
            int newCounter = currentCooldownCounter-1;
            ((SkillPlayerMoveDto)move).setCooldownCounter(newCounter);
            playerMoveEntityService.updatePut((SkillPlayerMoveDto) move,QueryProjection.def);
            LOGGER.debug("Updated counter");
        }
    }


    public ResponseEntity<?> addMove(final String gameUuid, final String playerUuid, final BasePlayerMoveDto move) throws Exception {
        LOGGER.info(String.format("START | Adding unit move By Name | game : %s | player: %s", gameUuid, playerUuid));


        final ResponseEntity<GameDto> gameResponse = gameService.findById(gameUuid, QueryProjection.max);
        if (gameResponse.getBody()==null)
            throw new IllegalArgumentException("Game with uuid " + gameUuid + " does not exist");
        final ResponseEntity<UserDto> userResponse = userResourceService.findById(playerUuid,QueryProjection.def);
        if (gameResponse.getBody()==null)
            throw new IllegalArgumentException("User with uuid " + userResponse + " does not exist");
        if (move == null) throw new Exception("Move Item is null!");


        GameDto dto = gameResponse.getBody();
        GameUserRuntimeInfoDto info = dto.getUserGameUserRuntimeInfo().stream().filter(x -> x.getPlayerUuid().equals(playerUuid)).findFirst().get();
        List<AbstractDto> moves = new ArrayList<>();
        move.setRound(dto.getRound());
        moves.add(move);


        ResponseEntity children = gameUserRuntimeInfoService.createChildren(moves, QueryProjection.max);



        if(move instanceof SkillPlayerMoveDto) {



            AbstractDto savedMove = ((ArrayList<AbstractDto>) children.getBody()).get(0);
            //TODO Check why it is not possible to set skill cost during creation???
            //     ((SkillPlayerMoveDto) savedMove).setSkillCost(((SkillPlayerMoveDto)move).getSkillCost());
            ((SkillPlayerMoveDto) savedMove).setSkillCost(((SkillPlayerMoveDto)move).getSkillCost());
            ((SkillPlayerMoveDto) savedMove).setCooldownCounter(((SkillPlayerMoveDto)move).getSkillDto().getCooldown());
            playerMoveEntityService.updatePut((BasePlayerMoveDto)savedMove,QueryProjection.def);

            //Fetch Association targets
            ResponseEntity<UnitDto> caster = unitResourceService.findById(move.getCaster().getId(), QueryProjection.def);
            ResponseEntity<SkillDto> skill = skillResourceService.findById(move.getSkillDto().getId(), QueryProjection.def);
            ResponseEntity<UserDto> user = userResourceService.findById(move.getUser().getId(), QueryProjection.def);

            //Add associations
            playerMoveEntityService.createAssociation(savedMove.getId(), caster.getBody(), "caster", QueryProjection.min);
            playerMoveEntityService.createAssociation(savedMove.getId(), skill.getBody(), "skill", QueryProjection.min);
            playerMoveEntityService.createAssociation(savedMove.getId(), user.getBody(), "user", QueryProjection.min);

            final List<AbstractDto> childrensList = new ArrayList<>();

            for (AbstractMoveSkillEffectValueDto value :
                    ((SkillPlayerMoveDto)move).getEffectValues()) {
                ResponseEntity<UnitDto> target = unitResourceService.findById(value.getTarget().getId(), QueryProjection.def);
                value.setTarget(target.getBody());
                ResponseEntity<SkillEffectDto> effectDto = skillEffectsResourceService.findById(value.getEffectDto().getId(), QueryProjection.def);
                value.setEffectDto(effectDto.getBody());

       /**         if (value instanceof StatSkillPlayerMoveSkillValueDto) {


                    Optional<StatSkillPlayerMoveSkillValueDto> createdValue = statPlayerMoveValueResourceService.create(value);
                    childrensList.add(createdValue.get());
                } else if (value instanceof MoveSkillEffectPlayerMoveSkillValueDto) {


                    Optional<MoveSkillEffectPlayerMoveSkillValueDto> createdValue = moveMoveValueResourceService.create((MoveSkillEffectPlayerMoveSkillValueDto) value);
                    childrensList.add(createdValue.get());

                }**/


            ResponseEntity<BasePlayerMoveValueDto> createdValue=    moveMoveValueResourceService.create((BasePlayerMoveValueDto)value,QueryProjection.def);

            childrensList.add(createdValue.getBody());

            }
/**


            playerMoveResourceService.createAssociation(savedMove.getId(), childrensList);

            childrensList.clear();


//ADD move to user-runtime!
            Optional<?> updatedParent = gameUserRuntimeInfoService.addChildrenToParent(info, (List<AbstractDto>) children.get(), QueryProjection.max);


            Optional<SkillPlayerMoveDto> moveDto = playerMoveResourceService.findById(savedMove.getId(), QueryProjection.max);

            if (!moveDto.isPresent()) throw new Exception("Could not create entry!");
            return new ResponseEntity<>(moveDto, HttpStatus.OK);
        }
        LOGGER.info(String.format("FINISH | Adding unit move By Name | game : %s | player: %s", gameUuid, playerUuid));

**/


    }
        return new ResponseEntity<>(Optional.empty(),HttpStatus.OK);
    }


    public ResponseEntity<Boolean> updateFogOfWarByPlayerAndGame(final String gameUuid, final String playerUuid, final List<Vector3Int> uncoveredTilePositions) throws Exception {
        if (!gameService.existsById(gameUuid).getBody())
            throw new Exception(String.format("Game with uuid %s does not exist", gameUuid));
        if (!userResourceService.existsById(playerUuid).getBody())
            throw new Exception(String.format("User with uuid %s does not exist", playerUuid));


        if (uncoveredTilePositions.size() != 0) {

            ResponseEntity<GameUserRuntimeInfoDto> info = gameUserRuntimeInfoService.getUserRuntimeInfoByGameUuidAndByPlayerUuid(gameUuid, playerUuid, QueryProjection.min);

            if (info.getBody()!=null) return new ResponseEntity<>(false, HttpStatus.OK);


            GameUserRuntimeInfoDto infoDto = info.getBody();

            uncoveredTilePositions.stream().forEach((x) -> infoDto.addFogOfWarTilePositon(x));

            ResponseEntity<GameUserRuntimeInfoDto> updated = gameUserRuntimeInfoService.updatePatch(infoDto,QueryProjection.def);

            if (updated.getBody()==null) return new ResponseEntity<>(true, HttpStatus.OK);


        } else {
            LOGGER.info("Enttiy was not updated the list is empty!");
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
