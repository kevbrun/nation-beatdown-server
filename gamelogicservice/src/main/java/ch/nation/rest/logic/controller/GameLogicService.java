package ch.nation.rest.logic.controller;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.services.impl.games.GameResourceServiceImpl;
import ch.nation.rest.services.impl.playerMoves.PlayerMoveResourceServiceImpl;
import ch.nation.rest.services.impl.users.UserResourceService;
import ch.nation.rest.services.impl.users.UserResourceServiceImpl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GameLogicService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final GameResourceServiceImpl gameService;
    private final PlayerMoveResourceServiceImpl playerMoveEntityService;
    private final UserResourceServiceImpl userResourceService;


    @Autowired
    public GameLogicService(final GameResourceServiceImpl gameService, final PlayerMoveResourceServiceImpl playerMoveEntityService, final UserResourceServiceImpl userResourceService) {
        this.gameService = gameService;
        this.playerMoveEntityService = playerMoveEntityService;
        this.userResourceService = userResourceService;
    }



     public ResponseEntity<?> addMove(String gameUuid, String playerUuid, AbstractPlayerMoveDto move) throws Exception {
         LOGGER.info(String.format("START | Adding unit move By Name | game : %s | player: %s", gameUuid,playerUuid));


     final Optional<GameDto> gameResponse= gameService.findById(gameUuid);
     if(!gameResponse.isPresent()) throw new IllegalArgumentException("Game with uuid "+gameUuid+" does not exist");
     final Optional<UserDto> userResponse = userResourceService.findById(playerUuid);
     if(!userResponse.isPresent()) throw new IllegalArgumentException("User with uuid "+userResponse+" does not exist");
     if(move==null) throw new Exception("Move Item is null!");







     final Optional<BasePlayerMoveDto> resp =     playerMoveEntityService.create((BasePlayerMoveDto) move, QueryProjection.max);


     if(!resp.isPresent()) throw new Exception("Could not create entry!");
    List<AbstractDto> moves = new ArrayList<>(1);
    moves.add(resp.get());

     Optional<GameDto> response =    gameService.createAssociation(gameUuid,moves, QueryProjection.max);

     LOGGER.info(String.format("FINISH | Adding unit move By Name | game : %s | player: %s", gameUuid,playerUuid));

     return new ResponseEntity<>(response,HttpStatus.OK);

     }
}