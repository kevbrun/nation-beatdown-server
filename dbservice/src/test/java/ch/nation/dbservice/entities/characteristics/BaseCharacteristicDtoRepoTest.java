package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;

public class BaseCharacteristicDtoRepoTest extends AbstractNamedEntityTest<BaseCharacteristic,CharacteristicsRepository> {

    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new BaseCharacteristic();
        entityToTest.setName("Toll");


        listOfEntities.add(entityToTest);

        BaseCharacteristic baseCharacteristic = new BaseCharacteristic();
        baseCharacteristic.setName("Toll 2");
        listOfEntities.add(baseCharacteristic);


    }





}
