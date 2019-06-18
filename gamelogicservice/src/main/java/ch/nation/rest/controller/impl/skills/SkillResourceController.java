package ch.nation.rest.controller.impl.skills;

import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.controller.impl.AbstractResourceGameLogicController;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import ch.nation.rest.services.impl.skills.SkillService;
import ch.nation.rest.services.impl.skills.SkillServiceImpl;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillResourceController extends AbstractResourceGameLogicController<SkillDto,SkillDto> {


    public SkillResourceController(SkillServiceImpl service) {
        super(service);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody SkillDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody SkillDto object) throws Exception {
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
    @RequestMapping(method = RequestMethod.GET,path="/search")
    public ResponseEntity findByName(@RequestParam("name") String name) {
        return super.findByName(name);
    }



}
