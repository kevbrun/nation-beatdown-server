package ch.nation.dbservice.entities;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.repositories.IPageableDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public abstract class AbstractNamedEntityTest<TEntity extends NamedEntityBase,TRepo extends IPageableDao<TEntity>> extends AbstractEntityTest<TEntity,TRepo> {



    @Test
    public  void update_entities_test(){
        TEntity savedObject = repo.save(entityToTest);
        savedObject.setName("After update");
        savedObject = repo.save(savedObject);

        Assert.assertTrue(savedObject.getName().equals("After update"));

    }

}
