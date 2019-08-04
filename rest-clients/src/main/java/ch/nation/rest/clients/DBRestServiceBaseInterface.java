package ch.nation.rest.clients;


import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zipkin2.internal.Trace;


import javax.management.Query;
import java.util.List;


public interface DBRestServiceBaseInterface<TResult,TInput>  {

    default String getType(){

        return this.getClass().getName();
    }

    @RequestMapping(method = RequestMethod.GET,path = "")
    Resources<TResult> getAll(@RequestParam(value = "projection",required = false) QueryProjection projection);




    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<TResult> create(TInput object,@RequestParam(value = "projection",required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.GET,path = "/{uuid}")
    Resource<TResult> findById(@PathVariable("uuid")String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
    ResponseEntity<?> delete(@PathVariable("uuid")String uuid,@RequestParam(value = "projection",required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.GET,path="/search/findByName")
    Resource<TResult> findByName(@RequestParam("name")String name,@RequestParam(value = "projection",required = false) QueryProjection projection);





    @RequestMapping(method = RequestMethod.PATCH,path="/{uuid}")
    Resource<TResult> updatePatch(@PathVariable("uuid") String uuid, @RequestBody TInput payload, @RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.PUT,path="/{uuid}")
    Resource<TResult> updatePut(@PathVariable("uuid") String uuid, @RequestBody TInput payload, @RequestParam(value = "projection",required = false) QueryProjection projection);


    //TODO PUT PATCH OR POST?
    @RequestMapping(method = RequestMethod.PATCH,path = "/{parent_uuid}/{resource}",consumes = "text/uri-list")
    ResponseEntity<Resource<TResult>> createAssocationsPatch(@PathVariable("parent_uuid")String uuid, @PathVariable("resource")String resource, @RequestBody String links,@RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.PUT ,path = "/{parent_uuid}/{resource}",consumes = "text/uri-list")
    ResponseEntity<Resource<TResult>> createAssocationsPut(@PathVariable("parent_uuid")String uuid, @PathVariable("resource")String resource, @RequestBody String links,@RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.POST ,path = "/{parent_uuid}/{resource}",consumes = "text/uri-list")
    ResponseEntity<Resource<TResult>> createAssocationsPost(@PathVariable("parent_uuid")String uuid, @PathVariable("resource")String resource, @RequestBody String links,@RequestParam(value = "projection",required = false) QueryProjection projection);



    @RequestMapping(method = RequestMethod.GET,path="/{parent_uuid}/{resource}")
    Resources<AbstractDto> getChildrenEntities(@PathVariable("parent_uuid")String uuid, @PathVariable("resource") String resource, @RequestParam(value = "projection",required = false) QueryProjection projection);
    @RequestMapping(method = RequestMethod.GET,path="/{parent_uuid}/{resource}")
    Resource<AbstractDto> getChildEntity(@PathVariable("parent_uuid")String uuid, @PathVariable("resource") String resource, @RequestParam(value = "projection",required = false) QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET,path="/search/existsById")
    Resource<Boolean> existsById(@RequestParam("id") String id, @RequestParam(value="projection",required = false)QueryProjection projection);


    @RequestMapping(method = RequestMethod.GET,path="/search/existsByName")
    Boolean existsByName(@RequestParam("name") String name);



    //  @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
  //  Resources<Void> delete(@PathVariable("uuid") String uuid);
/**
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<UserDto> createUserEntity(UserDto entity);

    @RequestMapping(method = RequestMethod.PATCH,consumes = "application/json",path = "/{uuid}")
    Resource<UserDto> updateUserEntity(@PathVariable("uuid") String uuid,@RequestBody UserDto entity);

**/



}
