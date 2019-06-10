package ch.nation.rest.clients;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

public interface DBRestMassServiceBaseInterface<TResult,TInput>   {


        @RequestMapping(method = RequestMethod.POST,path="/update-batch")
    Resources<TResult> updateBatch(@RequestBody Collection<TInput> payload);

    @RequestMapping(method = RequestMethod.DELETE,path="/delete-batch")
    Resource<Boolean> deleteBatch(@RequestBody Collection<TInput> payload);
}
