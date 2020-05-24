package ch.nation.dbservice.dummyImporter.data.skills;

import ch.nation.core.model.Enums.*;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.skills.ActionArea;
import ch.nation.dbservice.entities.skills.SelfMoveSkill;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillAnimationInfo;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;

public class SkillDummyDataGenerator extends AbstractDummyGenerator<Skill> {

    private SkillEffectRepository skillEffectRepository;
    private SkillRepository skillRepository;

    public SkillDummyDataGenerator(SkillRepository skillRepository, SkillEffectRepository skillEffectRepository) throws Exception {
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
        //   createMoveOtherSkill();
        createFernkampfSkill();
        createReturnOneRoundBackSkill();
        createResetAPSkill();
        createResetHPSkill();
        createSelfExplosion();
        createOnSkillBackSkill();
        createSturmangriff();
        createHealAllSkill();
        createFirstAidSkill();
        persistData();
        LOGGER.info("FINISH CREATING  SKILLS!");
    }

    private void createSelfMoveSkill() throws Exception {
        Skill skill = new SelfMoveSkill();
        skill.setName("Bewegung!");
        skill.setIdentifier("mv_self");
        skill.setDescription("Bewege eine Einheit!");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.SELF);
        skill.setIconPath("Skill_standart/Assassinskill_50");
        skill.setSkillBarOrder(9999);
        ActionArea actionArea = new ActionArea(4, 4, 0, 0, true, ActionShape.FILLED_BLOCK, AreaTileStyle.WALK);
        skill.setActionArea(actionArea);
        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("mv_self");


        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Selbstbewegungseffekt!");

        skill.addSkillEffect(effect);
        skillRepository.save(skill);


