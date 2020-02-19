package ch.nation.dbservice.entities.characteristics;

import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.entities.bonus.EmbeddableIntegerBonus;
import ch.nation.dbservice.repositories.characteristics.StatCharacteristicRepository;
import org.junit.Assert;
import org.junit.Test;

public class StatCharacteristicDtoRepoTest extends AbstractNamedEntityTest<StatCharacteristic, StatCharacteristicRepository> implements IHasDiscriminatorValue {


    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new StatCharacteristic();
        entityToTest.setName("Mega Stark aber dumm wie Brot!");
        entityToTest.getDelta().setStrBonus(new EmbeddableIntegerBonus(10, StatModTarget.MAX_VALUE));
        entityToTest.getDelta().setIntBonus(new EmbeddableIntegerBonus(-10, StatModTarget.MAX_VALUE));


        listOfEntities.add(entityToTest);


        StatCharacteristic second = new StatCharacteristic();
        second.setName("Intelligent aber schwach");
        second.getDelta().setIntBonus(new EmbeddableIntegerBonus(100, StatModTarget.VALUE));
        second.getDelta().setIntBonus(new EmbeddableIntegerBonus(-10, StatModTarget.ALL));


        listOfEntities.add(second);

    }


    @Override
    @Test
    public void test_if_has_discriminator_value() {
        StatCharacteristic statCharacteristics = repo.save(entityToTest);

        Assert.assertEquals(statCharacteristics.getDiscriminatorValue(), "StatCharacteristic");


    }

    @Test
    public void test_if_bonus_are_available() {
        StatCharacteristic obj = repo.save(entityToTest);

        Assert.assertTrue(obj.getDelta().getStrBonus().getBonus() == 10);
        Assert.assertTrue(obj.getDelta().getStrBonus().getStatTarget() == StatModTarget.MAX_VALUE);

    }


}
