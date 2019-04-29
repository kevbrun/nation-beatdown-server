package ch.nation.dbservice;

import ch.nation.dbservice.entities.Nation;
import ch.nation.dbservice.entities.User;
import ch.nation.dbservice.repositories.NationRepository;
import ch.nation.dbservice.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DbserviceApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NationRepository nationRepository;

	private User generateTestUser(){
		User user = new User();
		user.setName("Testiman");
		return user;
	}


	@Test
	public void  test_If_Uuid_Is_Not_Null(){
	User generatedUser = generateTestUser();
	generatedUser.setPassword("123");
	User createdUser = userRepository.save(generatedUser);
	Assert.assertNotNull(createdUser);
	Assert.assertTrue(generatedUser.getId()!=null);
	}

	@Test
	public void test_creation_of_nation(){
		User generatedUser = generateTestUser();
		generatedUser.setPassword("123");
		User createdUser = userRepository.save(generatedUser);
		Nation nation = new Nation();
		nation.setName("Testimans Nation");
		Nation createdNation = nationRepository.save(nation);
		createdUser.setNation(createdNation);
		nation.setUser(createdUser);
		createdUser = userRepository.save(createdUser);
		Assert.assertNotNull(createdUser.getNation());
		Assert.assertNotNull(createdUser.getNation().getUser());
		Assert.assertTrue(createdUser.getNation().getId().toString().contains("-"));


	}





}
