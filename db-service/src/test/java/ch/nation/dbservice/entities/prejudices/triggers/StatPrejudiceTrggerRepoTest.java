package ch.nation.dbservice.entities.prejudices.triggers;

import ch.nation.core.model.Enums.ConditionComparer;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.repositories.prejudices.StatPrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.StatPrejudiceTriggerRepository;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

public class StatPrejudiceTrggerRepoTest extends AbstractEntityTest<StatPrejudiceTrigger,StatPrejudiceTriggerRepository> implements IHasDiscriminatorValue
{
    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new StatPrejudiceTrigger();
        entityToTest.setComparer(ConditionComparer.BIGGER_THAN);
        entityToTest.setStatType(StatType.ACTION_POINTS);
        entityToTest.setThreshold(100f);
        listOfEntities.add(entityToTest);

        StatPrejudiceTrigger second = new StatPrejudiceTrigger();
        second = new StatPrejudiceTrigger();
        second.setComparer(ConditionComparer.BIGGER_THAN);
        second.setStatType(StatType.ACTION_POINTS);
        second.setThreshold(100f);
        listOfEntities.add(second);


    }

    @Override
    @Test
    public void test_if_has_discriminator_value() {
        entityToTest=   repo.save(entityToTest);
        Assert.assertTrue(entityToTest.getDiscriminatorValue().equals("StatPrejudiceTrigger"));

    }
}
