package ch.nation.dbservice.repositories.user;

import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.core.AbstractMassRestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RepositoryRestController
@RequestMapping("users")
public class UserMassRepository extends AbstractMassRestResource<User> {


    @Autowired
    public UserMassRepository(UserRepository repo) {

        super(repo);

    }

}
