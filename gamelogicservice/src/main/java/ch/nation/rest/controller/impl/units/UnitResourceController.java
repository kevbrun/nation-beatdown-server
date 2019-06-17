package ch.nation.rest.controller.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.units.DBMassRestUnitRestClient;
import ch.nation.rest.clients.units.DBRestUnitRestClient;
import ch.nation.rest.controller.impl.AbstractMassResourceGameLogicController;
import ch.nation.rest.services.impl.AbstractMassGenericEntityService;
import ch.nation.rest.services.impl.units.UnitService;
import ch.nation.rest.services.impl.units.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UnitResourceController extends AbstractMassResourceGameLogicController<UnitDto,UnitDto> {



    @Autowired
    public UnitResourceController(UnitServiceImpl client) {
        super(client);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/units")
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path = "/rest/api/v1/units")
    public ResponseEntity update(@RequestBody UnitDto payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/units/batch_update")
    public ResponseEntity update(@RequestBody List<UnitDto> payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/rest/api/v1/units/batch_delete")
    public ResponseEntity delete(@RequestBody Resources<UnitDto> payload) {
        return super.delete(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/units")
    public ResponseEntity create(@RequestBody UnitDto object) throws Exception {
        return super.create(object);
    }
    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/rest/api/v1/units/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/units/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }





}
