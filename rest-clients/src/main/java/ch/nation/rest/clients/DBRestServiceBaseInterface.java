package ch.nation.rest.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface DBRestServiceBaseInterface<TResult,TInput>  {



    //@RequestMapping(method = RequestMethod.GET)



    @RequestMapping(method = RequestMethod.GET)
    Resources<TResult> getAll();



    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<TResult> create(TInput object);

    @RequestMapping(method = RequestMethod.GET,path = "/{uuid}")
    Resource<TResult> findById(@PathVariable("uuid")String uuid);


    @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
    Resource<TResult> delete(@PathVariable("uuid")String uuid);


    @RequestMapping(method = RequestMethod.PUT,path="/{uuid}")
    Resource<TResult> update(@PathVariable("uuid") String uuid, @RequestBody TInput payload);




    //  @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
  //  Resources<Void> delete(@PathVariable("uuid") String uuid);
/**
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<UserDto> createUserEntity(UserDto entity);

    @RequestMapping(method = RequestMethod.PATCH,consumes = "application/json",path = "/{uuid}")
    Resource<UserDto> updateUserEntity(@PathVariable("uuid") String uuid,@RequestBody UserDto entity);

**/



}
