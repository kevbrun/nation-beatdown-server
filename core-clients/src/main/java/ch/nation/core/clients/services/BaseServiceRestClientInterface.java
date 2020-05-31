package ch.nation.core.clients.services;


import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface BaseServiceRestClientInterface<TResult, TInput> {

    default String getType() {

        return this.getClass().getName();
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    ResponseEntity<TResult> getAll(@RequestHeader(value = "Authorization", required = false) String token, @RequestParam(value = "projection", required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<TResult> create(@RequestHeader(value = "Authorization", required = false) String token, TInput object, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity create(@RequestHeader(value = "Authorization", required = false) String token, List<TInput> objects, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", path = "/children")
    ResponseEntity<List<AbstractDto>> createChildren(@RequestHeader(value = "Authorization", required = false) String token, List<AbstractDto> children, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", path = "/{uuid}/{resourceCollection}")
    ResponseEntity createAssociation(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("uuid") String uuid, @RequestBody AbstractDto child, @PathVariable("resourceCollection") String resourceCollection, @RequestParam(value = "projection", required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", path = "/{uuid}/{resourceCollection}/batch")
    ResponseEntity createAssociation(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("uuid") String uuid, @RequestBody List<AbstractDto> child, @PathVariable("resourceCollection") String resourceCollection, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", path = "/{uuid}/{resourceCollection}")
    ResponseEntity<List<AbstractDto>> getChildrenByResourceType(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updatePut(@RequestHeader(value = "Authorization", required = false) String token, @RequestBody TInput payload, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json", headers = {"X-HTTP-Method-Override=PATCH"})
    public ResponseEntity updatePatch(@RequestHeader(value = "Authorization", required = false) String token, @RequestBody TInput payload, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET, path = "/{uuid}")
    ResponseEntity<TResult> findById(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("uuid") String uuid, @RequestParam(value = "projection", required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.DELETE, path = "/{uuid}")
    ResponseEntity<?> delete(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("uuid") String uuid, @RequestParam(value = "projection", required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET, path = "/search")
    ResponseEntity<TResult> findByName(@RequestHeader(value = "Authorization", required = false) String token, @RequestParam("name") String name, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET, path = "/search/identifier")
    ResponseEntity<TResult> findByIdentifier(@RequestHeader(value = "Authorization", required = false) String token, @RequestParam("identifier") String identifier, @RequestParam(value = "projection", required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET, path = "/search/exists")
    ResponseEntity<Boolean> existsById(@RequestHeader(value = "Authorization", required = false) String token, @RequestParam("uuid") String uuid);

    @RequestMapping(method = RequestMethod.GET, path = "/search/exists")
    ResponseEntity<Boolean> existsByName(@RequestHeader(value = "Authorization", required = false) String token, @RequestParam("name") String name);


}
