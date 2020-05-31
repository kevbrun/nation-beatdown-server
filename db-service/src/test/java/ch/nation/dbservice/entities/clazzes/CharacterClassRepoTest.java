package ch.nation.dbservice.entities.clazzes;

import ch.nation.core.model.Enums.StatGrowthType;
import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.clazzes.CharacterClassRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CharacterClassRepoTest extends AbstractNamedEntityTest<CharacterClass, CharacterClassRepository> {


    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillEffectRepository skillEffectRepository;


    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new CharacterClass();
        entityToTest.setName("Warrior");
        entityToTest.setExp(100);
        entityToTest.setLevel(100);
        entityToTest.setExpToLevelUp(1000);


        listOfEntities.add(entityToTest);


        CharacterClass second = new CharacterClass();
        second.setName("Archer");
        second.setExp(1010);
        second.setExpToLevelUp(10001);
        listOfEntities.add(second);

    }


    @Test
    public void stats_should_not_be_null_after_saving() {
        CharacterClass clazz = repo.save(entityToTest);


        Assert.assertNotNull(clazz.getActionPoints());
        Assert.assertNotNull(clazz.getAgility());
        Assert.assertNotNull(clazz.getDexterity());
        Assert.assertNotNull(clazz.getHealthPoints());
        Assert.assertNotNull(clazz.getIntelligence());
        Assert.assertNotNull(clazz.getStrength());
        Assert.assertNotNull(clazz.getMovementSpeed());
        Assert.assertNotNull(clazz.getVitality());

    }


    @Test
    public void add_skill_to_clazz_test() {
        CharacterClass characterClass = repo.save(entityToTest);


        //Skill Effect
        Skill move = createMoveSkillDummy();
        skillRepository.save(move);
        characterClass.addSkill(move);

        characterClass = repo.save(characterClass);


        Assert.assertTrue(characterClass.getSkills().size() == 1);
        Assert.assertTrue(characterClass.getSkills().get(0).getName().equals("Bewegung!"));
        Assert.assertTrue(characterClass.getSkills().get(0).getSkillEffects().get(0).getName().equals("Bewegungs Effect"));


    }


    @Test
    public void remove_skill_from_clazz_test() {
        CharacterClass characterClass = repo.save(entityToTest);
        Skill move = createMoveSkillDummy();


        skillRepository.save(move);
        characterClass.addSkill(move);

        characterClass = repo.save(characterClass);


        characterClass.removeSkill(move);

        Assert.assertTrue(characterClass.getSkills().size() == 0);

    }

    private Skill createMoveSkillDummy() {
        //Skill Effect
        SkillEffect moveEffect = new SkillEffect();
        moveEffect.setName("Bewegungs Effect");
        moveEffect = skillEffectRepository.save(moveEffect);

        LOGGER.info(moveEffect.toString());

        //Skill
        Skill move = new Skill();
        move.setName("Bewegung!");
        skillRepository.save(move);

        LOGGER.info(move.toString());

        move.addSkillEffect(moveEffect);
        return move;
    }


    @Test
    public void add_multiple_skills_to_clazz() {
        Skill moveSkil = createMoveSkillDummy();

        SkillEffect effect = new SkillEffect();
        effect.setName("Fernkampf Effect!");
        effect.setDescription("Es tut mega weh!");

        effect = skillEffectRepository.save(effect);

        Skill secondSkill = new Skill();
        secondSkill.setName("Attacke!");
        secondSkill.addSkillEffect(effect);
        secondSkill = skillRepository.save(secondSkill);

        CharacterClass clazz = repo.save(entityToTest);

        clazz.addSkill(moveSkil);
        clazz.addSkill(secondSkill);

        clazz = repo.save(clazz);


        Assert.assertTrue(clazz.getSkills().size() == 2);
        Assert.assertTrue(clazz.getSkills().get(0) != null);
        Assert.assertTrue(clazz.getSkills().get(1) != null);


    }

    @Test
    public void remove_skill_from_skills_list() {
        Skill moveSkil = createMoveSkillDummy();

        SkillEffect effect = new SkillEffect();
        effect.setName("Fernkampf Effect!");
        effect.setDescription("Es tut mega weh!");

        effect = skillEffectRepository.save(effect);

        Skill secondSkill = new Skill();
        secondSkill.setName("Attacke!");
        secondSkill.addSkillEffect(effect);
        secondSkill = skillRepository.save(secondSkill);

        CharacterClass clazz = repo.save(entityToTest);

        clazz.addSkill(moveSkil);
        clazz.addSkill(secondSkill);

        clazz = repo.save(clazz);

        clazz.removeSkill(moveSkil);

        Assert.assertTrue(clazz.getSkills().size() == 1);
        Assert.assertTrue(clazz.getSkills().get(0).equals(secondSkill));

    }

    @Test
    public void update_stat_test() {
        CharacterClass saved = repo.save(entityToTest);
        saved.setHealthPoints(new Stat(10f, 0f, 100f, StatGrowthType.EXPONENTIAL));

        saved = repo.save(saved);


        Assert.assertTrue(saved.getHealthPoints().getBaseValue() == 10f);
        Assert.assertTrue(saved.getHealthPoints().getMaxValue() == 100f);
        Assert.assertTrue(saved.getHealthPoints().getMinValue() == 0f);
        Assert.assertTrue(saved.getHealthPoints().getGrowthType() == StatGrowthType.EXPONENTIAL);


    }


    @Override
    public void cleanUp() {
        super.cleanUp();
        skillRepository.deleteAll();
        skillEffectRepository.deleteAll();
    }
}
