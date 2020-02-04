package ch.nation.user.controller;


        import ch.nation.core.controller.AbstractMassNamedResourceGameLogicController;
        import ch.nation.core.model.Enums.QueryProjection;
        import ch.nation.core.model.dto.AbstractDto;
        import ch.nation.core.model.dto.user.UserDto;
        import ch.nation.core.controller.interfaces.UserResourceController;
        import ch.nation.core.clients.db.factory.DBRestClientFactory;
        import ch.nation.user.service.UserResourceServiceImpl;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.hateoas.Resources;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.web.bind.annotation.*;

        import javax.servlet.http.HttpServletRequest;
        import java.util.List;
        import java.util.Map;

@RestController
public class UserController extends AbstractMassNamedResourceGameLogicController<UserDto,UserDto> implements UserResourceController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final DBRestClientFactory factory;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    public UserController(UserResourceServiceImpl client, DBRestClientFactory factory,HttpServletRequest request) {
        super(client,request);
        this.factory = factory;

    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(@RequestParam(value = "page",required = false,defaultValue = "0") long page, @RequestParam(value = "size",required = false,defaultValue = "20") long size
                                 ,@RequestParam(value = "projection",required = false) QueryProjection projection) {
        LOGGER.info("Request: "+request.toString());
        return super.getAll(page,size,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity updatePatch(@RequestBody UserDto payload, @RequestParam(value = "projection",required = false) QueryProjection projection) {
        return super.updatePatch(payload, projection);
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
    @RequestMapping(method = RequestMethod.DELETE,path   = "/{uuid}")
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



//TODO Check why sometimes it works to unwrap without doing somehting

    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}",produces = "application/json")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection,@RequestParam(value = "projection",required = false) QueryProjection projection, @RequestParam(value="hal",required = false,defaultValue = "false") boolean returnAsHal) {

            return super.getChildrenNodesByResourceCollection(uuid, resourceCollection, projection);

        }



    @RequestMapping(method = RequestMethod.GET,path="/search/exists")
    public ResponseEntity<Boolean> exists(@RequestParam(value = "name",required = false)String name,@RequestParam(value = "uuid",required = false)String uuid){
        if(uuid!=null && !uuid.isBlank()) return super.entityExists(uuid);
        if(name!=null && !name.isBlank()) return super.existsByName(name);
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
