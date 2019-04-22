package ch.nation.rest.clients;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DBRestServiceBaseInterface<TResult,TResultMult,TInput>  {



    //@RequestMapping(method = RequestMethod.GET)



    @RequestMapping(method = RequestMethod.GET)
    TResultMult getAll();



    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    TResult create(TInput object);

    @RequestMapping(method = RequestMethod.GET,path = "/{uuid}")
    TResult findById(@PathVariable("uuid")String uuid);


    @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
    TResult delete(@PathVariable("uuid")String uuid);


    @RequestMapping(method = RequestMethod.PUT,path="/{uuid}")
    TResult update(@PathVariable("uuid") String uuid, TInput payload);

    @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
    TResult delete(@PathVariable("uuid")String uuid, TInput payload);




    //  @RequestMapping(method = RequestMethod.DELETE,path="/{uuid}")
  //  Resources<Void> delete(@PathVariable("uuid") String uuid);
/**
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    Resource<UserModel> createUserEntity(UserModel entity);

    @RequestMapping(method = RequestMethod.PATCH,consumes = "application/json",path = "/{uuid}")
    Resource<UserModel> updateUserEntity(@PathVariable("uuid") String uuid,@RequestBody UserModel entity);

**/



}
