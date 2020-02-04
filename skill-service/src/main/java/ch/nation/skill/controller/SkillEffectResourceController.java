package ch.nation.skill.controller;

import ch.nation.core.controller.AbstractNamedResourceGameLogicController;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.services.AbstractNamedEntityService;
import ch.nation.skill.service.effects.SkillEffectsResourceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping("/skills/effects")

public class SkillEffectResourceController extends AbstractNamedResourceGameLogicController<SkillEffectDto,SkillEffectDto> {


    public SkillEffectResourceController(SkillEffectsResourceServiceImpl service, HttpServletRequest request) {
        super(service,request);
    }


 //   @Override
 //   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

 //   @Override
 //   @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity updatePatch(SkillEffectDto payload) {
        return super.updatePatch(payload);
    }

//    @Override
 //   @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create( SkillEffectDto object) throws Exception {
        return super.create(object);
    }
//    @Override
  //  @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( String uuid) throws Exception {
        return super.delete(uuid);
    }

 //   @Override
//    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(String uuid) {
        return super.findById(uuid);
    }



   // @Override
  //  @RequestMapping(method = RequestMethod.GET,path="/search")
    public ResponseEntity findByName( String name) {
        return super.findByName(name);
    }

  //  @Override
 //   @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection( String uuid,  String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);
    }
   // @Override
  //  @RequestMapping(method = RequestMethod.GET,path="/search/identifier")
    public ResponseEntity findByIdentifier(String identfier, QueryProjection projection) {
        return super.findByIdentifier(identfier, projection);
    }

}
