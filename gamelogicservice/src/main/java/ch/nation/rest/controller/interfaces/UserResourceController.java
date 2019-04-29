package ch.nation.rest.controller.interfaces;

import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserResourceController {

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", path="/rest/api/v1/users/{user_uuid}/nation")
    ResponseEntity associateWithNation(@PathVariable("user_uuid") String uuid, @RequestBody NationModel nationUri) throws Exception;
    @RequestMapping(method = RequestMethod.GET, path="/rest/api/v1/users/{user_uuid}/nation")
    ResponseEntity getNation(@PathVariable("user_uuid")  String uuid);
}
