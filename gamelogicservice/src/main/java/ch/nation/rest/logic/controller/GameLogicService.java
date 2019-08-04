package ch.nation.rest.logic.controller;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.skills.effects.AbstractSkillEffectDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.core.model.position.Vector3Int;
import ch.nation.rest.services.impl.games.GameResourceServiceImpl;
import ch.nation.rest.services.impl.games.GameUserRuntimeInfoServiceImpl;
import ch.nation.rest.services.impl.playerMoves.PlayerMoveResourceServiceImpl;
import ch.nation.rest.services.impl.playerMoves.values.MoveMoveValueResourceServiceImpl;
import ch.nation.rest.services.impl.playerMoves.values.PlayerMoveValueResourceServiceImpl;
import ch.nation.rest.services.impl.playerMoves.values.StatPlayerMoveValueResourceServiceImpl;
import ch.nation.rest.services.impl.skills.SkillResourceServiceImpl;
import ch.nation.rest.services.impl.skills.effects.SkillEffectsResourceServiceImpl;
import ch.nation.rest.services.impl.units.UnitResourceServiceImpl;
import ch.nation.rest.services.impl.users.UserResourceServiceImpl;

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
    private final GameResourceServiceImpl gameService;
    private final PlayerMoveResourceServiceImpl playerMoveEntityService;
    private final UserResourceServiceImpl userResourceService;
    private final UnitResourceServiceImpl unitResourceService;
    private final GameUserRuntimeInfoServiceImpl gameUserRuntimeInfoService;
    private final SkillResourceServiceImpl skillResourceService;
    private final PlayerMoveValueResourceServiceImpl valueResourceService;
    private final MoveMoveValueResourceServiceImpl moveMoveValueResourceService;
    private final StatPlayerMoveValueResourceServiceImpl statPlayerMoveValueResourceService;
    private final SkillEffectsResourceServiceImpl skillEffectsResourceService;



    @Autowired
    public GameLogicService(final GameResourceServiceImpl gameService, final PlayerMoveResourceServiceImpl playerMoveEntityService, final UserResourceServiceImpl userResourceService, UnitResourceServiceImpl unitResourceService, GameUserRuntimeInfoServiceImpl gameUserRuntimeInfoService, SkillResourceServiceImpl skillResourceService, PlayerMoveValueResourceServiceImpl valueResourceService, MoveMoveValueResourceServiceImpl moveMoveValueResourceService, StatPlayerMoveValueResourceServiceImpl statPlayerMoveValueResourceService, SkillEffectsResourceServiceImpl skillEffectsResourceService) {
        this.gameService = gameService;
        this.playerMoveEntityService = playerMoveEntityService;
        this.userResourceService = userResourceService;
        this.unitResourceService = unitResourceService;
        this.gameUserRuntimeInfoService = gameUserRuntimeInfoService;
        this.skillResourceService = skillResourceService;
        this.valueResourceService = valueResourceService;
        this.moveMoveValueResourceService = moveMoveValueResourceService;
        this.statPlayerMoveValueResourceService = statPlayerMoveValueResourceService;
        this.skillEffectsResourceService = skillEffectsResourceService;
    }




    public ResponseEntity<Boolean> endGame(final String gameUuid, final String uuidWinner) throws Exception {
        LOGGER.info(String.format("START | Finish Game | game : %s | Winner:", gameUuid),uuidWinner);
        boolean wasOk = false;
        Optional<GameDto> currentGameOptional = gameService.findById(gameUuid,QueryProjection.def);
        Optional<UserDto> winnerPlayer = userResourceService.findById(uuidWinner);
        if(!currentGameOptional.isPresent()) throw new Exception(String.format("Could not end game! Game [&s] does not exist!",gameUuid));
        if(!winnerPlayer.isPresent()) throw new Exception(String.format("Could not end game! User [&s] does not exist!",gameUuid));
        GameDto game = currentGameOptional.get();
        game.setStatus(GameStatus.Finished);
        game.setWinner(uuidWinner);

        Optional<GameDto> updatedGame= gameService.updatePut(game);

        //TODO DELETE UserRuntimes

        //TODO Update Stats of Units and Player
        if(updatedGame.isPresent()) wasOk = true;



        LOGGER.info(String.format("STOP | Finish Game | game : %s | Winner:", gameUuid),uuidWinner);
        return new ResponseEntity<>(wasOk,HttpStatus.OK);
    }



    public ResponseEntity<?> endTurn(final String gameUuid, final GameUserRuntimeInfoDto currentPlayerGameRuntimeInfo) throws Exception {
        LOGGER.info(String.format("START | END Player Move | game : %s ", gameUuid));
        final Optional<GameDto> gameInstanceOptional = gameService.findById(gameUuid);
        if(!gameInstanceOptional.isPresent()) throw new Exception("Error could find game by uuid "+gameUuid);
        GameDto gameInstance = gameInstanceOptional.get();
          Optional<GameUserRuntimeInfoDto> runtime= gameUserRuntimeInfoService.findById(currentPlayerGameRuntimeInfo.getId());
       if(!runtime.isPresent()) throw new Exception("Error could find runtime by player uuid "+gameInstance.getCurrentPlayerUuid());


        //Start updating GameState

        GameUserRuntimeInfoDto runtimeInfoDto  = runtime.get();
        runtimeInfoDto.setConsiderationTime(currentPlayerGameRuntimeInfo.getConsiderationTime());
        gameUserRuntimeInfoService.updatePatch(runtimeInfoDto);


        String currentPlayerUuid = gameInstance.getCurrentPlayerUuid();
        String nextPlayerUuid = gameInstance.getNextPlayerUuid();
        int round = gameInstance.getRound();

        gameInstance.setNextPlayerUuid(currentPlayerUuid);
        gameInstance.setCurrentPlayerUuid(nextPlayerUuid);

        if(nextPlayerUuid.equals(gameInstance.getFirstPlayerUuid())) {
            gameInstance.setRound((round + 1));
        }


       Optional<GameDto> updatedState= gameService.updatePut(gameInstance);


        LOGGER.info(String.format("STOP | END Player Move | game : %s ", gameUuid));
        return new ResponseEntity<>(Boolean.valueOf(true),HttpStatus.OK);

    }


    public ResponseEntity<?> addMove(String gameUuid, String playerUuid, BasePlayerMoveDto move) throws Exception {
        LOGGER.info(String.format("START | Adding unit move By Name | game : %s | player: %s", gameUuid, playerUuid));


        final Optional<GameDto> gameResponse = gameService.findById(gameUuid, QueryProjection.max);
        if (!gameResponse.isPresent())
            throw new IllegalArgumentException("Game with uuid " + gameUuid + " does not exist");
        final Optional<UserDto> userResponse = userResourceService.findById(playerUuid);
        if (!userResponse.isPresent())
            throw new IllegalArgumentException("User with uuid " + userResponse + " does not exist");
        if (move == null) throw new Exception("Move Item is null!");


        GameDto dto = gameResponse.get();
        GameUserRuntimeInfoDto info = dto.getUserGameUserRuntimeInfo().stream().filter(x -> x.getPlayerUuid().equals(playerUuid)).findFirst().get();
        List<AbstractDto> moves = new ArrayList<>();
        move.setRound(dto.getRound());
        moves.add(move);


        Optional<?> children = gameUserRuntimeInfoService.createChildren(moves, QueryProjection.max);



        AbstractDto savedMove = ((ArrayList<AbstractDto>) children.get()).get(0);
        //TODO Check why it is not possible to set skill cost during creation???
        ((BasePlayerMoveDto) savedMove).setSkillCost(move.getSkillCost());
        ((BasePlayerMoveDto) savedMove).setSkillCost(move.getSkillCost());
        playerMoveEntityService.updatePut((BasePlayerMoveDto) savedMove);

        //Fetch Association targets
        Optional<UnitDto> caster = unitResourceService.findById(move.getCaster().getId(), QueryProjection.def);
        Optional<SkillDto> skill = skillResourceService.findById(move.getSkillDto().getId(), QueryProjection.def);
        Optional<UserDto> user  = userResourceService.findById(move.getUser().getId(),QueryProjection.def);

        //Add associations
        playerMoveEntityService.createAssociation(savedMove.getId(), caster.get(), "caster", QueryProjection.min);
        playerMoveEntityService.createAssociation(savedMove.getId(), skill.get(), "skill", QueryProjection.min);
        playerMoveEntityService.createAssociation(savedMove.getId(),user.get(),"user",QueryProjection.min);

        final List<AbstractDto> childrensList = new ArrayList<>();

        for (AbstractMoveSkillEffectValueDto value:
                move.getEffectValues()) {
            Optional<UnitDto> target = unitResourceService.findById(value.getTarget().getId(), QueryProjection.def);
            value.setTarget(target.get());
            Optional<SkillEffectDto> effectDto = skillEffectsResourceService.findById(value.getEffectDto().getId(),QueryProjection.def);
            value.setEffectDto(effectDto.get());

            if(value instanceof StatSkillPlayerMoveSkillValueDto){




                Optional<StatSkillPlayerMoveSkillValueDto>     createdValue =  statPlayerMoveValueResourceService.create( (StatSkillPlayerMoveSkillValueDto)value);
                childrensList.add(createdValue.get());
            }else if(value instanceof MoveSkillEffectPlayerMoveSkillValueDto){



                Optional<MoveSkillEffectPlayerMoveSkillValueDto>     createdValue =  moveMoveValueResourceService.create( (MoveSkillEffectPlayerMoveSkillValueDto)value);
                childrensList.add(createdValue.get());

            }


            playerMoveEntityService.createAssociation(savedMove.getId() ,childrensList);
            childrensList.clear();
        }


//ADD move to user-runtime!
      Optional<?> updatedParent = gameUserRuntimeInfoService.addChildrenToParent(info, (List<AbstractDto>) children.get(), QueryProjection.max);


        Optional<BasePlayerMoveDto> moveDto = playerMoveEntityService.findById(savedMove.getId(), QueryProjection.max);

        if (!moveDto.isPresent()) throw new Exception("Could not create entry!");

        LOGGER.info(String.format("FINISH | Adding unit move By Name | game : %s | player: %s", gameUuid, playerUuid));

        return new ResponseEntity<>(moveDto, HttpStatus.OK);
    }


    public ResponseEntity<Boolean> updateFogOfWarByPlayerAndGame(final String gameUuid, final String playerUuid, final List<Vector3Int> uncoveredTilePositions) throws Exception {
        if (!gameService.existsById(gameUuid))
            throw new Exception(String.format("Game with uuid %s does not exist", gameUuid));
        if (!userResourceService.existsById(playerUuid))
            throw new Exception(String.format("User with uuid %s does not exist", playerUuid));


        if (uncoveredTilePositions.size() != 0) {

            Optional<GameUserRuntimeInfoDto> info = gameUserRuntimeInfoService.getUserRuntimeInfoByGameUuidAndByPlayerUuid(gameUuid, playerUuid, QueryProjection.min);

            if (!info.isPresent()) return new ResponseEntity<>(false, HttpStatus.OK);


            GameUserRuntimeInfoDto infoDto = info.get();

            uncoveredTilePositions.stream().forEach((x) -> infoDto.addFogOfWarTilePositon(x));

            Optional<GameUserRuntimeInfoDto> updated = gameUserRuntimeInfoService.updatePatch(infoDto);

            if (updated.isPresent()) return new ResponseEntity<>(true, HttpStatus.OK);


        } else {
            LOGGER.info("Enttiy was not updated the list is empty!");
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}