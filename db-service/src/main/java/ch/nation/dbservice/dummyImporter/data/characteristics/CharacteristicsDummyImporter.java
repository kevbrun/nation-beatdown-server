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

    }


    private void createDumbButStrongCharacteristic(){
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Dumm aber Stark!");
        statCharacteristic.setDescription("Nation ist stark aber dumm wie Brot!");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setStrBonus(new EmbeddableIntegerBonus(10, StatModTarget.MAX_VALUE));
        bonus.setIntBonus(new EmbeddableIntegerBonus(-15, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);
        characteristicsRepository.save(statCharacteristic);
    }


    private void createWeakButIntelligent(){
        StatCharacteristic statCharacteristic = new StatCharacteristic();
        statCharacteristic.setName("Intelligent aber schwach\n wie eine Brezel!");
        statCharacteristic.setDescription("Nation ist schwach aber intelligent");
        StatBonusDelta bonus = new StatBonusDelta();
        bonus.setStrBonus(new EmbeddableIntegerBonus(-10, StatModTarget.MAX_VALUE));
        bonus.setIntBonus(new EmbeddableIntegerBonus(15, StatModTarget.MAX_VALUE));
        statCharacteristic.setDelta(bonus);

        characteristicsRepository.save(statCharacteristic);
    }

    private void createExplosiveCharacteristics(){
        SkillCharacteristic cc = new SkillCharacteristic();
        cc.setName("Explosiver Character");
        cc.setDescription("Die Nation wird schnell wütend");
        cc= characteristicsRepository.save(cc);

        Skill skill = skillRepository.findByName("Explosion!");
        cc.setSkill(skill);

        characteristicsRepository.save(cc);
    }



}
