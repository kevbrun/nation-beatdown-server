package ch.nation.game.controller;

import ch.nation.core.clients.services.users.UserServiceClient;
import ch.nation.core.controller.AbstractNamedResourceGameLogicController;
import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.user.UserDto;

import ch.nation.game.service.GameResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;


@RestController
public class GameResourceController extends AbstractNamedResourceGameLogicController<GameDto, GameDto> {

    private final UserServiceClient userService;


    @Autowired
    public GameResourceController(final GameResourceServiceImpl service, final UserServiceClient userServiceClient, HttpServletRequest request) {
        super(service, request);
        this.userService = userServiceClient;

    }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") long page, @RequestParam(value = "size", required = false, defaultValue = "20") long size
            , @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.getAll(page, size, projection);
    }


    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
    public ResponseEntity update(@RequestBody GameDto payload, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.updatePatch(payload, projection);
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updatePut(@RequestBody GameDto payload, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.updatePut(payload, projection);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity create(@RequestBody GameDto object, @RequestParam(value = "projection", required = false) QueryProjection projection) throws Exception {
        return super.create(object, projection);
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/{playerUuid}/{playerTwoUuid}", "/{playerUuid}"})
    public ResponseEntity create(@PathVariable("playerUuid") String playerUuid, @PathVariable(value = "playerTwoUuid", required = false) Optional<String> playerTwoUuid, @RequestParam(value = "projection", required = false) QueryProjection projection) throws Exception {


        if (playerTwoUuid.isPresent())
            return ((GameResourceServiceImpl) service).create(getAuthorizationTokenFromHeader(), playerUuid, playerTwoUuid.get(), projection);

        ResponseEntity<UserDto> dummyPlayer = userService.findByName(request.getHeader("Authorization"), "DummyPlayer", QueryProjection.min);

        if (dummyPlayer.getBody() == null) throw new Exception("Could not find Dummy Player in DB!");
        return ((GameResourceServiceImpl) service).create(getAuthorizationTokenFromHeader(), playerUuid, dummyPlayer.getBody().getId(), projection);

    }


    @RequestMapping(method = RequestMethod.GET, path = {"/search/{userUuid}"})
    public ResponseEntity getGamesByUserAndGameStatus(@PathVariable("userUuid") String userUuid, @RequestParam("status") GameStatus status, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        if (userUuid == null) return ResponseEntity.notFound().build();
        if (status.equals(GameStatus.None)) return ResponseEntity.notFound().build();

        Optional<?> response = null;

        if (projection == null) {

            response = ((GameResourceServiceImpl) service).getGamesByUserAndStatus(userUuid, status);

        } else {
            response = ((GameResourceServiceImpl) service).getGamesByUserAndStatus(userUuid, status, projection);
        }
        if (!response.isPresent()) return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        return new ResponseEntity<>(response.get(), HttpStatus.OK);


    }


    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/{uuid}")
    public ResponseEntity delete(@PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid") String uuid, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.findById(uuid, projection);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/search/exists")
    public ResponseEntity<Boolean> entityExists(@RequestParam("uuid") String uuid) {
        return super.entityExists(uuid);
    }

    //@Override
    @RequestMapping(method = RequestMethod.GET, path = "/search")
    //NOT USED
    public ResponseEntity findByName(@RequestParam("name") String name, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.findByName(name, projection);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection, @RequestParam(value = "projection", required = false) QueryProjection projection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection, projection);
    }


}
