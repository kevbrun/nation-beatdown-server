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
        super(UserDto.class,factory, massRestClientFactory);
        this.encoder = encoder;
    }


    @Override
    public Optional<UserDto> create(UserDto object) throws Exception {
        HashPasswordIfNeeded(object);

        return super.create(object);
    }


    @Override
    public Optional<UserDto> create(UserDto object, QueryProjection projection) throws Exception {
        HashPasswordIfNeeded(object);
        return super.create(object, projection);
    }

    @Override
    public Optional<List<AbstractDto>> createChildren(List<AbstractDto> children, QueryProjection projection) throws Exception {
        for(int idx = 0; idx < children.size();idx++){
            if(children.get(idx) instanceof UserDto){
                HashPasswordIfNeeded((UserDto)children.get(idx));
                break;
            }
        }

        return super.createChildren(children, projection);
    }

    private void HashPasswordIfNeeded(final UserDto dto){
        if(dto.getPassword()==null || dto.getPassword().isEmpty()) throw new IllegalArgumentException("Password is null or empty!");
        if(!wasHashed(dto.getPassword())) {
            dto.setPassword(encoder.encode(dto.getPassword()));
            LOGGER.info(String.format("Password of %s was hashed",dto.getName()));
        }
    }



//$2a$10$
    //0=$
    //1==2
    //a==3
    //$==4
    //1==5
    //0==
    private boolean wasHashed(final String pw){
        if(pw.startsWith("$") && pw.charAt(4)=='$' && pw.charAt(6)=='$'){
            LOGGER.info("String was hashed in advance!");
            return true;
        }

        return false;
    }
}
