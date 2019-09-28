package ch.nation.dbservice.entities.prejudices;

import ch.nation.core.model.Enums.ConditionComparer;
import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.prejudices.triggers.BasePrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.StatPrejudiceTrigger;
import ch.nation.dbservice.repositories.prejudices.PrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.PrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.StatPrejudiceTriggerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class PrejudiceTest extends AbstractNamedEntityTest<BasePrejudice,PrejudiceRepository> {

    @Autowired
    private PrejudiceTriggerRepository prejudiceTriggerRepository;

    @Autowired
    private StatPrejudiceTriggerRepository statPrejudiceTriggerRepository;


    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new StatPrejudice();
        entityToTest.setName("Alle Menschen stinken!");
        entityToTest.setTriggerOperation(PrejudiceOperator.AND);

        listOfEntities.add(entityToTest);


        entityToTest = new StatPrejudice();
        entityToTest.setName("So gutmütig");
        listOfEntities.add(entityToTest);
    }




    @Test
    @Transactional
    public void add_trigger_to_prejudice(){
        entityToTest = repo.save(entityToTest);


        BasePrejudiceTrigger trigger = new StatPrejudiceTrigger();
        trigger=prejudiceTriggerRepository.save(trigger);

        entityToTest.addTrigger(trigger);
        entityToTest = repo.save(entityToTest);


        StatPrejudiceTrigger statPrejudiceTrigger =new StatPrejudiceTrigger();
        statPrejudiceTrigger.setThreshold(100f);
        statPrejudiceTrigger.setComparer(ConditionComparer.EQUALS);
        statPrejudiceTrigger.setStatType(StatType.ACTION_POINTS);


        statPrejudiceTrigger= statPrejudiceTriggerRepository.save(statPrejudiceTrigger);


        entityToTest.addTrigger(statPrejudiceTrigger);


        entityToTest = repo.save(entityToTest);


        LOGGER.info(entityToTest.toString());
        Assert.assertTrue(entityToTest.getPrejudiceTriggers().size()==2);
        Assert.assertTrue(entityToTest.getPrejudiceTriggers().contains(trigger));
        Assert.assertTrue(entityToTest.getPrejudiceTriggers().contains(statPrejudiceTrigger));





    }


    @Transactional
    @Test
    public void remove_trigger_from_prejduice(){
        entityToTest = repo.save(entityToTest);


        BasePrejudiceTrigger trigger = new StatPrejudiceTrigger();
        trigger=prejudiceTriggerRepository.save(trigger);

        entityToTest.addTrigger(trigger);
        entityToTest = repo.save(entityToTest);


        StatPrejudiceTrigger statPrejudiceTrigger =new StatPrejudiceTrigger();
        statPrejudiceTrigger.setThreshold(100f);
        statPrejudiceTrigger.setComparer(ConditionComparer.EQUALS);
        statPrejudiceTrigger.setStatType(StatType.ACTION_POINTS);


        statPrejudiceTrigger= statPrejudiceTriggerRepository.save(statPrejudiceTrigger);


        entityToTest.addTrigger(statPrejudiceTrigger);


        entityToTest = repo.save(entityToTest);


        entityToTest.removeTrigger(trigger);
        entityToTest = repo.save(entityToTest);

        Assert.assertTrue(entityToTest.getPrejudiceTriggers().size()==1);
        Assert.assertTrue(entityToTest.getPrejudiceTriggers().contains(statPrejudiceTrigger));

    }


    @Override
    public void cleanUp() {
        super.cleanUp();
        statPrejudiceTriggerRepository.deleteAll();
        prejudiceTriggerRepository.deleteAll();
    }
}
