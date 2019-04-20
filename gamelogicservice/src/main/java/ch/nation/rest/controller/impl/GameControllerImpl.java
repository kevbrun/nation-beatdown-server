package ch.nation.rest.controller.impl;

import ch.nation.rest.clients.DBRestClient;
import ch.nation.rest.controller.interfaces.GameController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameControllerImpl implements GameController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


   final DBRestClient client;

    @Autowired
    public GameControllerImpl(DBRestClient client) {
        this.client = client;
    }


}



