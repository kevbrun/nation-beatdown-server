package ch.nation.dbservice.entities.users;

import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.user.UserRepository;
import org.junit.Assert;

public class UserRepoTest extends AbstractNamedEntityTest<User, UserRepository> {


    @Override
    public void setUp() {

        super.setUp();
        entityToTest = new User();
        entityToTest.setPassword("123");
        entityToTest.setName("Kevin der Zerstörer");


        listOfEntities.add(entityToTest);


        User secondUser = new User();
        secondUser.setName("Jay");
        secondUser.setPassword("12345");

        listOfEntities.add(secondUser);
    }

    @Override
    public void update_entities_test() {
        User savedObject = repo.save(entityToTest);
        savedObject.setPassword("judas");

        savedObject = repo.save(savedObject);
        Assert.assertEquals("judas", savedObject.getPassword());

    }
}
