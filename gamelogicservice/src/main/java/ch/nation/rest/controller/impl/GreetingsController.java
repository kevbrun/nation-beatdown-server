package ch.nation.rest.controller.impl;

import ch.nation.core.model.UserModel;
import ch.nation.rest.controller.feign.proxy.UserFeignProxy;
import ch.nation.rest.controller.interfaces.GreetingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GreetingsController implements GreetingController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.application.name}")
    private String appName;


   final UserFeignProxy client;

    @Autowired
    public GreetingsController(UserFeignProxy client) {
        this.client = client;
    }

    @Override
    public String greeting() {

       String d = client.GetAllUsers();
        Resources<UserModel> susers = client.GetAllUsersByModel();
        Collection<UserModel> col = susers.getContent();

        LOGGER.info(col.toString());
       return d ;


   // return "hallo welt";
    }
}



