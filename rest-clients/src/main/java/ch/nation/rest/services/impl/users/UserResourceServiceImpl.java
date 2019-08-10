package ch.nation.rest.services.impl.users;


import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractMassNamedEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserResourceServiceImpl extends AbstractMassNamedEntityService<UserDto,UserDto> implements UserResourceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public UserResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(UserDto.class,factory, massRestClientFactory);
    }






}
