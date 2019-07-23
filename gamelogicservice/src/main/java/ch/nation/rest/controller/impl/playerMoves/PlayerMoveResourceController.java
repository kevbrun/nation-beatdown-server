package ch.nation.rest.controller.impl.playerMoves;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.rest.controller.impl.AbstractResourceGameLogicController;
import ch.nation.rest.services.impl.playerMoves.PlayerMoveResourceServiceImpl;
import feign.RequestLine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/moves")
public class PlayerMoveResourceController extends AbstractResourceGameLogicController<AbstractPlayerMoveDto,AbstractPlayerMoveDto> {



    public PlayerMoveResourceController(PlayerMoveResourceServiceImpl service) {
        super(service);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody AbstractPlayerMoveDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody AbstractPlayerMoveDto object) throws Exception {
        return super.create(object);
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
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);

    }
/**
    @RequestMapping(method = RequestMethod.GET,path="/search/{uuid}/{caster-uuid}/{round}")
    public ResponseEntity getAllMovesOfPlayerByGameRuntimeUUIDAndPlayerUuidAndRound(@PathVariable("uuid")String gameRuntimeUuid, @PathVariable("caster-uuid") String casterUuid, @PathVariable("round") int round, @RequestParam(value = "projection",required = false)QueryProjection projection)
    {

        Optional<?> result =  ((PlayerMoveResourceServiceImpl)service).getMovesByGameRuntimeUuidAndCasterUuidAndRound(gameRuntimeUuid,casterUuid,round,projection);


        return new ResponseEntity<>(result.get(), HttpStatus.OK);

    }**/


}
