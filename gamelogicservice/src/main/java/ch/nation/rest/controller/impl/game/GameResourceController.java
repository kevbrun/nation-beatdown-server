package ch.nation.rest.controller.impl.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.controller.impl.AbstractNamedResourceGameLogicController;
import ch.nation.rest.services.impl.games.GameResourceServiceImpl;
import ch.nation.rest.services.impl.users.UserResourceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/games")
public class GameResourceController extends AbstractNamedResourceGameLogicController<GameDto,GameDto> {

        private final UserResourceServiceImpl userService;

        public GameResourceController(final GameResourceServiceImpl service, UserResourceServiceImpl userService) {
        super(service);
            this.userService = userService;
        }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody GameDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody GameDto object) throws Exception {
        return super.create(object);
    }

    @RequestMapping(method = RequestMethod.POST,path = {"/{playerUuid}/{playerTwoUuid}","/{playerUuid}"})
    public ResponseEntity create(@PathVariable("playerUuid") String playerUuid,@PathVariable(value = "playerTwoUuid",required = false) Optional<String> playerTwoUuid) throws Exception {

            if(playerTwoUuid.isPresent())       return ((GameResourceServiceImpl)service).create(playerUuid,playerTwoUuid.get());

            Optional<UserDto> dummyPlayer =  userService.findByName("DummyPlayer");

            if(!dummyPlayer.isPresent()) throw new Exception("Could not find Dummy Player in DB!");
            return ((GameResourceServiceImpl)service).create(playerUuid,dummyPlayer.get().getId());

    }


    @RequestMapping(method = RequestMethod.GET,path = {"/search/{userUuid}"})
    public ResponseEntity  getGamesByUserAndGameStatus(@PathVariable("userUuid") String userUuid, @RequestParam("status")GameStatus status, @RequestParam(value = "projection",required = false)QueryProjection projection){
            if(userUuid==null) return ResponseEntity.notFound().build();
            if(status.equals(GameStatus.None)) return ResponseEntity.notFound().build();

             Optional<?> response =null;

            if(projection==null){

                response =((GameResourceServiceImpl)service).GetGamesByUserAndStatus(userUuid,status);

            }else{
              response=  ((GameResourceServiceImpl)service).GetGamesByUserAndStatus(userUuid,status,projection);
            }
            if(!response.isPresent()) return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
            return new ResponseEntity<>(response.get(),HttpStatus.OK);


    }


    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }



    @Override
    @RequestMapping(method = RequestMethod.GET,path="/search")
    public ResponseEntity findByName(@RequestParam("name") String name) {
        return super.findByName(name);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);
    }




}
