package ch.nation.rest.clients;


import ch.nation.core.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="nation-database-service")
public interface UserFeignProxy {



    @RequestMapping(method = RequestMethod.GET,value="/users")
    Resources<UserModel> GetAllUsersByModel();


    @RequestMapping(method = RequestMethod.GET,value="/users")
    String GetAllUsers();

}
