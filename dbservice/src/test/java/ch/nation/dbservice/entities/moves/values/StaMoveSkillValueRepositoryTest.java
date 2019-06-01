package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.repositories.moves.values.StatMoveValueRepository;

public class StaMoveSkillValueRepositoryTest extends AbstractEntityTest<StatMoveValue,StatMoveValueRepository> {

    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new StatMoveValue();
        listOfEntities.add(entityToTest);


        StatMoveValue val = new StatMoveValue();
        listOfEntities.add(val);
    }
}
