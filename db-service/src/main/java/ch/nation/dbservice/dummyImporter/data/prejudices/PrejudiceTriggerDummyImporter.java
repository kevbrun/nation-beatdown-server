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

    private void createAgainstExplosivPeople() {
        CharacteristicPrejudiceTrigger trigger = new CharacteristicPrejudiceTrigger();
        trigger.setName("Explisiver Character Trigger");
        trigger.setIdentifier("char_expl");
        trigger.setDescription("Wird durch die Characteristic Explosiver Character getriggered");

        trigger = characteristicPrejudiceTriggerRepository.save(trigger);
        BaseCharacteristic characteristic = characteristicsRepository.findByName("Explosiver Character");
        trigger.addCharacteristic(characteristic);
        characteristicPrejudiceTriggerRepository.save(trigger);
    }


    private void createWeakStatPrejudiceTrigger() {
        StatPrejudiceTrigger trigger = new StatPrejudiceTrigger();
        trigger.setName("Schwächer als 10 trigger");
        trigger.setIdentifier("less_str_10");

        trigger.setDescription("Wird durch schwächere Nationen wie 10 getriggered");
        trigger.setComparer(ConditionComparer.SMALLER_THAN);
        trigger.setThreshold(10);
        trigger.setStatType(StatType.STRENGTH);
        statPrejudiceTriggerRepository.save(trigger);
    }

    private void createHighIntelligencePrejudiceTrigger() {
        StatPrejudiceTrigger trigger = new StatPrejudiceTrigger();
        trigger.setName("Gescheitere als 20 trigger");
        trigger.setIdentifier("more_int_20");
        trigger.setDescription("Wird durch klügere Nationen wie 20 getriggered");
        trigger.setComparer(ConditionComparer.BIGGER_THAN);
        trigger.setThreshold(20);
        trigger.setStatType(StatType.INTELIGENCE);
        statPrejudiceTriggerRepository.save(trigger);
    }

}
