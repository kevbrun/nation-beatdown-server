package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;

public class CharacteristicRepoTest extends AbstractNamedEntityTest<Characteristic,CharacteristicsRepository> {

    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new Characteristic();
        entityToTest.setName("Toll");


        listOfEntities.add(entityToTest);

        Characteristic characteristic = new Characteristic();
        characteristic.setName("Toll 2");
        listOfEntities.add(characteristic);


    }





}
