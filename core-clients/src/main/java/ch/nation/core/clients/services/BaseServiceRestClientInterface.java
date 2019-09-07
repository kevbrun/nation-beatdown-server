package ch.nation.core.clients.services;


import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public interface BaseServiceRestClientInterface<TResult,TInput>  {

    default String getType(){

        return this.getClass().getName();
    }

    @RequestMapping(method = RequestMethod.GET,path = "")
    ResponseEntity<TResult> getAll(@RequestParam(value = "projection", required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity<TResult> create(TInput object, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity create(List<TInput> objects, @RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/children")
    ResponseEntity<List<AbstractDto>> createChildren(List<AbstractDto> children, @RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}")
    ResponseEntity createAssociation(@PathVariable("uuid") String uuid, @RequestBody AbstractDto child, @PathVariable("resourceCollection") String resourceCollection,  @RequestParam(value = "projection",required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}/batch")
    ResponseEntity createAssociation(@PathVariable("uuid") String uuid,@RequestBody List<AbstractDto> child, @PathVariable("resourceCollection") String resourceCollection,  @RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.GET,consumes = "application/json",path = "/{uuid}/{resourceCollection}")
    ResponseEntity<List<AbstractDto>> getChildrenByResourceType(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection,  @RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.PUT,consumes = "application/json")
    public ResponseEntity updatePut(@RequestBody TInput payload, @RequestParam(value = "projection", required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.PATCH,consumes = "application/json",headers = {"X-HTTP-Method-Override=PATCH"})
    public ResponseEntity updatePatch(@RequestBody TInput payload, @RequestParam(value = "projection", required = false) QueryProjection projection);

        @RequestMapping(method = RequestMethod.GET,path = "/{uuid}")
        ResponseEntity<TResult> findById(@PathVariable("uuid") String uuid, @RequestParam(value = "projection", required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
    ResponseEntity<?> delete(@PathVariable("uuid") String uuid, @RequestParam(value = "projection", required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.GET,path="/search")
        ResponseEntity<TResult> findByName(@RequestParam("name") String name, @RequestParam(value = "projection", required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.GET,path = "/search/exists")
        ResponseEntity<Boolean> existsById(@RequestParam("uuid") String uuid);

    @RequestMapping(method = RequestMethod.GET,path = "/search/exists")
    ResponseEntity<Boolean> existsByName(@RequestParam("name") String name);





}
