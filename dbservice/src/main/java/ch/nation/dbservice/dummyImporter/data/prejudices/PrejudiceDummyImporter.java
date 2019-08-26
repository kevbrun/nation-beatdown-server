package ch.nation.dbservice.dummyImporter.data.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.bonus.EmbeddableFloatBonus;
import ch.nation.dbservice.entities.bonus.EmbeddableIntegerBonus;
import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.prejudices.BasePrejudice;
import ch.nation.dbservice.entities.prejudices.SkillPrejudice;
import ch.nation.dbservice.entities.prejudices.StatPrejudice;
import ch.nation.dbservice.entities.prejudices.triggers.BasePrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.repositories.prejudices.SkillPrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.StatPrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.CharacteristicPrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.PrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.StatPrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;


public class PrejudiceDummyImporter extends AbstractDummyGenerator<BasePrejudice> {

    private final PrejudiceTriggerRepository prejudiceTriggerRepository;
    private final SkillPrejudiceRepository skillPrejudiceRepository;
    private final SkillRepository skillRepository;
    private final StatPrejudiceTriggerRepository statPrejudiceTriggerRepository;
    private final StatPrejudiceRepository statPrejudiceRepository;
    private final CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository;


    public PrejudiceDummyImporter(PrejudiceTriggerRepository prejudiceTriggerRepository, SkillPrejudiceRepository skillPrejudiceRepository, SkillRepository skillRepository, StatPrejudiceTriggerRepository statPrejudiceTriggerRepository, StatPrejudiceRepository statPrejudiceRepository, CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository) throws Exception {
        this.prejudiceTriggerRepository = prejudiceTriggerRepository;
        this.skillPrejudiceRepository = skillPrejudiceRepository;
        this.skillRepository = skillRepository;
        this.statPrejudiceTriggerRepository = statPrejudiceTriggerRepository;
        this.statPrejudiceRepository = statPrejudiceRepository;
        this.characteristicPrejudiceTriggerRepository = characteristicPrejudiceTriggerRepository;

        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        createHandleWeakNationPrejudice();
        createHandleHighIntelligencPrejduice();
        createHateAgainstExplosivPeople();
    }



    private void createHandleWeakNationPrejudice(){
        SkillPrejudice skillPrejudice = new SkillPrejudice();
        skillPrejudice.setName("Schwache Leute machen wütend!");
        skillPrejudice.setDescription("Die Nation wird explosiv,wenn diese auf schwache Menschen trifft");
        skillPrejudice.setTriggerOperation(PrejudiceOperator.OR);
        skillPrejudice= skillPrejudiceRepository.save(skillPrejudice);
        BasePrejudiceTrigger prejudiceTrigger = prejudiceTriggerRepository.findByName("Schwächer als 10 trigger");
        skillPrejudice.addTrigger(prejudiceTrigger);
        skillPrejudice = skillPrejudiceRepository.save(skillPrejudice);
        Skill skill = skillRepository.findByName("Explosion!");
        skillPrejudice.setSkill(skill);
        skillPrejudiceRepository.save(skillPrejudice);
    }


    private void createHandleHighIntelligencPrejduice(){
        StatPrejudice prejudice = new StatPrejudice();
        prejudice.setName("Intelligente Leute. Viel Luft aber nichts dahinter!");
        prejudice.setDescription("Die Nation hat eine Abneigung gegen intelligente Leute.\n" +
                "Sie fühlen sich dumm.Daher kriegen diese einen Boni auf Stärke und verlieren an Intelligenz. Wenn die Intelligenz der Nation höher als 20 ist.");

        StatBonusDelta statBonusDelta = new StatBonusDelta();
        statBonusDelta.setStrBonus( new EmbeddableIntegerBonus(10, StatModTarget.VALUE));
        statBonusDelta.setIntPercentageBonus(new EmbeddableFloatBonus(0.8f,StatModTarget.VALUE));

        prejudice.setTriggerOperation(PrejudiceOperator.OR);
        prejudice.setDelta(statBonusDelta);

        prejudice=statPrejudiceRepository.save(prejudice);


        BasePrejudiceTrigger trigger = prejudiceTriggerRepository.findByName("Gescheitere als 20 trigger");

        prejudice.addTrigger(trigger);

        statPrejudiceRepository.save(prejudice);


    }

    private void createHateAgainstExplosivPeople(){
        StatPrejudice prejudice = new StatPrejudice();
        prejudice.setName("Dicke Haut gegen Explosive Menschen!");
        prejudice.setName("Nation hat eine Dicke Haut gegen expl. Menschen");

        StatBonusDelta statBonusDelta = new StatBonusDelta();
        statBonusDelta.setStrBonus( new EmbeddableIntegerBonus(10, StatModTarget.VALUE));
        statBonusDelta.setIntPercentageBonus(new EmbeddableFloatBonus(0.8f,StatModTarget.VALUE));
        prejudice.setDelta(statBonusDelta);
        prejudice.setTriggerOperation(PrejudiceOperator.OR);

        prejudice = statPrejudiceRepository.save(prejudice);


        CharacteristicPrejudiceTrigger chr = characteristicPrejudiceTriggerRepository.findByName("Explisiver Character Trigger");

        prejudice.addTrigger(chr);



        statPrejudiceRepository.save(prejudice);

    }





}
