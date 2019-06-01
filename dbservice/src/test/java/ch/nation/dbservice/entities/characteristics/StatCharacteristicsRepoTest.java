package ch.nation.dbservice.entities.characteristics;

import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.entities.bonus.EmbeddableIntegerBonus;
import ch.nation.dbservice.repositories.characteristics.StatCharacteristicRepository;
import org.junit.Assert;
import org.junit.Test;

public class StatCharacteristicsRepoTest extends AbstractNamedEntityTest<StatCharacteristics,StatCharacteristicRepository> implements IHasDiscriminatorValue {


    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new StatCharacteristics();
        entityToTest.setName("Mega Stark aber dumm wie Brot!");
        entityToTest.getDelta().setStrBonus(new EmbeddableIntegerBonus(10,StatModTarget.MAX_VALUE));
        entityToTest.getDelta().setIntBonus(new EmbeddableIntegerBonus(-10,StatModTarget.MAX_VALUE));


        listOfEntities.add(entityToTest);


        StatCharacteristics second = new StatCharacteristics();
        second.setName("Intelligent aber schwach");
        second.getDelta().setIntBonus(new EmbeddableIntegerBonus(100,StatModTarget.VALUE));
        second.getDelta().setIntBonus(new EmbeddableIntegerBonus(-10,StatModTarget.ALL));


        listOfEntities.add(second);

     }


    @Override
    @Test
    public void test_if_has_discriminator_value() {
        StatCharacteristics statCharacteristics = repo.save(entityToTest);

        Assert.assertEquals(statCharacteristics.getDiscriminatorValue(),"STAT");


    }

    @Test
    public void test_if_bonus_are_available(){
        StatCharacteristics obj = repo.save(entityToTest);

        Assert.assertTrue(obj.getDelta().getStrBonus().getBonus() == 10);
        Assert.assertTrue(obj.getDelta().getStrBonus().getStatTarget() == StatModTarget.MAX_VALUE);

    }





}
