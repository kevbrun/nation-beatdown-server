package ch.nation.dbservice.dummyImporter.data.clazzes;

import ch.nation.core.model.Enums.StatGrowthType;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.clazzes.Stat;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.repositories.clazzes.CharacterClassRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;

public class CharacterClassDummyGenerator extends AbstractDummyGenerator<CharacterClass> {


    private CharacterClassRepository characterClassRepository;
    private SkillRepository skillRepository;

    public CharacterClassDummyGenerator(CharacterClassRepository characterClassRepository, SkillRepository skillRepository) throws Exception {
        super();
        this.characterClassRepository = characterClassRepository;
        this.skillRepository = skillRepository;
        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        LOGGER.info("START | CREATE Character Classes");
        createWarriorClazz();
        createBarbarClazz();
        createTimeHunterClazz();
        LOGGER.info("STOP | CREATE Character Classes");
    }


    private void createWarriorClazz() throws Exception {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Krieger");
        characterClass.setDescription("Ein tapferer Krieger!");
        characterClass.setLevel(1);
        characterClass.setExp(0);
        characterClass.setExpToLevelUp(1000);
        characterClass.setHealthPoints(new Stat(200f,0.0f,200f,StatGrowthType.LINEAR));
        characterClass.setActionPoints(new Stat(100f,0.0f,100f,StatGrowthType.LOGARITHMIC));
        characterClass.setStrength(new Stat(10f,10f,999f,StatGrowthType.LINEAR));
        characterClass.setAgility(new Stat(6f,6f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setIntelligence(new Stat(3f,3f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setDexterity(new Stat(7f,7f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setVitality(new Stat(8f,8f,999f,StatGrowthType.LINEAR));
        characterClass.setMovementSpeed(new Stat(5f,5f,5f,StatGrowthType.NONE));

        characterClassRepository.save(characterClass);

        Skill skill = skillRepository.findByName("Nahkampf!");

        if(skill==null) throw new Exception("Could not found Nahkampf!");

        characterClass.addSkill(skill);

        Skill moveSkill = skillRepository.findByName("Bewegung Schweinebacke!");

        if(moveSkill==null) throw new Exception("could no find skill: Bewegung Schweinebacke!");

        characterClass.addSkill(moveSkill);

        characterClassRepository.save(characterClass);



    }

    private void createBarbarClazz() throws Exception {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Barbar");
        characterClass.setDescription("Ein möchtegern Conan!");
        characterClass.setLevel(1);
        characterClass.setExp(0);
        characterClass.setExpToLevelUp(1000);
        characterClass.setHealthPoints(new Stat(200f,0.0f,200f,StatGrowthType.LINEAR));
        characterClass.setActionPoints(new Stat(100f,0.0f,100f,StatGrowthType.LOGARITHMIC));
        characterClass.setStrength(new Stat(10f,10f,999f,StatGrowthType.LINEAR));
        characterClass.setAgility(new Stat(6f,6f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setIntelligence(new Stat(3f,3f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setDexterity(new Stat(7f,7f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setVitality(new Stat(8f,8f,999f,StatGrowthType.LINEAR));
        characterClass.setMovementSpeed(new Stat(5f,5f,5f,StatGrowthType.NONE));

        characterClassRepository.save(characterClass);

        Skill skill = skillRepository.findByName("Nahkampf!");

        if(skill==null) throw new Exception("Could not found Nahkampf!");

        characterClass.addSkill(skill);

        Skill moveSkill = skillRepository.findByName("Bewegung Schweinebacke!");

        if(moveSkill==null) throw new Exception("could no find skill: Bewegung Schweinebacke!");

        characterClass.addSkill(moveSkill);

        characterClassRepository.save(characterClass);



    }


    private void createTimeHunterClazz() throws Exception {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Zeitjäger");
        characterClass.setDescription("Ein Jäger, welcher durch die Zeit reist.");
        characterClass.setLevel(1);
        characterClass.setExp(0);
        characterClass.setExpToLevelUp(1000);
        characterClass.setHealthPoints(new Stat(100f,0.0f,100f,StatGrowthType.LINEAR));
        characterClass.setActionPoints(new Stat(150f,0.0f,150f,StatGrowthType.LOGARITHMIC));
        characterClass.setStrength(new Stat(5f,5f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setAgility(new Stat(6f,6f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setIntelligence(new Stat(7f,3f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setDexterity(new Stat(10f,7f,999f,StatGrowthType.LOGARITHMIC));
        characterClass.setVitality(new Stat(4f,8f,999f,StatGrowthType.LINEAR));
        characterClass.setMovementSpeed(new Stat(5f,5f,5f,StatGrowthType.NONE));

        characterClassRepository.save(characterClass);

        Skill skill = skillRepository.findByName("Fernkampf!");

        if(skill==null) throw new Exception("Could not found Fernkampf!");

        characterClass.addSkill(skill);


        Skill timeTravelCompleteRoundSkill = skillRepository.findByName("Zurückgesetzt");

        if(timeTravelCompleteRoundSkill==null) throw new Exception("Could not found Zurückgesetzt!");


        characterClass.addSkill(timeTravelCompleteRoundSkill);

        Skill moveSkill = skillRepository.findByName("Bewegung Schweinebacke!");

        if(moveSkill==null) throw new Exception("could no find skill: Bewegung Schweinebacke!");

        characterClass.addSkill(moveSkill);



        characterClassRepository.save(characterClass);



    }



}