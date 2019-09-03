package ch.nation.moves.controller;

import ch.nation.core.controller.AbstractResourceGameLogicController;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import ch.nation.moves.service.PlayerMoveResourceServiceImpl;
import ch.nation.moves.service.values.MoveMoveValueResourceServiceImpl;
import ch.nation.moves.service.values.PlayerMoveValueResourceServiceImpl;
import ch.nation.moves.service.values.StatPlayerMoveValueResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/values")
public class PlayerMoveValueResourceController extends AbstractResourceGameLogicController<AbstractMoveSkillEffectValueDto,AbstractMoveSkillEffectValueDto> {
    private final MoveMoveValueResourceServiceImpl moveSkillValueService;
    private final StatPlayerMoveValueResourceServiceImpl statPlayerMoveValueResourceService;


    @Autowired
    public PlayerMoveValueResourceController(PlayerMoveValueResourceServiceImpl service, MoveMoveValueResourceServiceImpl moveSkillValueService, StatPlayerMoveValueResourceServiceImpl statPlayerMoveValueResourceService, StatPlayerMoveValueResourceServiceImpl statPlayerMoveValueResourceService1) {
        super(service);
        this.statPlayerMoveValueResourceService = statPlayerMoveValueResourceService1;
        this.moveSkillValueService = moveSkillValueService;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.getAll(projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity updatePatch(@RequestBody AbstractMoveSkillEffectValueDto payload, @RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.updatePatch(payload,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody AbstractMoveSkillEffectValueDto  object,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.create(object,projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/create-multiple")
    public ResponseEntity create(@RequestBody List<AbstractMoveSkillEffectValueDto> objects, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.create(objects,projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}/batch")
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection, @RequestBody List<AbstractDto> children, @RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.createAssociation(uuid, resourceCollection, children, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}")
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection, AbstractDto child, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.createAssociation(uuid, child, projection);
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


}
