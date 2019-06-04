package ch.nation.dbservice.entities;

import ch.nation.dbservice.repositories.IPageableDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public abstract class AbstractEntityTest<TEntity extends AbstractNationEntityBase,TRepo extends IPageableDao<TEntity>> {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    protected TEntity entityToTest;
    protected List<TEntity> listOfEntities;
    protected Class<TEntity> entityClass;

    @Autowired
    protected TRepo repo;


    @Before
    public void setUp(){
        LOGGER.info("Execute setUp");
       listOfEntities = new ArrayList<>();
    }


    @Test
    public void save_entity_test(){
        TEntity savedObject = repo.save(entityToTest);
        Assert.assertNotNull(savedObject);


    }


    @Test
    public void save_entities_test(){
        Iterable<TEntity> savedObjects = repo.saveAll(listOfEntities);

        Assert.assertNotNull(savedObjects);


        List<TEntity> list = new ArrayList<>();
        savedObjects.iterator().forEachRemaining(list::add);
        Assert.assertTrue(!list.isEmpty());
        Assert.assertTrue(list.size()== listOfEntities.size());

    }


    @Test
    public void find_one_by_uuid_test(){
        TEntity savedObject = repo.save(entityToTest);
        Assert.assertNotNull(savedObject);


       TEntity foundObject= repo.findOneById(savedObject.getId());

        Assert.assertNotNull(foundObject);
        Assert.assertEquals(savedObject.getId(),foundObject.getId());
    }


    @Test
    public void find_all_test(){
        repo.saveAll(listOfEntities);
        Iterable<TEntity> foundObjects = repo.findAll();
        List<TEntity> list = new ArrayList<>();
        foundObjects.iterator().forEachRemaining(list::add);
        Assert.assertTrue(list.size()==listOfEntities.size());


    }




    @Test
    public void delete_entities_test(){
        TEntity savedObject = repo.save(entityToTest);

        repo.delete(savedObject);


        Assert.assertTrue(repo.count()==0);
    }



    @After
    public void cleanUp(){
        LOGGER.info("Execute Cleanup");
        repo.deleteAll();
    }





}
