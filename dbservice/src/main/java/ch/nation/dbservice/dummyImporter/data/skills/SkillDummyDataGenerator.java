package ch.nation.dbservice.dummyImporter.data.skills;

import ch.nation.core.model.Enums.ActionShape;
import ch.nation.core.model.Enums.Target;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.skills.ActionArea;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;

public class SkillDummyDataGenerator extends AbstractDummyGenerator<Skill> {

    private  SkillEffectRepository skillEffectRepository;
    private  SkillRepository skillRepository;

    public SkillDummyDataGenerator(SkillRepository skillRepository,SkillEffectRepository skillEffectRepository) throws Exception {
        super();
        this.skillEffectRepository = skillEffectRepository;
        this.skillRepository = skillRepository;
           handleCration();
    }



    @Override
    protected void handleCration() throws Exception {
        LOGGER.info("START CREATING  SKILLS!");
        createSelfMoveSkill();
        createNahkampfSkill();
        persistData();
        LOGGER.info("FINISH CREATING  SKILLS!");
    }

    private void createSelfMoveSkill() throws Exception {
        Skill skill =  new Skill();
        skill.setName("Bewegung Schweinebacke!");
        skill.setDescription("Setzt eigene Einheit in Bewegung");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.SELF);
        skill.setSkillBarOrder(9999);
        ActionArea actionArea = new ActionArea(4,4,0,0,ActionShape.CROSS);
        skill.setActionArea(actionArea);
       skill= skillRepository.save(skill);

       SkillEffect effect= skillEffectRepository.findByName("Bewegungseffekt!");



       if(effect==null) throw new Exception("Could not find. Skill Effect with name: Bewegungseffekt!");

       skill.addSkillEffect(effect);
       skillRepository.save(skill);


       entities.add(skill);
    }

    private void createNahkampfSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Nahkampf!");
        skill.setDescription("Deine eigene Einheit greift langweilig im Nahkampf an");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.SELF);
        skill.setSkillBarOrder(9998);
        ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.FILLED_BLOCK);



        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByName("Schadenseffekt (Str)");

        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Schadenseffekt (Str)!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);

    }

    private void createFernkampfSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Fernkampf!");
        skill.setDescription("Deine eigene Einheit greift langweilig im Nahkampf an");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.SELF);
        skill.setSkillBarOrder(9998);
        ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.CROSS);



        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByName("Schadenseffekt (Dex)");

        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Schadenseffekt (Dex)!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);

    }


}
