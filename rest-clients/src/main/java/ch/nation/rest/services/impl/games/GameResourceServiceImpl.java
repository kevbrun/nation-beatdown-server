package ch.nation.rest.services.impl.games;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.game.DBGameRestClient;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import ch.nation.rest.services.impl.users.UserResourceServiceImpl;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GameResourceServiceImpl extends AbstractNamedEntityService<GameDto,GameDto> implements GameResourceService {

    private final UserResourceServiceImpl userService;


    public GameResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, UserResourceServiceImpl userService) {
        super(GameDto.class,factory, massRestClientFactory);
        this.userService = userService;
    }


    public ResponseEntity create(String playerOneUuid, String playerTwoUuid, QueryProjection projection) throws Exception {
        LOGGER.info(String.format("START | Create Game | User one %s | User two %s", playerOneUuid,playerTwoUuid));

        Optional<UserDto> playerOne = userService.findById(playerOneUuid);
        if(!playerOne.isPresent()) throw new Error("Player with uuid"+playerOneUuid+"does not exist");
        Optional<UserDto> playerTwo = userService.findById(playerTwoUuid);
        if(!playerTwo.isPresent()) throw new Error("Player with uuid"+playerTwoUuid+"does not exist");



        long considerationTime = 60* 5*1000;



        LOGGER.info("I start to create the game!");
        GameDto gameDto = new GameDto();
        gameDto.setName(playerOne.get().getName()+" vs "+playerTwo.get().getName());
        gameDto.setRound(1);
        gameDto.setFirstPlayerUuid(playerOneUuid);
        gameDto.setNextPlayerUuid(playerTwoUuid);
        gameDto.setCurrentPlayerUuid(playerOneUuid);
        gameDto.setStatus(GameStatus.InProgress);

        List<AbstractDto> children = new ArrayList<>();
        children.add(new GameUserRuntimeInfoDto(playerOneUuid,considerationTime));
        children.add(new GameUserRuntimeInfoDto(playerTwoUuid,considerationTime));

        Optional<GameDto> response = (Optional<GameDto>) createEntityAndCreateChildren(gameDto,children,QueryProjection.max);


        if(!response.isPresent()) throw new Error("Could not create Game!");



        gameDto = (GameDto) response.get();

         LOGGER.info("Add players to game!");
        List<AbstractDto> userList = new ArrayList<>(2);
        userList.add(playerOne.get());
        userList.add(playerTwo.get());

        Optional<GameDto> resource =  createAssociation(gameDto.getId(),userList,projection);

        LOGGER.info("Creation was succesfull!");
        LOGGER.info(String.format("STOP | Create Game | User one %s | User two %s", playerOneUuid,playerTwoUuid));


        return new ResponseEntity(resource.get(),HttpStatus.OK);


    }
    public ResponseEntity create(String playerOneUuid, String playerTwoUuid) throws Exception {
        return create(playerOneUuid,playerTwoUuid, QueryProjection.def);

    }


    public Resources<GameUserRuntimeInfoDto> getUserRuntimeInfos(String gameUuid){
        return (Resources<GameUserRuntimeInfoDto>) getChildren(gameUuid,"user-runtimes",QueryProjection.max);
    }


    public Resource<GameUserRuntimeInfoDto> getUserRuntimeInfoByPlayer(String gameUuid,String playerUuid){
        return (Resource<GameUserRuntimeInfoDto>) getUserRuntimeInfos(gameUuid).getContent().stream().filter((x)-> x.getPlayerUuid().equals(playerUuid));
    }

    @Override
    public Optional<Collection<GameDto>> getGamesByUserAndStatus(String userUuid, GameStatus status, QueryProjection projection) {
        LOGGER.info(String.format("START | Get Game by player and state | User  %s | Status two %s", userUuid,status));
        Resources<GameDto>  dto= ((DBGameRestClient)getDefaultClient()).GetGameByUserAndGameStatus(userUuid,status,QueryProjection.max);
        if(dto==null) {
            LOGGER.info("Could not find games for given user or status! Empty List will be returned");
            return Optional.of(new ArrayList<GameDto>());
        }
        LOGGER.info(String.format("STOP | Get Game by player and state | User  %s | Status two %s", userUuid,status));
        return Optional.of(dto.getContent());
    }

    @Override
    public Optional<Collection<GameDto>> getGamesByUserAndStatus(String userUuid, GameStatus status) {
        return getGamesByUserAndStatus(userUuid,status,QueryProjection.def);
    }

    @Override
    public Optional<Collection<GameDto>> getGamesByUserAndStatus(UserDto user, GameStatus status, QueryProjection projection) {
        return getGamesByUserAndStatus(user.getId(),status,projection);
    }

    @Override
    public Optional<Collection<GameDto>> getGamesByUserAndStatus(UserDto user, GameStatus status) {
        return getGamesByUserAndStatus(user,status,QueryProjection.def);
    }
}
