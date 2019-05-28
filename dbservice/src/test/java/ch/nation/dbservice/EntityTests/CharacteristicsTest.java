package ch.nation.dbservice.EntityTests;

import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.dbservice.entities.bonus.EmbeddableIntegerBonus;
import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.characteristics.StatCharacteristics;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
 @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class CharacteristicsTest {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CharacteristicsRepository repo;


    @Test
    public void addStatCharacteristic(){
        StatCharacteristics statCharacteristics = new StatCharacteristics();
        statCharacteristics.setName("Tell");


        StatBonusDelta delta = new StatBonusDelta();
        delta.setAgiBonus(new EmbeddableIntegerBonus(100, StatModTarget.VALUE));
        delta.setDexBonus(new EmbeddableIntegerBonus(110, StatModTarget.VALUE));


        statCharacteristics.setDelta(delta);

      StatCharacteristics saved=   repo.save(statCharacteristics);

        LOGGER.info(saved.toString());
        Assert.notNull(saved.getDelta());
        Assert.notNull(saved.getDelta().getAgiBonus());
        Assert.notNull(saved.getDelta().getAgiBonus().getBonus().equals(100));
        Assert.notNull(saved.getDelta().getAgiBonus().getStatTarget().equals(StatModTarget.VALUE));

        Assert.notNull(saved);

    }


}
