package ch.nation.dbservice.dummyImporter;

import ch.nation.dbservice.dummyImporter.data.characteristics.CharacteristicsDummyImporter;
import ch.nation.dbservice.dummyImporter.data.clazzes.CharacterClassDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.games.GamesDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.moves.MoveDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.names.NameImporter;
import ch.nation.dbservice.dummyImporter.data.players.PlayerClassDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.prejudices.PrejudiceDummyImporter;
import ch.nation.dbservice.dummyImporter.data.prejudices.PrejudiceTriggerDummyImporter;
import ch.nation.dbservice.dummyImporter.data.skills.SkillDummyDataGenerator;
import ch.nation.dbservice.dummyImporter.data.skills.SkillEffectDummyDataGenerator;
import ch.nation.dbservice.dummyImporter.data.units.UnitsClassDummyGenerator;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.repositories.characteristics.CharacteristicsRepository;
import ch.nation.dbservice.repositories.clazzes.CharacterClassRepository;
import ch.nation.dbservice.repositories.game.GameRepository;
import ch.nation.dbservice.repositories.game.GameUserRuntimeRepository;
import ch.nation.dbservice.repositories.moves.PlayerMoveRepository;
import ch.nation.dbservice.repositories.names.UnitFirstNameRepository;
import ch.nation.dbservice.repositories.names.UnitLastNameRepository;
import ch.nation.dbservice.repositories.prejudices.PrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.SkillPrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.StatPrejudiceRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.CharacteristicPrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.PrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.prejudices.triggers.StatPrejudiceTriggerRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;
import ch.nation.dbservice.repositories.units.UnitRepository;
import ch.nation.dbservice.repositories.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DummyImportRunner  implements ApplicationRunner {


    private final UnitRepository unitRepository;
    private final CharacterClassRepository characterClassRepository;
    private final SkillEffectRepository skillEffectRepository;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final PlayerMoveRepository playerMoveRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final GameUserRuntimeRepository gameUserRuntimeRepository;
    private final CharacteristicsRepository characteristicsRepository;
    private final CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository;
    private final StatPrejudiceTriggerRepository statPrejudiceTriggerRepository;
    private final SkillPrejudiceRepository skillPrejudiceRepository;
    private final StatPrejudiceRepository statPrejudiceRepository;
    private final PrejudiceRepository prej;
    private final PrejudiceTriggerRepository prejudiceTriggerRepository;
    private final UnitFirstNameRepository firstNameRepository;
    private final UnitLastNameRepository lastNameRepository;
    private final BCryptPasswordEncoder encoder;


    @Autowired
    public DummyImportRunner(UnitRepository unitRepository, CharacterClassRepository characterClassRepository, SkillEffectRepository skillEffectRepository, SkillRepository skillRepository, UserRepository userRepository, GameRepository gameRepository, PlayerMoveRepository playerMoveRepository, GameUserRuntimeRepository gameUserRuntimeRepository, CharacteristicsRepository characteristicsRepository, CharacteristicPrejudiceTriggerRepository characteristicPrejudiceTriggerRepository, StatPrejudiceTriggerRepository statPrejudiceTriggerRepository, SkillPrejudiceRepository skillPrejudiceRepository, StatPrejudiceRepository statPrejudiceRepository, PrejudiceRepository prej, PrejudiceTriggerRepository prejudiceTriggerRepository, UnitFirstNameRepository firstNameRepository, UnitLastNameRepository lastNameRepository, BCryptPasswordEncoder encoder) {
        this.unitRepository = unitRepository;
        this.characterClassRepository = characterClassRepository;
        this.skillEffectRepository = skillEffectRepository;
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.playerMoveRepository = playerMoveRepository;
        this.gameUserRuntimeRepository = gameUserRuntimeRepository;
        this.characteristicsRepository = characteristicsRepository;
        this.characteristicPrejudiceTriggerRepository = characteristicPrejudiceTriggerRepository;
        this.statPrejudiceTriggerRepository = statPrejudiceTriggerRepository;
        this.skillPrejudiceRepository = skillPrejudiceRepository;
        this.statPrejudiceRepository = statPrejudiceRepository;
        this.prej = prej;
        this.prejudiceTriggerRepository = prejudiceTriggerRepository;
        this.firstNameRepository = firstNameRepository;
        this.lastNameRepository = lastNameRepository;
        this.encoder = encoder;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
     LOGGER.info("START MIGRATION OF DUMMY DATA!");

        new NameImporter(firstNameRepository, lastNameRepository);
       new SkillEffectDummyDataGenerator(skillEffectRepository);
     new SkillDummyDataGenerator(skillRepository,skillEffectRepository);
        new CharacterClassDummyGenerator(characterClassRepository,skillRepository);
       new UnitsClassDummyGenerator(unitRepository,characterClassRepository);
        new PlayerClassDummyGenerator(userRepository,unitRepository, encoder);
        new MoveDummyGenerator(userRepository,playerMoveRepository,gameRepository,skillRepository, gameUserRuntimeRepository);
        new GamesDummyGenerator(gameRepository,userRepository,gameUserRuntimeRepository);
        new CharacteristicsDummyImporter(characteristicsRepository,skillRepository);
        new PrejudiceTriggerDummyImporter(characteristicPrejudiceTriggerRepository,characteristicsRepository,statPrejudiceTriggerRepository);
        new PrejudiceDummyImporter(prejudiceTriggerRepository,skillPrejudiceRepository,skillRepository,statPrejudiceTriggerRepository,statPrejudiceRepository,characteristicPrejudiceTriggerRepository);
        LOGGER.info("FINISH MIGRATING DATA");
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
