package ch.nation.dbservice.dummyImporter;

import ch.nation.dbservice.dummyImporter.data.clazzes.CharacterClassDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.games.GamesDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.moves.MoveDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.players.PlayerClassDummyGenerator;
import ch.nation.dbservice.dummyImporter.data.skills.SkillDummyDataGenerator;
import ch.nation.dbservice.dummyImporter.data.skills.SkillEffectDummyDataGenerator;
import ch.nation.dbservice.dummyImporter.data.units.UnitsClassDummyGenerator;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.repositories.clazzes.CharacterClassRepository;
import ch.nation.dbservice.repositories.game.GameRepository;
import ch.nation.dbservice.repositories.game.GameUserRuntimeRepository;
import ch.nation.dbservice.repositories.moves.PlayerMoveRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;
import ch.nation.dbservice.repositories.units.UnitRepository;
import ch.nation.dbservice.repositories.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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

    @Autowired
    public DummyImportRunner(UnitRepository unitRepository, CharacterClassRepository characterClassRepository, SkillEffectRepository skillEffectRepository, SkillRepository skillRepository, UserRepository userRepository, GameRepository gameRepository, PlayerMoveRepository playerMoveRepository, GameUserRuntimeRepository gameUserRuntimeRepository) {
        this.unitRepository = unitRepository;
        this.characterClassRepository = characterClassRepository;
        this.skillEffectRepository = skillEffectRepository;
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.playerMoveRepository = playerMoveRepository;
        this.gameUserRuntimeRepository = gameUserRuntimeRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("START MIGRATION OF DUMMY DATA!");
        SkillEffectDummyDataGenerator skillEffectDummyData = new SkillEffectDummyDataGenerator(skillEffectRepository);
    SkillDummyDataGenerator skillDummyDataGenerator = new SkillDummyDataGenerator(skillRepository,skillEffectRepository);
        CharacterClassDummyGenerator characterClassDummyGenerator = new CharacterClassDummyGenerator(characterClassRepository,skillRepository);
        UnitsClassDummyGenerator unitsClassDummyGenerator = new UnitsClassDummyGenerator(unitRepository,characterClassRepository);
        PlayerClassDummyGenerator playerClassDummyGenerator = new PlayerClassDummyGenerator(userRepository,unitRepository);
        MoveDummyGenerator moveDummyGenerator = new MoveDummyGenerator(userRepository,playerMoveRepository,gameRepository,skillRepository, gameUserRuntimeRepository);
        new GamesDummyGenerator(gameRepository,userRepository,gameUserRuntimeRepository);


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
