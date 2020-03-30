package ch.nation.dbservice.dummyImporter.data.characteristics;

import ch.nation.core.model.Enums.StatModTarget;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.bonus.EmbeddableIntegerBonus;
import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.characteristics.StatCharacteristic;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;

public class CharacteristicsDummyImporter extends AbstractDummyGenerator<BaseCharacteristic> {


    private final CharacteristicsRepository characteristicsRepository;
    private final SkillRepository skillRepository;

    public CharacteristicsDummyImporter(CharacteristicsRepository characteristicsRepository, SkillRepository skillRepository) throws Exception {
        this.characteristicsRepository = characteristicsRepository;
        this.skillRepository = skillRepository;

        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        createExplosiveCharacteristics();
        createDumbButStrongCharacteristic();
        createWeakButIntelligent();
        createFastButLowHealth();
        createDrunk();
        createLessVitButStr();
        createIntelligent();
        createLessStr();
        createLessVit();

    }

//
    private void createDumbButStrongCharacteristic() {
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Dumm aber Stark!");
        statCharacteristic.setIdentifier("less_int_10_more_str_10");
        statCharacteristic.setDescription("Nation ist stark aber dumm wie Brot!");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setStrBonus(new EmbeddableIntegerBonus(10, StatModTarget.MAX_VALUE));
        bonus.setIntBonus(new EmbeddableIntegerBonus(-15, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);
        characteristicsRepository.save(statCharacteristic);
    }


    //
    private void createWeakButIntelligent() {
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Intelligent aber schwach\n wie eine Brezel!");
        statCharacteristic.setIdentifier("less_str_10_more_int_15");

        statCharacteristic.setDescription("Nation ist schwach aber intelligent");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setStrBonus(new EmbeddableIntegerBonus(-10, StatModTarget.MAX_VALUE));
        bonus.setIntBonus(new EmbeddableIntegerBonus(15, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);

        characteristicsRepository.save(statCharacteristic);
    }


//
    private void createFastButLowHealth() {
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Beweglich aber laut und ungenau");
        statCharacteristic.setIdentifier("less_dex_10_more_agi_15");

        statCharacteristic.setDescription("Beweglich aber laut und ungenau!");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setAgiBonus(new EmbeddableIntegerBonus(-10, StatModTarget.MAX_VALUE));
        bonus.setDexBonus(new EmbeddableIntegerBonus(15, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);

        characteristicsRepository.save(statCharacteristic);
    }


//
    private void createDrunk() {
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Dauer besoffen!");
        statCharacteristic.setIdentifier("less_ap_10_more_vit_15");

        statCharacteristic.setDescription("Nation ist dauernd betrunken! Sie empfinden eine höhere Ausdauer. Können sich aber nicht weit bewegen");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setVitBonus(new EmbeddableIntegerBonus(15, StatModTarget.MAX_VALUE));
        bonus.setApBonus(new EmbeddableIntegerBonus(-10, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);

        characteristicsRepository.save(statCharacteristic);
    }

//
    private void createExplosiveCharacteristics() {
        SkillCharacteristic cc = new SkillCharacteristic();
        cc.setName("Explosiver Character");
        cc.setIdentifier("expl");
        cc.setDescription("Die Nation wird schnell wütend");
        cc = characteristicsRepository.save(cc);

        Skill skill = skillRepository.findByIdentifier("dmg_expl_target_hp");
        cc.setSkill(skill);

        characteristicsRepository.save(cc);
    }


    //
    private void createLessVitButStr(){
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Leute mit grosser Schnauze");
        statCharacteristic.setIdentifier("less_str_10_more_vit_15");
        statCharacteristic.setDescription("Nation ist aggresiv, aber ausser heisser Luft nichts dahinter");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setVitBonus(new EmbeddableIntegerBonus(15, StatModTarget.MAX_VALUE));
        bonus.setStrBonus(new EmbeddableIntegerBonus(-10, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);
        characteristicsRepository.save(statCharacteristic);
    }
//
    private void createIntelligent(){
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Intelligent");
        statCharacteristic.setIdentifier("more_int_5");
        statCharacteristic.setDescription("Nation ist intelligent");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setIntBonus(new EmbeddableIntegerBonus(5, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);
        characteristicsRepository.save(statCharacteristic);
    }

    //
    private void createLessStr(){
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Strength");
        statCharacteristic.setIdentifier("less_str_5");
        statCharacteristic.setDescription("Nation ist schwach");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setStrBonus(new EmbeddableIntegerBonus(-5, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);
        characteristicsRepository.save(statCharacteristic);
    }

    //
    private void createLessVit(){
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Fast Food macht träge!");
        statCharacteristic.setIdentifier("less_vit_5");
        statCharacteristic.setDescription("Fast Food macht träge!");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setVitBonus(new EmbeddableIntegerBonus(-5, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);
        characteristicsRepository.save(statCharacteristic);
    }



}
