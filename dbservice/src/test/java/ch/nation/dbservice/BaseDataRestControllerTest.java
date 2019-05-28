package ch.nation.dbservice;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestContextManager;

public class BaseDataRestControllerTest {
    @Autowired
    public TestRestTemplate template;


 /**   private TestContextManager testContextManager;

    @Before
    public void SetUp() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }**/

}
