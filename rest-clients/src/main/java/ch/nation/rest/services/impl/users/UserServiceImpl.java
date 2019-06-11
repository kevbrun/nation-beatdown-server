package ch.nation.rest.services.impl.users;


import ch.nation.core.model.dto.user.UserDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.users.DBMassUserRestClient;
import ch.nation.rest.clients.users.DBUserRestClient;
import ch.nation.rest.services.impl.AbstractMassGenericEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractMassGenericEntityService<UserDto,UserDto> implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public UserServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(UserDto.class,factory, massRestClientFactory);
    }


}
