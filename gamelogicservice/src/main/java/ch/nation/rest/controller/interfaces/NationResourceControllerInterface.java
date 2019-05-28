package ch.nation.rest.controller.interfaces;

import ch.nation.core.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface NationResourceControllerInterface {

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json",path="/rest/api/v1/nations/{nation_uuid}/user")
    ResponseEntity createAssociationWithUser(@PathVariable("nation_uuid") String uuid, @RequestBody UserDto userUri) throws Exception;
    @RequestMapping(method = RequestMethod.GET, path="/rest/api/v1/nations/{nation_uuid}/user")
    ResponseEntity getUserAssociatedWithNation(@PathVariable("nation_uuid")  String uuid);

}
