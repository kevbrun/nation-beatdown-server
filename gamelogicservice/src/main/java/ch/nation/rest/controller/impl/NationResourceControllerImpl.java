package ch.nation.rest.controller.impl;

import ch.nation.core.model.NationModel;
import ch.nation.rest.controller.interfaces.NationResourceControllerInterface;
import ch.nation.rest.services.impl.NationServiceImpl;
import ch.nation.rest.services.interf.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class NationResourceControllerImpl extends AbstractResourceGameLogicController<NationModel,NationModel> implements NationResourceControllerInterface {


    private final NationService service;

    @Autowired
    public NationResourceControllerImpl(NationServiceImpl service) {
        super(service);
        this.service = service;
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path = "/rest/api/v1/nations")
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/rest/api/v1/nations")
    public ResponseEntity update(@RequestBody NationModel payload) {
        return super.update(payload);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/rest/api/v1/nations")
    public ResponseEntity create(@RequestBody NationModel object) throws Exception {
        return super.create(object);
    }


    @Override
    @RequestMapping(method = RequestMethod.DELETE,consumes = "application/json",path = "/rest/api/v1/nations/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/rest/api/v1/nations/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }
}
