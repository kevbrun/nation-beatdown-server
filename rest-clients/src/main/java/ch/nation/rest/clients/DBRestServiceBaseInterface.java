package ch.nation.rest.clients;


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



import java.util.List;


public interface DBRestServiceBaseInterface<TResult,TInput>  {

    default String getType(){

        return this.getClass().getName();
    }

    @RequestMapping(method = RequestMethod.GET)
    Resources<TResult> getAll();



    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<TResult> create(TInput object);

    @RequestMapping(method = RequestMethod.GET,path = "/{uuid}")
    Resource<TResult> findById(@PathVariable("uuid")String uuid);


    @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
    ResponseEntity<?> delete(@PathVariable("uuid")String uuid);

    @RequestMapping(method = RequestMethod.GET,path="/search/findByName")
    Resource<TResult> findByName(@RequestParam("name")String name);

    //TODO PUT OR PATCH?
    @RequestMapping(method = RequestMethod.PATCH,path="/{uuid}")
    Resource<TResult> update(@PathVariable("uuid") String uuid, @RequestBody TInput payload);


    @RequestMapping(method = RequestMethod.PUT,path = "/{parent_uuid}/{resource}",consumes = "text/uri-list")
    ResponseEntity<Resource<TResult>> createAssocations(@PathVariable("parent_uuid")String uuid, @PathVariable("resource")String resource, @RequestBody String links);

    //  @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
  //  Resources<Void> delete(@PathVariable("uuid") String uuid);
/**
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<UserDto> createUserEntity(UserDto entity);

    @RequestMapping(method = RequestMethod.PATCH,consumes = "application/json",path = "/{uuid}")
    Resource<UserDto> updateUserEntity(@PathVariable("uuid") String uuid,@RequestBody UserDto entity);

**/



}
