package ch.nation.rest.logic.controller;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.services.impl.games.GameResourceServiceImpl;
import ch.nation.rest.services.impl.games.GameUserRuntimeInfoServiceImpl;
import ch.nation.rest.services.impl.playerMoves.PlayerMoveResourceServiceImpl;
import ch.nation.rest.services.impl.skills.SkillResourceServiceImpl;
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


    @Autowired
    public GameLogicService(final GameResourceServiceImpl gameService, final PlayerMoveResourceServiceImpl playerMoveEntityService, final UserResourceServiceImpl userResourceService, UnitResourceServiceImpl unitResourceService, GameUserRuntimeInfoServiceImpl gameUserRuntimeInfoService, SkillResourceServiceImpl skillResourceService) {
        this.gameService = gameService;
        this.playerMoveEntityService = playerMoveEntityService;
        this.userResourceService = userResourceService;
        this.unitResourceService = unitResourceService;
        this.gameUserRuntimeInfoService = gameUserRuntimeInfoService;
        this.skillResourceService = skillResourceService;
    }



     public ResponseEntity<?> addMove(String gameUuid, String playerUuid, BasePlayerMoveDto move) throws Exception {
         LOGGER.info(String.format("START | Adding unit move By Name | game : %s | player: %s", gameUuid,playerUuid));


     final Optional<GameDto> gameResponse= gameService.findById(gameUuid, QueryProjection.max);
     if(!gameResponse.isPresent()) throw new IllegalArgumentException("Game with uuid "+gameUuid+" does not exist");
     final Optional<UserDto> userResponse = userResourceService.findById(playerUuid);
     if(!userResponse.isPresent()) throw new IllegalArgumentException("User with uuid "+userResponse+" does not exist");
     if(move==null) throw new Exception("Move Item is null!");



        GameDto dto = gameResponse.get();
        GameUserRuntimeInfoDto info = dto.getUserGameUserRuntimeInfo().stream().filter(x-> x.getPlayerUuid().equals(playerUuid)).findFirst().get();
        List<AbstractDto> moves = new ArrayList<>();
        moves.add(move);
        Optional<?>  children=    gameUserRuntimeInfoService.createChildren(moves,QueryProjection.max);

        AbstractDto savedMove = ((ArrayList<AbstractDto>)children.get()).get(0);


        Optional<UnitDto> caster = unitResourceService.findById(move.getCaster().getId(),QueryProjection.def);
        Optional<UnitDto> target = unitResourceService.findById(move.getTarget().getId(),QueryProjection.def);
        Optional<SkillDto> skill = skillResourceService.findById(move.getSkillDto().getId(),QueryProjection.def);
        playerMoveEntityService.createAssociation(savedMove.getId(),caster.get(),"caster",QueryProjection.min);
        playerMoveEntityService.createAssociation(savedMove.getId(),target.get(),"target",QueryProjection.min);
        playerMoveEntityService.createAssociation(savedMove.getId(),skill.get(),"skill",QueryProjection.min);
        List<AbstractDto> values = new ArrayList<>(move.getEffectValues());
        playerMoveEntityService.createChildrenAndAddToParent((BasePlayerMoveDto) savedMove, values,QueryProjection.max);




       Optional<?> updatedParent= gameUserRuntimeInfoService.addChildrenToParent(info, (List<AbstractDto>) children.get(),QueryProjection.max);



       Optional<BasePlayerMoveDto> moveDto = playerMoveEntityService.findById(savedMove.getId(),QueryProjection.max);

     if(!updatedParent.isPresent()) throw new Exception("Could not create entry!");

     LOGGER.info(String.format("FINISH | Adding unit move By Name | game : %s | player: %s", gameUuid,playerUuid));

         return new ResponseEntity<>(moveDto,HttpStatus.OK);
     }
}