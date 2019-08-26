package ch.nation.core.clients.db;

import ch.nation.core.model.Enums.QueryProjection;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface DBRestMassServiceBaseInterface<TResult,TInput>   {

    default String getType(){

        return this.getClass().getName();
    }


        @RequestMapping(method = RequestMethod.POST,path="/update-batch")
    Resources<TResult> updateBatch(@RequestBody Collection<TInput> payload, @RequestParam(value = "projection",required = false) QueryProjection projection);

    @RequestMapping(method = RequestMethod.DELETE,path="/delete-batch")
    Resource<Boolean> deleteBatch(@RequestBody Collection<TInput> payload,@RequestParam(value = "projection",required = false) QueryProjection projection);
}
