package ch.nation.game.controller;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface IDaoQueryProjectionable {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity getAll(@RequestParam(value = "projection", required = false) Optional<QueryProjection> projection);

    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
    ResponseEntity update(@RequestBody GameDto payload, @RequestParam(value = "projection", required = false) Optional<QueryProjection> projection);

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity create(@RequestBody GameDto object, @RequestParam(value = "projection", required = false) Optional<QueryProjection> projection) throws Exception;

    @RequestMapping(method = RequestMethod.POST, path = {"/{playerUuid}/{playerTwoUuid}", "/{playerUuid}"})
    ResponseEntity create(@PathVariable("playerUuid") String playerUuid, @PathVariable(value = "playerTwoUuid", required = false) Optional<String> playerTwoUuid, @RequestParam(value = "projection", required = false) Optional<QueryProjection> projection) throws Exception;

    @RequestMapping(method = RequestMethod.GET, path = {"/search/{userUuid}"})
    ResponseEntity getGamesByUserAndGameStatus(@PathVariable("userUuid") String userUuid, @RequestParam("status") GameStatus status, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}")
    ResponseEntity findById(@PathVariable("uuid") String uuid, @RequestParam(value = "projection", required = false) Optional<QueryProjection> projection);

    @RequestMapping(method = RequestMethod.GET, path = "/search")
    ResponseEntity findByName(@RequestParam("name") String name, @RequestParam(value = "projection", required = false) Optional<QueryProjection> projection);

    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}/{resourceCollection}")
    ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection, @RequestParam(value = "projection", required = false) Optional<QueryProjection> projection);
}
