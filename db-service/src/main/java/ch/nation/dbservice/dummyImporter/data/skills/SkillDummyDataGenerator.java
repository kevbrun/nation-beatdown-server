package ch.nation.dbservice.dummyImporter.data.skills;

import ch.nation.core.model.Enums.*;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.skills.ActionArea;
import ch.nation.dbservice.entities.skills.MoveSkill;
import ch.nation.dbservice.entities.skills.SelfMoveSkill;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SelfMoveEffect;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.skills.effects.TimeReversalSkillEffect;
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
        createMoveOtherSkill();
        createFernkampfSkill();
        createTimeTravelSkill();
        createResetAPSkill();
        createResetHPSkill();
        createSelfExplosion();
        persistData();
        LOGGER.info("FINISH CREATING  SKILLS!");
    }

    private void createSelfMoveSkill() throws Exception {
        Skill skill =  new SelfMoveSkill();
        skill.setName("Bewegung Schweinebacke!");
        skill.setIdentifier("mv_self");
        skill.setDescription("Setzt eigene Einheit in Bewegung");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.SELF);

        skill.setSkillBarOrder(9999);
        ActionArea actionArea = new ActionArea(4,4,0,0,ActionShape.FILLED_BLOCK);
        skill.setActionArea(actionArea);
       skill= skillRepository.save(skill);

       SkillEffect effect= skillEffectRepository.findByIdentifier("mv_self");



       if(effect==null) throw new Exception("Could not find. Skill Effect with name: Selbstbewegungseffekt!");

       skill.addSkillEffect(effect);
       skillRepository.save(skill);


       entities.add(skill);
    }


    private void createTimeTravelSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Zurückgesetzt");
        skill.setIdentifier("rev_any_round");

        skill.setDescription("Setze die Figur um einen Zug zurück");
        skill.setCost(30);
        skill.setCooldown(5);
        skill.setSkillBarOrder(1);
        skill.setTarget(Target.ANY_SINGLE);
        ActionArea actionArea = new ActionArea();
        actionArea.setSizeInXAxis(4);
        actionArea.setSizeInYAxis(4);
        actionArea.setShape(ActionShape.CIRCLE);
        skill.setActionArea(actionArea);


      skill=  skillRepository.save(skill);

       SkillEffect effect= skillEffectRepository.findByIdentifier("rev_target_round");
        if(effect==null) throw new Exception("Could not find. Skill Effect with name: Bewegungseffekt!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);


    }

    private void createMoveOtherSkill() throws Exception {
        Skill skill =  new MoveSkill();
        skill.setName("Bewegung du Sack!");
        skill.setIdentifier("mv_target");

        skill.setDescription("Bewege gegnerisch Einheit!");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.ENEMY_SINGLE);

        skill.setSkillBarOrder(5);
        ActionArea actionArea = new ActionArea(4,4,0,0,ActionShape.FILLED_BLOCK);
        skill.setActionArea(actionArea);
        skill= skillRepository.save(skill);

        SkillEffect effect= skillEffectRepository.findByIdentifier("mv_target");



        if(effect==null) throw new Exception("Could not find. Skill Effect with name: Bewegungseffekt!");

        skill.addSkillEffect(effect);
        skillRepository.save(skill);


        entities.add(skill);
    }

    private void createNahkampfSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Nahkampf!");
        skill.setIdentifier("dmg_target_str");
        skill.setDescription("Deine eigene Einheit greift langweilig im Nahkampf an");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.ENEMY_SINGLE);
        skill.setSkillBarOrder(9998);
        ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.FILLED_BLOCK);
        skill.setActionArea(actionArea);



        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("dmg_target_str");

        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Schadenseffekt (Str)!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);

    }

    private void createFernkampfSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Fernkampf!");
        skill.setIdentifier("dmg-range_target_str");

        skill.setDescription("Deine eigene Einheit greift langweilig im Fernkampf an");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.ENEMY_SINGLE);
        skill.setSkillBarOrder(9998);
        ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.FILLED_CIRCLE);
        skill.setActionArea(actionArea);


        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("dmg_target_dex");

        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Schadenseffekt (Dex)!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);

    }


    private void createResetAPSkill(){
        Skill skill = new Skill();
        skill.setName("Reset AP");
        skill.setIdentifier("reset_caster_ap");

        skill.setDescription("Setze AP auf Max Wert");
        skill.setCost(0);
        skill.setCurrentCooldownTimer(0);
        skill.setCooldown(0);
        skill.setSkillBarOrder(9999);
        ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.FILLED_CIRCLE);
        skill.setTarget(Target.SELF);
        skill.setActionArea(actionArea);


        skill= skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("reset_caster_ap");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);
    }


    private void createResetHPSkill(){
        Skill skill = new Skill();
        skill.setName("Reset HP");
        skill.setIdentifier("reset_caster_hp");

        skill.setDescription("Setze HP auf Max Wert");
        skill.setCost(0);
        skill.setCurrentCooldownTimer(0);
        skill.setCooldown(0);
        skill.setSkillBarOrder(9999);
        ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.FILLED_CIRCLE);
        skill.setTarget(Target.SELF);
        skill.setActionArea(actionArea);


        skill= skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("reset_caster_hp");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);
    }

      private void createSelfExplosion(){
         Skill skill = new Skill();
         skill.setName("Explosion!");
          skill.setIdentifier("dmg_expl_target_hp");
         skill.setDescription("Einheit explodiert vor Wut!");
         skill.setCost(0);
         skill.setCooldown(10000);
          skill.setSkillBarOrder(9999);
          ActionArea actionArea = new ActionArea(5,5,0,0,ActionShape.FILLED_CIRCLE);
          skill.setTarget(Target.AREA_ENEMY);
          skill.setActionArea(actionArea);


          skill= skillRepository.save(skill);

          SkillEffect effect = skillEffectRepository.findByIdentifier("dmg_caster_hp");
          skill.addSkillEffect(effect);


          effect = skillEffectRepository.findByIdentifier("dmg_target_str");

          skill.addSkillEffect(effect);
          skill = skillRepository.save(skill);



      }

}
