package ch.nation.rest.services.impl.games;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import ch.nation.rest.services.impl.users.UserServiceImpl;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GameServiceImpl extends AbstractGenericEntityService<GameDto,GameDto> implements GameService {

    private final UserServiceImpl userService;

    public GameServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, UserServiceImpl userService) {
        super(GameDto.class,factory, massRestClientFactory);
        this.userService = userService;
    }


    public ResponseEntity create(String playerOneUuid, String playerTwoUuid, QueryProjection projection) throws Exception {
       Optional<UserDto> playerOne = userService.findById(playerOneUuid);
        if(!playerOne.isPresent()) throw new Error("Player with uuid"+playerOneUuid+"does not exist");
        Optional<UserDto> playerTwo = userService.findById(playerTwoUuid);
        if(!playerTwo.isPresent()) throw new Error("Player with uuid"+playerTwoUuid+"does not exist");


        LOGGER.info("I start to create the game!");
        GameDto gameDto = new GameDto();
        gameDto.setName(playerOne.get().getName()+" vs "+playerTwo.get().getName());


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
