package ch.nation.rest.services.impl;


import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.DBNationRestClient;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.DBUserRestClient;
import ch.nation.rest.services.interf.NationService;
import ch.nation.rest.services.interf.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends AbstractGenericEntityService<UserDto,UserDto> implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    private final DBRestServiceBaseInterface userClient;
    private final DBRestServiceBaseInterface nationClient;
    private final NationService nationService;

    @Autowired
    public UserServiceImpl(DBUserRestClient client, DBNationRestClient nationClient,NationServiceImpl nationService) {

        super(client);
        this.userClient = client;
        this.nationClient = nationClient;
        this.nationService = nationService;

    }


    @Override
    public Optional<UserDto> createAssociationWithNation(String userUuid, String nationUuid) throws Exception {
     Optional<NationDto> nationModel=   nationService.createAssociationWithUser(nationUuid,userUuid);
     if(!nationModel.isPresent()){
         return Optional.empty();
     }        Optional<UserDto> user=   findById(userUuid);
        return user;
    }

    @Override
    public Optional<NationDto> getNationAssociatedWithNation(String nationUuid) {
        return ((NationServiceImpl)nationService).findById(nationUuid);
    }
}