        entities.add(skill);
    }


    private void createReturnOneRoundBackSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Auf Anfang!");
        skill.setIdentifier("rev_any_round");

        skill.setDescription("Mache alle Züge einer Einheit der letzten Runde rückgängig");
        skill.setCost(100);
        skill.setCooldown(999);
        skill.setSkillBarOrder(1);
        skill.setTarget(Target.ANY_SINGLE);
        skill.setIconPath("Skill_standart/Engineerskill_15");

        ActionArea actionArea = new ActionArea();
        actionArea.setSizeInXAxis(2);
        actionArea.setSizeInYAxis(2);
        actionArea.setShape(ActionShape.FILLED_CIRCLE);
        skill.setActionArea(actionArea);


        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("rev_target_round");
        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Bewegungseffekt!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);


        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("ONE_ROUND_BACK_SKILL");
        info.setTarget(SkillEffectTarget.TARGET);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);


    }

    private void createOnSkillBackSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Nope!");
        skill.setIdentifier("rev_any_action");

        skill.setDescription("Mache die letzte Aktion rückgänging!");
        skill.setCost(60);
        skill.setCooldown(999);
        skill.setSkillBarOrder(2);
        skill.setTarget(Target.ANY_SINGLE);
        skill.setIconPath("Skill_standart/Engineerskill_14");


        ActionArea actionArea = new ActionArea();
        actionArea.setSizeInXAxis(5);
        actionArea.setSizeInYAxis(5);
        actionArea.setShape(ActionShape.CROSS);
        skill.setActionArea(actionArea);


        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("rev_target_step");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);
        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("ONE_SKILL_BACK_SKILL");
        info.setTarget(SkillEffectTarget.TARGET);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);

    }

    /**
     * private void createMoveOtherSkill() throws Exception {
     * Skill skill = new MoveSkill();
     * skill.setName("Bewegung du Sack!");
     * skill.setIdentifier("mv_target");
     * <p>
     * skill.setDescription("Bewege gegnerisch Einheit!");
     * skill.setCost(20);
     * skill.setCurrentCooldownTimer(0);
     * skill.setTarget(Target.ENEMY_SINGLE);
     * <p>
     * skill.setSkillBarOrder(5);
     * ActionArea actionArea = new ActionArea(4, 4, 0, 0, true, ActionShape.FILLED_BLOCK,AreaTileStyle.WALK);
     * skill.setActionArea(actionArea);
     * skill = skillRepository.save(skill);
     * <p>
     * SkillEffect effect = skillEffectRepository.findByIdentifier("mv_target");
     * <p>
     * <p>
     * if (effect == null) throw new Exception("Could not find. Skill Effect with name: Bewegungseffekt!");
     * <p>
     * skill.addSkillEffect(effect);
     * skillRepository.save(skill);
     * <p>
     * <p>
     * entities.add(skill);
     * }
     **/

    private void createNahkampfSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Nahkampf!");
        skill.setIdentifier("dmg_target_str");
        skill.setDescription("Eine langweilige Standardattacke.");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.ENEMY_SINGLE);
        skill.setSkillBarOrder(9998);

        skill.setIconPath("Skill_standart/Warriorskill_13");
        ActionArea actionArea = new ActionArea(2, 2, 0, 0, true, ActionShape.FILLED_BLOCK, AreaTileStyle.ATTACK_AXE);
        skill.setActionArea(actionArea);

        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("WEAPON_ATTACK");
        info.setTarget(SkillEffectTarget.CASTER);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("dmg_target_str");

        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Schadenseffekt (Str)!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);

    }


    private void createSturmangriff() {
        Skill skill = new Skill();
        skill.setName("Volles Pfund aufs Maul!");
        skill.setIdentifier("move-caster_target_str");
        skill.setDescription("Einheit bewegt sich auf eine andere Einheit zu und greift diese an!");
        skill.setCost(50);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.ENEMY_SINGLE);
        skill.setSkillBarOrder(9000);
        ActionArea actionArea = new ActionArea(5, 5, 0, 0, true, ActionShape.CROSS, AreaTileStyle.ATTACK_AXE);
        skill.setActionArea(actionArea);
        skill.setIconPath("Skill_standart/Warriorskill_48");


        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("STURMANGRIFF");
        info.setTarget(SkillEffectTarget.CASTER);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);

    /*
     //IMPLEMENTATION OVER ANIMATION_INTERPRETER => ADD IT AGAIN FOR FINAL PRODUCT NOT USED IN MA VERSION
    SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.SCRIPT);
        info.setName("SELF_MOVE_ANIMATION");
        info.setTarget(SkillEffectTarget.CASTER);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);

        info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("WEAPON_ATTACK");
        info.setTarget(SkillEffectTarget.CASTER);
        info.setWeaponType(WeaponType.MELEE1H);ex

        skill = skillRepository.save(skill);*/

      /**  SkillEffect effect = skillEffectRepository.findByIdentifier("mv_self");
        skill.addSkillEffect(effect);**/

        skill.addSkillEffect(skillEffectRepository.findByIdentifier("dmg_target_str"));
        skillRepository.save(skill);


    }

    private void createFernkampfSkill() throws Exception {
        Skill skill = new Skill();
        skill.setName("Fernkampf!");
        skill.setIdentifier("dmg-range_target_str");

        skill.setDescription("Einfacher und langweiliger Fernkampf.");
        skill.setCost(20);
        skill.setCurrentCooldownTimer(0);
        skill.setTarget(Target.ENEMY_SINGLE);
        skill.setSkillBarOrder(9998);
        ActionArea actionArea = new ActionArea(5, 5, 0, 0, true, ActionShape.FILLED_CIRCLE, AreaTileStyle.ATTACK_AXE);
        skill.setActionArea(actionArea);
        skill.setIconPath("Skill_standart/Archerskill_12");

        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("WEAPON_ATTACK");
        info.setTarget(SkillEffectTarget.CASTER);
        info.setWeaponType(WeaponType.BOW);
        skill.addAnimInfo(info);

        skill = skillRepository.save(skill);

        SkillEffect effect = skillEffectRepository.findByIdentifier("dmg_target_dex");

        if (effect == null) throw new Exception("Could not find. Skill Effect with name: Schadenseffekt (Dex)!");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);

    }


    private void createResetAPSkill() {
        Skill skill = new Skill();
        skill.setName("Reset AP");
        skill.setIdentifier("reset_caster_ap");

        skill.setDescription("Setze AP auf Max Wert");
        skill.setCost(0);
        skill.setCurrentCooldownTimer(0);
        skill.setCooldown(0);
        skill.setSkillBarOrder(9999);
        ActionArea actionArea = new ActionArea(5, 5, 0, 0,
                true, ActionShape.FILLED_CIRCLE, AreaTileStyle.NONE);
        skill.setTarget(Target.SELF);
        skill.setActionArea(actionArea);
        skill.setIconPath("Skill_standart/Archerskill_13");


        skill = skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("reset_caster_ap");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);
    }


    private void createResetHPSkill() {
        Skill skill = new Skill();
        skill.setName("Reset HP");
        skill.setIdentifier("reset_caster_hp");

        skill.setDescription("Setze HP auf Max Wert");
        skill.setCost(0);
        skill.setCurrentCooldownTimer(0);
        skill.setCooldown(0);
        skill.setSkillBarOrder(9999);
        skill.setIconPath("Skill_standart/Archerskill_13");
        ActionArea actionArea = new ActionArea(5, 5, 0, 0, true, ActionShape.FILLED_CIRCLE, AreaTileStyle.NONE);
        skill.setTarget(Target.SELF);
        skill.setActionArea(actionArea);


        skill = skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("reset_caster_hp");

        skill.addSkillEffect(effect);

        skillRepository.save(skill);
    }

    private void createSelfExplosion() {
        Skill skill = new Skill();
        skill.setName("Wutausbruch!");
        skill.setIdentifier("dmg_expl_target_hp");
        skill.setDescription("Setzt alle Einheiten im Bereich in Brand.");
        skill.setCost(0);
        skill.setCooldown(10000);
        skill.setSkillBarOrder(9999);
        skill.setIconPath("Skill_standart/Warriorskill_30");
        ActionArea actionArea = new ActionArea(5, 5, 0, 0, true, ActionShape.FILLED_CIRCLE, AreaTileStyle.ATTACK_AXE);
        skill.setTarget(Target.AREA_ENEMY);
        skill.setActionArea(actionArea);
        skill = skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("dmg_caster_hp");
        skill.addSkillEffect(effect);
        effect = skillEffectRepository.findByIdentifier("dmg_target_str");
        skill.addSkillEffect(effect);
        skill = skillRepository.save(skill);


        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("BERSERKER_SKILL");
        info.setTarget(SkillEffectTarget.TARGET);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);

    }


    // Heal Skills
    private void createFirstAidSkill() {
        Skill skill = new Skill();
        skill.setName("Erste Hilfe!");
        skill.setIdentifier("heal_target_hp");
        skill.setDescription("Heile eine Einheit.");
        skill.setSkillBarOrder(8001);
        skill.setCost(40);
        skill.setCooldown(0);
        skill.setTarget(Target.PARTY_SINGLE);
        skill.setIconPath("Skill_standart/Priestskill_23");
        ActionArea actionArea = new ActionArea(5, 5, 0, 0, true, ActionShape.FILLED_CIRCLE, AreaTileStyle.POSITIVE_HEAL);
        skill.setActionArea(actionArea);
        skill = skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("heal_target_hp");
        skill.addSkillEffect(effect);
        skill = skillRepository.save(skill);



        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("HEAL_ONE");
        info.setTarget(SkillEffectTarget.TARGET);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);



    }


    // Heal Skills
    private void createHealAllSkill() {
        Skill skill = new Skill();
        skill.setName("Gruppenheilung!");
        skill.setIdentifier("heal_targets_hp");
        skill.setDescription("Heile alle Einheiten.");
        skill.setSkillBarOrder(8000);
        skill.setCost(40);
        skill.setCooldown(999999);
        skill.setTarget(Target.PARTY_ALL);
        skill.setIconPath("Skill_standart/Priestskill_24");
        ActionArea actionArea = new ActionArea(3, 3, 0, 0, true, ActionShape.FILLED_CIRCLE, AreaTileStyle.POSITIVE_HEAL);
        skill.setActionArea(actionArea);
        skill = skillRepository.save(skill);
        SkillEffect effect = skillEffectRepository.findByIdentifier("heal_target_hp");
        skill.addSkillEffect(effect);
        skill = skillRepository.save(skill);

        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(3.0f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("HEAL_GROUP");
        info.setTarget(SkillEffectTarget.TARGET);
        info.setWeaponType(WeaponType.MELEE1H);
        skill.addAnimInfo(info);
        skill = skillRepository.save(skill);

    }


}
