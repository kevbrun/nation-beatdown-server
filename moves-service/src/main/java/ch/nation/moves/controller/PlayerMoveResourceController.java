package ch.nation.moves.controller;

import ch.nation.core.controller.AbstractResourceGameLogicController;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;

import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.services.AbstractEntityService;
import ch.nation.moves.service.PlayerMoveResourceServiceImpl;
import ch.nation.moves.service.SkillPlayerMoveResourceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PlayerMoveResourceController extends AbstractResourceGameLogicController<AbstractPlayerMoveDto,AbstractPlayerMoveDto> {

    private final SkillPlayerMoveResourceServiceImpl skillService;



    public PlayerMoveResourceController(PlayerMoveResourceServiceImpl service, SkillPlayerMoveResourceServiceImpl skillService) {
        super(service);
        this.skillService = skillService;
    }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.getAll(projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity updatePatch(@RequestBody AbstractPlayerMoveDto payload, @RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.updatePatch(payload,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT,consumes ="application/json")
    public ResponseEntity updatePut(@RequestBody AbstractPlayerMoveDto payload, @RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.updatePut(payload, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody AbstractPlayerMoveDto object,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.create(object,projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/create-multiple")
    public ResponseEntity create(@RequestBody List<AbstractPlayerMoveDto> objects, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.create(objects,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/batch")
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid, @RequestBody List<AbstractDto> children,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.createAssociation(uuid, children, projection);
    }
   /** @Override
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid,String  @RequestBody AbstractDto child, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.createAssociation(uuid, child, projection);
    }**/

   @Override
   @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}/batch")
   public ResponseEntity createAssociation(@PathVariable("uuid") String uuid,@PathVariable("resourceCollection") String resourceCollection,  @RequestBody List<AbstractDto> child, @RequestParam(value = "projection",required = false) QueryProjection projection)   {
       return super.createAssociation(uuid, resourceCollection, child, projection);
   }


    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}")
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid,@PathVariable("resourceCollection") String resourceCollection,  @RequestBody AbstractDto child, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.createAssociation(uuid, resourceCollection, child, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.delete(uuid,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.findById(uuid,projection);
    }



    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection,projection);

    }

    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}/{caster-uuid}/{round}")
    public ResponseEntity getAllMovesOfPlayerByGameRuntimeUUIDAndPlayerUuidAndRound(@PathVariable("uuid")String gameRuntimeUuid, @PathVariable("caster-uuid") String casterUuid, @PathVariable("round") int round, @RequestParam(value = "projection",required = false)QueryProjection projection)
    {

        Optional<?> result =  ((PlayerMoveResourceServiceImpl)service).getMovesByGameRuntimeUuidAndCasterUuidAndRound(gameRuntimeUuid,casterUuid,round,projection);


        return new ResponseEntity<>(result.get(), HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}")
    public ResponseEntity getAllMovesOfPlayerByGameRuntimeUUID(@PathVariable("uuid")String gameRuntimeUuid, @RequestParam(value = "unit",required = false)String unitUuid, @RequestParam(value = "projection",required = false)QueryProjection projection){
        Optional<?> result = null;
        if(unitUuid!=null && !unitUuid.isEmpty()) {
            result = ((PlayerMoveResourceServiceImpl) service).getMovesByGameRuntimeInfoAndUnit(gameRuntimeUuid, unitUuid, projection);

        }else{

             result =  ((PlayerMoveResourceServiceImpl)service).getMovesByGameRuntimeInfo(gameRuntimeUuid,projection);
        }
        return new ResponseEntity<>(result.get(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path="/search/runtime/{uuid}/round")
    public ResponseEntity getMovesByGameRuntimeAndCooldownCounterGraterThan(@PathVariable("uuid")String gameRuntimeUuid, @RequestParam(value = "counter",required = false,defaultValue = "0") int counter, @RequestParam(value = "projection",required = false)QueryProjection projection){


        Optional<?> foundObjects= skillService.getMovesByGameRuntimeAndCooldownCounterGraterThan(gameRuntimeUuid,counter,projection);


        return new ResponseEntity<>(foundObjects.get(),HttpStatus.OK);

    }


    @Override
    protected AbstractEntityService GetServiceByBody(AbstractDto dto) {
        if(dto instanceof SkillPlayerMoveDto) return skillService;
        return service;
    }









}
