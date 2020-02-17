package ch.nation.user.service;


import ch.nation.core.clients.services.users.UserServiceClient;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;

import ch.nation.core.model.dtoWrapper.SimpleResourceDto;
import ch.nation.core.services.AbstractMassNamedEntityService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UserResourceServiceImpl extends AbstractMassNamedEntityService<UserDto,UserDto> implements UserResourceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final BCryptPasswordEncoder encoder;


    @Autowired
    public UserResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, BCryptPasswordEncoder encoder) {
        super(UserDto.class, factory, massRestClientFactory);
        this.encoder = encoder;
    }
}
