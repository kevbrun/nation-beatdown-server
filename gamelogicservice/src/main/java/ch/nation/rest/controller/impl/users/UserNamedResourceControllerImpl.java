package ch.nation.rest.controller.impl.users;


        import ch.nation.core.model.Enums.QueryProjection;
        import ch.nation.core.model.dto.AbstractDto;
        import ch.nation.core.model.dto.user.UserDto;
        import ch.nation.rest.controller.impl.AbstractMassNamedResourceGameLogicController;
        import ch.nation.rest.controller.interfaces.UserResourceController;
        import ch.nation.rest.clients.factory.DBRestClientFactory;
        import ch.nation.rest.services.impl.users.UserResourceServiceImpl;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.hateoas.Resources;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserNamedResourceControllerImpl extends AbstractMassNamedResourceGameLogicController<UserDto,UserDto> implements UserResourceController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final DBRestClientFactory factory;

    @Autowired
    public UserNamedResourceControllerImpl(UserResourceServiceImpl client, DBRestClientFactory factory) {
        super(client);
        this.factory = factory;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.getAll(projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity update(@RequestBody UserDto payload,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.update(payload, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json",path="/batch_update")
    public ResponseEntity update(@RequestBody  List<UserDto> payload,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.update(payload, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/batch_delete")
    public ResponseEntity delete(@RequestBody Resources<UserDto> payload,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.delete(payload, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody UserDto object, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.create(object,projection);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/deep_create")
    public ResponseEntity createWithChildren(@RequestBody Map<String,List<AbstractDto>> body, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {

        return super.createWithChildren(body,projection);

    }


        @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.delete(uuid, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.findById(uuid, projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.PUT,path="/{uuid}")
    public ResponseEntity createAssociation(@PathVariable("uuid") String uuid,@RequestBody List<AbstractDto> children,@RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {
        return super.createAssociation(uuid, children, projection);
    }


    //Query API

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/search")
    public ResponseEntity findByName(@RequestParam("name") String name,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.findByName(name, projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection, projection);
    }
}
