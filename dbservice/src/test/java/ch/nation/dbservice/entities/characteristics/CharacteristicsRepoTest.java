package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;

public class CharacteristicsRepoTest extends AbstractNamedEntityTest<Characteristics,CharacteristicsRepository> {

    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new Characteristics();
        entityToTest.setName("Toll");


        listOfEntities.add(entityToTest);

        Characteristics characteristics = new Characteristics();
        characteristics.setName("Toll 2");
        listOfEntities.add(characteristics);


    }





}
