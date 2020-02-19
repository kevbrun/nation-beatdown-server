package ch.nation.dbservice.repositories.user;

import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.IPageableDao;
import ch.nation.dbservice.repositories.core.AbstractMassRestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RepositoryRestController
@RequestMapping("users")
public class UserMassRepository extends AbstractMassRestResource<User> {


    @Autowired
    public UserMassRepository(UserRepository repo) {

        super(repo);

    }

}
