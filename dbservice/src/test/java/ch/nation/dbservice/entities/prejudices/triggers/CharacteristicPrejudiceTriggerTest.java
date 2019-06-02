package ch.nation.dbservice.entities.prejudices.triggers;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.entities.characteristics.Characteristic;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.CharacteristicPrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.PrejudiceTriggerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class CharacteristicPrejudiceTriggerTest extends AbstractEntityTest<CharacteristicPrejudiceTrigger,CharacteristicPrejudiceTriggerRepository> implements IHasDiscriminatorValue {


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
        Assert.assertTrue(entityToTest.getDiscriminatorValue().equals("STAT"));
    }


    @Test
    @Transactional
    public void add_characteristic_to_prejudice_trigger(){
        entityToTest = repo.save(entityToTest);

        Characteristic characteristic = new Characteristic();
        characteristic.setName("Inteligent aber hässlich!");
        characteristic = characteristicsRepository.save(characteristic);



        CharacteristicPrejudiceTrigger trigger = new CharacteristicPrejudiceTrigger();
        trigger=characteristicPrejudiceTriggerRepository.save(trigger);

        characteristic.addTrigger(trigger);
        characteristic  = characteristicsRepository.save(characteristic);


        Assert.assertTrue(characteristic.getCharacteristicPrejudiceTriggers().get(0).equals(trigger));

    }

    @Test
    @Transactional
    public void add_multiple_characteristic_to_prejudice_trigger(){
        entityToTest = repo.save(entityToTest);

        Characteristic characteristic = new Characteristic();
        characteristic.setName("Inteligent aber hässlich!");
        characteristic = characteristicsRepository.save(characteristic);



        CharacteristicPrejudiceTrigger trigger = new CharacteristicPrejudiceTrigger();
        trigger=characteristicPrejudiceTriggerRepository.save(trigger);

        characteristic.addTrigger(trigger);
        characteristic  = characteristicsRepository.save(characteristic);








       Assert.assertTrue(characteristic.getCharacteristicPrejudiceTriggers().size()==2);

    }




}
