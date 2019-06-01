package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.repositories.moves.PlayerMoveRepository;
import ch.nation.dbservice.repositories.units.UnitRepository;
import ch.nation.dbservice.repositories.user.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerMoveRepositoryTest extends AbstractEntityTest<PlayerMoveAction,PlayerMoveRepository> implements IHasDiscriminatorValue {


    @Autowired
    private UnitRepository unitRepository;


    @Autowired
    private UserRepository repository;

    @Override
    public void setUp() {
        super.setUp();

        entityToTest = new PlayerMoveAction();
        listOfEntities.add(entityToTest);


        PlayerMoveAction second = new PlayerMoveAction();
        listOfEntities.add(second);

    }

    @Override
    public void test_if_has_discriminator_value() {
       LOGGER.info("NOT IMPLEMENTED YET!");
    }


    @Test
    public void test_adding_caster(){
        Unit dummy = new Unit();
        dummy.setName("123 Polizei");
        dummy = unitRepository.save(dummy);


        PlayerMoveAction action = repo.save(entityToTest);

        action.setCaster(dummy);


        action  = repo.save(action);


        Assert.assertEquals("123 Polizei",action.getCaster().getName());



    }



}
