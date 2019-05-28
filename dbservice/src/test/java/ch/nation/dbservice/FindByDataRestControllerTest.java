package ch.nation.dbservice;

import ch.nation.dbservice.entities.NamedEntityBase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class FindByDataRestControllerTest extends BaseDataRestControllerTest {

    @Parameterized.Parameter(value=0)
    public String endpoint;

    @Parameterized.Parameter(value=1)
    public NamedEntityBase payload;



    @Parameterized.Parameter(value=2)
    public Class<? extends NamedEntityBase>    classToTest;


    @Parameterized.Parameter(value=3)
    @Autowired
    public CrudRepository repository;


    private NamedEntityBase created;


    @Test
    @Ignore
    public void findByTest(){

     created= (NamedEntityBase) repository.save(payload);

        ResponseEntity<? extends NamedEntityBase> responseEntity=   template.getForEntity(endpoint+"/"+created.getId(),classToTest);



        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());

        Assert.assertTrue(responseEntity.getBody() instanceof NamedEntityBase);
        Assert.assertTrue(responseEntity.getBody().getId()!=null);
        Assert.assertTrue(responseEntity.getBody().getName().equals(payload.getName()));


    }

    @Parameterized.Parameters // Note 4
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList<>();
       // params.add(new Object[] { "/users", new User("Test","Test"),User.class,UserRepository.class});
       // params.add(new Object[] { "/nations", new Nation("Test"),Nation.class,NationRepository.class});

        return params;
    }



}
