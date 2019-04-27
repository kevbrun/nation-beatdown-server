package ch.nation.rest.services.impl;


import ch.nation.core.model.UserModel;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.DBUserRestClient;
import ch.nation.rest.services.interf.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends AbstractGenericEntityService<UserModel,UserModel> implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final DBRestServiceBaseInterface client;

    @Autowired
    public UserServiceImpl(DBUserRestClient client) {

        super(client);
        this.client = client;

    }





}
