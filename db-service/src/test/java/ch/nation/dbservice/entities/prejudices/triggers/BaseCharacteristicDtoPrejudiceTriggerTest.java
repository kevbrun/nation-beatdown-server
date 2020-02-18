package ch.nation.dbservice.entities.prejudices.triggers;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.CharacteristicPrejudiceTriggerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class BaseCharacteristicDtoPrejudiceTriggerTest extends AbstractEntityTest<CharacteristicPrejudiceTrigger, CharacteristicPrejudiceTriggerRepository> implements IHasDiscriminatorValue {


    @Autowired
    CharacteristicsRepository characteristicsRepository;

    @Autowired
    CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository;


    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new CharacteristicPrejudiceTrigger();
        listOfEntities.add(entityToTest);


        CharacteristicPrejudiceTrigger second = new CharacteristicPrejudiceTrigger();
        listOfEntities.add(second);
    }

    @Override
    public void test_if_has_discriminator_value() {
        entityToTest = repo.save(entityToTest);
        Assert.assertTrue(entityToTest.getDiscriminatorValue().equals("CharacteristicPrejudiceTrigger"));
    }

    /**
     * @Test
     * @Transactional public void add_characteristic_to_prejudice_trigger(){
     * entityToTest = repo.save(entityToTest);
     * <p>
     * BaseCharacteristic baseCharacteristic = new BaseCharacteristic();
     * baseCharacteristic.setName("Inteligent aber hässlich!");
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * <p>
     * CharacteristicPrejudiceTrigger trigger = new CharacteristicPrejudiceTrigger();
     * trigger=characteristicPrejudiceTriggerRepository.save(trigger);
     * <p>
     * baseCharacteristic.addTrigger(trigger);
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * Assert.assertTrue(baseCharacteristic.getCharacteristicPrejudiceTriggers().get(0).equals(trigger));
     * <p>
     * }
     * @Test
     * @Transactional public void add_multiple_characteristic_to_prejudice_trigger(){
     * entityToTest = repo.save(entityToTest);
     * <p>
     * BaseCharacteristic baseCharacteristic = new BaseCharacteristic();
     * baseCharacteristic.setName("Inteligent aber hässlich!");
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * <p>
     * CharacteristicPrejudiceTrigger trigger = new CharacteristicPrejudiceTrigger();
     * trigger=characteristicPrejudiceTriggerRepository.save(trigger);
     * <p>
     * baseCharacteristic.addTrigger(trigger);
     * <p>
     * CharacteristicPrejudiceTrigger trigger2 = new CharacteristicPrejudiceTrigger();
     * trigger2=characteristicPrejudiceTriggerRepository.save(trigger2);
     * baseCharacteristic.addTrigger(trigger2);
     * <p>
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Assert.assertTrue(baseCharacteristic.getCharacteristicPrejudiceTriggers().size()==2);
     * <p>
     * }
     * @Test
     * @Transactional public void remove_multiple_characteristic_to_prejudice_trigger(){
     * entityToTest = repo.save(entityToTest);
     * <p>
     * BaseCharacteristic baseCharacteristic = new BaseCharacteristic();
     * baseCharacteristic.setName("Inteligent aber hässlich!");
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * <p>
     * CharacteristicPrejudiceTrigger trigger = new CharacteristicPrejudiceTrigger();
     * trigger=characteristicPrejudiceTriggerRepository.save(trigger);
     * <p>
     * baseCharacteristic.addTrigger(trigger);
     * <p>
     * CharacteristicPrejudiceTrigger trigger2 = new CharacteristicPrejudiceTrigger();
     * trigger2=characteristicPrejudiceTriggerRepository.save(trigger2);
     * baseCharacteristic.addTrigger(trigger2);
     * <p>
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * baseCharacteristic.removeTrigger(trigger);
     * baseCharacteristic = characteristicsRepository.save(baseCharacteristic);
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Assert.assertTrue(baseCharacteristic.getCharacteristicPrejudiceTriggers().size()==1);
     * <p>
     * }
     **/
    @Override
    public void cleanUp() {
        super.cleanUp();
        characteristicsRepository.deleteAll();
        characteristicPrejudiceTriggerRepository.deleteAll();
    }
}
