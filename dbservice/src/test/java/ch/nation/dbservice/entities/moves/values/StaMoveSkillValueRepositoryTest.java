package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.repositories.moves.values.StatMoveValueRepository;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

public class StaMoveSkillValueRepositoryTest extends AbstractEntityTest<StatMoveValue,StatMoveValueRepository> implements IHasDiscriminatorValue {

    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new StatMoveValue();
        listOfEntities.add(entityToTest);


        StatMoveValue val = new StatMoveValue();
        listOfEntities.add(val);
    }

    @Override
    @Test
    public void test_if_has_discriminator_value() {
        entityToTest =  repo.save(entityToTest);
        Assert.assertEquals("STAT",entityToTest.getDiscriminatorValue());
    }

    @Test
    public void embedded_fields_are_created_during_first_save(){
        entityToTest =  repo.save(entityToTest);

        Assert.assertNotNull(entityToTest.getValue());
    }
}
