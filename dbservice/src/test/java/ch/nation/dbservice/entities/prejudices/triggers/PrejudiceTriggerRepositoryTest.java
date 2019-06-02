package ch.nation.dbservice.entities.prejudices.triggers;

import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.dbservice.entities.AbstractEntityTest;
import ch.nation.dbservice.entities.bonus.EmbeddableIntegerBonus;
import ch.nation.dbservice.entities.prejudices.StatPrejudice;
import ch.nation.dbservice.repositories.prejudices.StatPrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.PrejudiceTriggerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class PrejudiceTriggerRepositoryTest extends AbstractEntityTest<PrejudiceTrigger,PrejudiceTriggerRepository> {


    @Autowired
    StatPrejudiceRepository statPrejudiceRepository;

    @Override
    public void setUp() {
        super.setUp();
        entityToTest  = new PrejudiceTrigger();
        listOfEntities.add(entityToTest);


        PrejudiceTrigger second = new PrejudiceTrigger();
        listOfEntities.add(second);

    }


    @Test
    @Transactional
    public void add_prejudice_test(){
        LOGGER.info("TEST USES @TRANSACTIONAL!");
        entityToTest = repo.save(entityToTest);

        StatPrejudice prejudice = new StatPrejudice();
        prejudice.setName("Alle weissen Menschen stinken!");
        prejudice.getDelta().setIntBonus(new EmbeddableIntegerBonus(10,StatModTarget.VALUE));
        statPrejudiceRepository.save(prejudice);

        entityToTest.addPrejudice(prejudice);
        entityToTest = repo.save(entityToTest);

        Assert.assertTrue(entityToTest.getPrejudices().size()==1);
        Assert.assertTrue(entityToTest.getPrejudices().get(0).equals(prejudice));
        Assert.assertTrue(entityToTest.getPrejudices().get(0).getPrejudiceTriggers().get(0).equals(entityToTest));


    }



    @Test
    @Transactional
    public void add_multiple_prejudices_test(){
        LOGGER.info("TEST USES @TRANSACTIONAL!");

            entityToTest = repo.save(entityToTest);

            StatPrejudice prejudice = new StatPrejudice();
            prejudice.setName("Alle weissen Menschen stinken!");
            prejudice.getDelta().setIntBonus(new EmbeddableIntegerBonus(10,StatModTarget.VALUE));
            statPrejudiceRepository.save(prejudice);

            entityToTest.addPrejudice(prejudice);
            entityToTest = repo.save(entityToTest);


        StatPrejudice prejudiceSecond = new StatPrejudice();
        prejudiceSecond.setName("Alle schwarzen Menschen riecheen gut!");
        prejudiceSecond.getDelta().setIntBonus(new EmbeddableIntegerBonus(10,StatModTarget.VALUE));
        statPrejudiceRepository.save(prejudiceSecond);

        entityToTest.addPrejudice(prejudiceSecond);
       entityToTest= repo.save(entityToTest);


       Assert.assertTrue(entityToTest.getPrejudices().size()==2);
       Assert.assertTrue(entityToTest.getPrejudices().contains(prejudice));
       Assert.assertTrue(entityToTest.getPrejudices().contains(prejudiceSecond));


    }



    @Test
    @Transactional
    public void remove_prejudice_from_list_test(){
        LOGGER.info("TEST USES @TRANSACTIONAL!");

        entityToTest = repo.save(entityToTest);

        StatPrejudice prejudice = new StatPrejudice();
        prejudice.setName("Alle weissen Menschen stinken!");
        prejudice.getDelta().setIntBonus(new EmbeddableIntegerBonus(10,StatModTarget.VALUE));
        statPrejudiceRepository.save(prejudice);

        entityToTest.addPrejudice(prejudice);
        entityToTest = repo.save(entityToTest);


        StatPrejudice prejudiceSecond = new StatPrejudice();
        prejudiceSecond.setName("Alle schwarzen Menschen riecheen gut!");
        prejudiceSecond.getDelta().setIntBonus(new EmbeddableIntegerBonus(10,StatModTarget.VALUE));
        statPrejudiceRepository.save(prejudiceSecond);

        entityToTest.addPrejudice(prejudiceSecond);
        entityToTest= repo.save(entityToTest);



        entityToTest.removeTrigger(prejudice);
        entityToTest=repo.save(entityToTest);

        Assert.assertTrue(entityToTest.getPrejudices().size()==1);
        Assert.assertTrue(entityToTest.getPrejudices().get(0).equals(prejudiceSecond));


    }


    @Override
    public void cleanUp() {
        super.cleanUp();
        statPrejudiceRepository.deleteAll();
    }
}
