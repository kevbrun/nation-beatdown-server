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

import javax.transaction.Transactional;

public class PlayerMoveRepositoryTest extends AbstractEntityTest<BasePlayerMove,PlayerMoveRepository> implements IHasDiscriminatorValue {


    @Autowired
    private UnitRepository unitRepository;


    @Autowired
    private UserRepository repository;

    @Override
    public void setUp() {
        super.setUp();

        entityToTest = new BasePlayerMove();
        listOfEntities.add(entityToTest);


        BasePlayerMove second = new BasePlayerMove();
        listOfEntities.add(second);

    }

    @Override
    public void test_if_has_discriminator_value() {
       LOGGER.info("NOT IMPLEMENTED YET!");
    }


    @Test
    @Transactional
    public void test_adding_caster(){
        LOGGER.info("TEST RUNS WITH @Transactional ANNOTATION!");
        Unit dummy = new Unit();
        dummy.setName("123 Polizei");
        dummy = unitRepository.save(dummy);


        BasePlayerMove action = repo.save(entityToTest);

        action.setCaster(dummy);


        action  = repo.save(action);


        Assert.assertEquals("123 Polizei",action.getCaster().getName());
        Assert.assertTrue(action.getCaster().equals(dummy));



    }


    @Test
    @Transactional
    public void test_adding_target(){

        LOGGER.info("TEST RUNS WITH @Transactional ANNOTATION!");
        Unit dummy = new Unit();
        dummy.setName("123 Polizei");
        dummy = unitRepository.save(dummy);


        BasePlayerMove action = repo.save(entityToTest);

        action.setTarget(dummy);


        action  = repo.save(action);


        Assert.assertEquals("123 Polizei",action.getTarget().getName());
        Assert.assertTrue(action.getTarget().equals(dummy));



    }

    @Test
    @Transactional
    public void remove_caster(){
        LOGGER.info("TEST RUNS WITH @Transactional ANNOTATION!");
        Unit dummy = new Unit();
        dummy.setName("123 Polizei");
        dummy = unitRepository.save(dummy);


        BasePlayerMove action = repo.save(entityToTest);

        action.setCaster(dummy);


        action  = repo.save(action);


        action.setCaster(null);
        Assert.assertTrue(action.getCaster()==null);
        Assert.assertTrue(dummy.getSource().size()==0);
    }




}
