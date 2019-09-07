package ch.nation.dbservice.dummyImporter.data.prejudices;

import ch.nation.core.model.Enums.ConditionComparer;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.StatPrejudiceTrigger;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.CharacteristicPrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.StatPrejudiceTriggerRepository;

public class PrejudiceTriggerDummyImporter extends AbstractDummyGenerator<PrejudiceTriggerDummyImporter> {

    private final CharacteristicsRepository characteristicsRepository;
    private final CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository;
    private final StatPrejudiceTriggerRepository statPrejudiceTriggerRepository;


    public PrejudiceTriggerDummyImporter(CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository, CharacteristicsRepository characteristicsRepository, StatPrejudiceTriggerRepository statPrejudiceTriggerRepository) throws Exception {
        super();

        this.characteristicsRepository = characteristicsRepository;
        this.characteristicPrejudiceTriggerRepository = characteristicPrejudiceTriggerRepository;
        this.statPrejudiceTriggerRepository = statPrejudiceTriggerRepository;
        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        createWeakStatPrejudiceTrigger();
        createHighIntelligencePrejudiceTrigger();
        createAgainstExplosivPeople();


    }

    private void createAgainstExplosivPeople(){
        CharacteristicPrejudiceTrigger characteristicPrejudiceTrigger = new CharacteristicPrejudiceTrigger();
        characteristicPrejudiceTrigger.setName("Explisiver Character Trigger");
        characteristicPrejudiceTrigger.setDescription("Wird durch die Characteristic Explosiver Character getriggered");

        characteristicPrejudiceTrigger=   characteristicPrejudiceTriggerRepository.save(characteristicPrejudiceTrigger);
        BaseCharacteristic characteristic= characteristicsRepository.findByName("Explosiver Character");
        characteristicPrejudiceTrigger.addCharacteristic(characteristic);
        characteristicPrejudiceTriggerRepository.save(characteristicPrejudiceTrigger);
    }




    private void createWeakStatPrejudiceTrigger(){
        StatPrejudiceTrigger statPrejudiceTrigger  = new StatPrejudiceTrigger();
        statPrejudiceTrigger.setName("Schwächer als 10 trigger");
        statPrejudiceTrigger.setDescription("Wird durch schwächere Nationen wie 10 getriggered");
        statPrejudiceTrigger.setComparer(ConditionComparer.SMALLER_THAN);
        statPrejudiceTrigger.setThreshold(10);
        statPrejudiceTrigger.setStatType(StatType.STRENGTH);
        statPrejudiceTriggerRepository.save(statPrejudiceTrigger);
    }

    private void createHighIntelligencePrejudiceTrigger(){
        StatPrejudiceTrigger statPrejudiceTrigger  = new StatPrejudiceTrigger();
        statPrejudiceTrigger.setName("Gescheitere als 20 trigger");
        statPrejudiceTrigger.setDescription("Wird durch klügere Nationen wie 20 getriggered");
        statPrejudiceTrigger.setComparer(ConditionComparer.BIGGER_THAN);
        statPrejudiceTrigger.setThreshold(20);
        statPrejudiceTrigger.setStatType(StatType.INTELIGENCE);
        statPrejudiceTriggerRepository.save(statPrejudiceTrigger);
    }

}
