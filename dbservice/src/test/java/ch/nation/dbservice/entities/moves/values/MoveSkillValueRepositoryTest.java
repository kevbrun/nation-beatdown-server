package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.repositories.moves.values.MoveSkillValueRepository;
import org.junit.Assert;
import org.junit.Test;

public class MoveSkillValueRepositoryTest extends AbstractEntityTest<MoveSkillValue,MoveSkillValueRepository> implements IHasDiscriminatorValue {


    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new MoveSkillValue();
        listOfEntities.add(entityToTest);


        MoveSkillValue second = new MoveSkillValue();

        listOfEntities.add(second);



    }



    @Test
    public void getter_should_create_value(){
        entityToTest.getSourcePosition().setX(40f);

        entityToTest = repo.save(entityToTest);

        Assert.assertTrue(entityToTest.getSourcePosition().getX() == 40f);


    }


    @Override
    @Test
    public void test_if_has_discriminator_value() {
        entityToTest = repo.save(entityToTest);

        Assert.assertTrue(entityToTest.getDiscriminatorValue().equals("MOVE"));

    }
}
