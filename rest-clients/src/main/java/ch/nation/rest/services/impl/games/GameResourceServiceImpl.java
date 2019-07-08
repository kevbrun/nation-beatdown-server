package ch.nation.rest.services.impl.games;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import ch.nation.rest.services.impl.users.UserResourceServiceImpl;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GameResourceServiceImpl extends AbstractNamedEntityService<GameDto,GameDto> implements GameResourceService {

    private final UserResourceServiceImpl userService;

    public GameResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, UserResourceServiceImpl userService) {
        super(GameDto.class,factory, massRestClientFactory);
        this.userService = userService;
    }



    public ResponseEntity endTurn(String gameUuid, GameDto gameState){
        LOGGER.info(String.format("*** START | End Turn for game {} ***",gameUuid));










        LOGGER.info(String.format("*** STOP | End Turn for game {} ***",gameUuid));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity create(String playerOneUuid, String playerTwoUuid, QueryProjection projection) throws Exception {
       Optional<UserDto> playerOne = userService.findById(playerOneUuid);
        if(!playerOne.isPresent()) throw new Error("Player with uuid"+playerOneUuid+"does not exist");
        Optional<UserDto> playerTwo = userService.findById(playerTwoUuid);
        if(!playerTwo.isPresent()) throw new Error("Player with uuid"+playerTwoUuid+"does not exist");


        LOGGER.info("I start to create the game!");
        GameDto gameDto = new GameDto();
        gameDto.setName(playerOne.get().getName()+" vs "+playerTwo.get().getName());
        gameDto.setRound(1);
        gameDto.setFirstPlayerUuid(playerOneUuid);
        gameDto.setNextPlayerUuid(playerTwoUuid);
        gameDto.setCurrentPlayerUuid(playerOneUuid);

        Resource<GameDto> response = getDefaultClient().create(gameDto,projection);

        if(response.getContent()==null) throw new Error("Could not create Game!");



        gameDto = response.getContent();

        LOGGER.info("Add players to game!");
        List<AbstractDto> userList = new ArrayList<>(2);
        userList.add(playerOne.get());
        userList.add(playerTwo.get());

        Optional<GameDto> resource =  createAssociation(gameDto.getId(),userList);

        LOGGER.info("Creation was succesfull!");
        return new ResponseEntity(resource.get(),HttpStatus.OK);


    }
    public ResponseEntity create(String playerOneUuid, String playerTwoUuid) throws Exception {
        return create(playerOneUuid,playerTwoUuid, QueryProjection.def);

    }

}