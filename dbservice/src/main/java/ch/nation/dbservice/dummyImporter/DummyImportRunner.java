package ch.nation.dbservice.dummyImporter;

import ch.nation.dbservice.dummyImporter.data.clazzes.CharacterClassDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.skills.SkillDummyDataGenerator;
import ch.nation.dbservice.dummyImporter.data.skills.SkillEffectDummyDataGenerator;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.clazzes.CharacterClassRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;
import ch.nation.dbservice.repositories.units.UnitRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyImportRunner  implements ApplicationRunner {


    private final UnitRepository unitRepository;
    private final CharacterClassRepository characterClassRepository;
    private final SkillEffectRepository skillEffectRepository;
    private final SkillRepository skillRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public DummyImportRunner(UnitRepository unitRepository, CharacterClassRepository characterClassRepository, SkillEffectRepository skillEffectRepository, SkillRepository skillRepository) {
        this.unitRepository = unitRepository;
        this.characterClassRepository = characterClassRepository;
        this.skillEffectRepository = skillEffectRepository;
        this.skillRepository = skillRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("START MIGRATION OF DUMMY DATA!");
        SkillEffectDummyDataGenerator skillEffectDummyData = new SkillEffectDummyDataGenerator(skillEffectRepository);
        SkillDummyDataGenerator skillDummyDataGenerator = new SkillDummyDataGenerator(skillRepository,skillEffectRepository);
        CharacterClassDummyGenerator characterClassDummyGenerator = new CharacterClassDummyGenerator(characterClassRepository,skillRepository);



        LOGGER.info("FINISH MIGRATING DATA");
    }


    private void createNahkampfSkillEffect(){

   }



    private void LoadCharacterClasses(){
        LOGGER.info("START MIGRATING CHARACTER CLASSES");
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Warrior");
        characterClassRepository.save(characterClass);

        LOGGER.info("STOP MIGRATING CHARACTER CLASSES");
    }


    public UnitRepository getUnitRepository() {
        return unitRepository;
    }

    public CharacterClassRepository getCharacterClassRepository() {
        return characterClassRepository;
    }

    public SkillEffectRepository getSkillEffectRepository() {
        return skillEffectRepository;
    }

    public SkillRepository getSkillRepository() {
        return skillRepository;
    }
}
