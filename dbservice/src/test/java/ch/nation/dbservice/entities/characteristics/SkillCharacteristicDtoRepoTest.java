package ch.nation.dbservice.entities.characteristics;

import ch.nation.dbservice.entities.AbstractNamedEntityTest;
import ch.nation.dbservice.entities.IHasDiscriminatorValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.characteristics.SkillCharacteristicsRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;
import ch.nation.dbservice.utils.DummyEntitiesCreator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillCharacteristicDtoRepoTest extends AbstractNamedEntityTest<SkillCharacteristic,SkillCharacteristicsRepository> implements IHasDiscriminatorValue {


    @Autowired
    private SkillEffectRepository skillEffectRepository;


    @Autowired
    private SkillRepository skillRepository;

    @Override
    public void setUp() {
        super.setUp();
        entityToTest = new SkillCharacteristic();
        entityToTest.setName("Schnell weg");
        entityToTest.setName("Das Volk ist bekannt weg zu rennen!");

        listOfEntities.add(entityToTest);



        SkillCharacteristic second = new SkillCharacteristic();
        second.setName("Wasserversteck Jutsu!");
        listOfEntities.add(second);

    }


    @Override
    @Test
    public void test_if_has_discriminator_value() {
        SkillCharacteristic statCharacteristics = repo.save(entityToTest);

        Assert.assertEquals(statCharacteristics.getDiscriminatorValue(),"SkillCharacteristic");


    }


    @Test
    public void add_skill_to_characteristic_test(){
      SkillEffect effect = DummyEntitiesCreator.getSkillEffect();
      effect=skillEffectRepository.save(effect);

      Skill skill = DummyEntitiesCreator.getSkill();
      skill  = skillRepository.save(skill);

      skill.addSkillEffect(effect);
      skill= skillRepository.save(skill);


        entityToTest.addSkill(skill);


      entityToTest = repo.save(entityToTest);
      Assert.assertTrue(entityToTest.getSkill().getSkillEffects().get(0)!=null);
      Assert.assertTrue(entityToTest.getSkill().getSkillCharacteristic().get(0).equals(entityToTest));

    }


    @Test
    public void remove_skill_to_characteristic_test(){
        SkillEffect effect = DummyEntitiesCreator.getSkillEffect();
        effect=skillEffectRepository.save(effect);

        Skill skill = DummyEntitiesCreator.getSkill();
        skill  = skillRepository.save(skill);

        skill.addSkillEffect(effect);
        skill= skillRepository.save(skill);


        entityToTest.addSkill(skill);


        entityToTest = repo.save(entityToTest);


        entityToTest.removeSkill();

        Assert.assertTrue(entityToTest.getSkill()==null);
        Assert.assertTrue(skill.getSkillCharacteristic().size()==0);
    }


    @Override
    public void cleanUp() {
        super.cleanUp();
        skillRepository.deleteAll();
        skillEffectRepository.deleteAll();

    }
}
