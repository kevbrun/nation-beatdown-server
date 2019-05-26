package ch.nation.dbservice;


import ch.nation.dbservice.entities.User.Nation;
import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.User.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Collection;

/**@RunWith(Parameterized.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)**/
public  class CreationDataRestControllerTest extends BaseDataRestControllerTest {



    @Parameterized.Parameter(value=0)
    public String endpoint;

    @Parameterized.Parameter(value=1)
    public NationEntityBase payload;

    @Parameterized.Parameter(value=2)
    public Class<? extends NationEntityBase>    classToTest;


    @Test
    public void CreationTest(){

        ResponseEntity<? extends NationEntityBase> responseEntity=   template.postForEntity(endpoint,payload,classToTest);

        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());

        Assert.assertTrue(responseEntity.getBody() instanceof NationEntityBase);
        Assert.assertTrue(responseEntity.getBody().getId()!=null);
        Assert.assertTrue(responseEntity.getBody().getName().equals(payload.getName()));
    }




    @Parameterized.Parameters // Note 4
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList<>();
     //   params.add(new Object[] { "/users", new User("Test","Test"),User.class});
      //  params.add(new Object[] { "/nations", new Nation("Test"),Nation.class});

        return params;
    }


}
