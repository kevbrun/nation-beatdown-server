package ch.nation.dbservice.dummyImporter.data.skills;

import ch.nation.core.model.Enums.*;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.skills.effects.*;
import ch.nation.dbservice.repositories.skills.effects.SkillEffectRepository;

public class SkillEffectDummyDataGenerator extends AbstractDummyGenerator {


    private SkillEffectRepository skillEffectRepository;


    public SkillEffectDummyDataGenerator(SkillEffectRepository skillEffectRepository) throws Exception {
        super();
        this.skillEffectRepository = skillEffectRepository;
        handleCration();
    }

    @Override
    protected void handleCration() {
        createSkillEffects();
        persistData();
    }

    private void createSkillEffects() {
        LOGGER.info("START MIGRATING SKILL EFFEFCTS");
        createSchadenDexEffekt();
        createSchadenStrEffekt();
        createSelfMoveEffect();
        createMoveEffect();
        createTimeReversalSkill();
        createCompleteRoundSkillEffect();
        createResetAPSkillEffect();
        createResetHPSkillEffect();
        createSelfDamageEffect();
        createHealEffect();
        LOGGER.info("START MIGRATING SKILL EFFEFCTS");
    }

    private void createSchadenDexEffekt() {
        SkillEffect effect;
        effect = new StatSkillEffect();
        effect.setName("Waffen Schadenseffekt Schadenseffekt (Dex)");
        effect.setIdentifier("dmg_target_dex");
        effect.setApplyCalculationOnStat(StatType.HEALTH_POINTS);
        effect.setDescription("Eine langweilige Nahkampfattacke!");
        effect.setResultIsNegative(true);
        effect.setTypeUsedForCalculation(StatType.DEXTERITY);
        effect.setEffectTarget(SkillEffectTarget.TARGET);
        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(1.5f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("TAKING_DAMAGE");
        info.setTarget(SkillEffectTarget.TARGET);
        info.setEffectPath("CFX_Hit_A Red+RandomText");
        info.setWeaponType(WeaponType.MELEE1H);
  //      effect.addAnimInfo(info);
        skillEffectRepository.save(effect);

    }

    private void createSchadenStrEffekt() {
        SkillEffect effect = new StatSkillEffect();
        effect.setName("Waffen Schadenseffekt (Str)");
        effect.setIdentifier("dmg_target_str");
        effect.setApplyCalculationOnStat(StatType.HEALTH_POINTS);
        effect.setDescription("Eine langweilige Nahkampfattacke!");
        effect.setResultIsNegative(true);
        effect.setTypeUsedForCalculation(StatType.STRENGTH);
        effect.setEffectTarget(SkillEffectTarget.TARGET);

        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(1.5f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("TAKING_DAMAGE");
        info.setEffectPath("CFX_Hit_A Red+RandomText");

        info.setTarget(SkillEffectTarget.TARGET);
        info.setWeaponType(WeaponType.BOW);

    //    effect.addAnimInfo(info);
        skillEffectRepository.save(effect);


    }

    private void createSelfMoveEffect() {
        SelfMoveEffect effect = new SelfMoveEffect();
        effect.setName("Selbstbewegungseffekt!");
        effect.setIdentifier("mv_self");

        effect.setDescription("Deine Figure bewegt sich");
        effect.setResultIsNegative(false);
        effect.setTypeUsedForCalculation(StatType.ACTION_POINTS);
        effect.setApplyCalculationOnStat(StatType.NONE);
        effect.setEffectTarget(SkillEffectTarget.CASTER);
        /**   SkillAnimationInfo info = new SkillAnimationInfo();
         info.setDuration(3.0f);
         info.setSource(AnimationSource.SCRIPT);
         info.setName("SELF_MOVE_ANIMATION");
         info.setTarget(SkillEffectTarget.CASTER);
         effect.addAnimInfo(info);**/
        skillEffectRepository.save(effect);


    }


    private void createMoveEffect() {
        SkillEffect effect = new SkillEffect();
        effect.setName("Bewegungseffekt!");
        effect.setIdentifier("mv_target");
        effect.setDescription("Etwas bewegt sich");
        effect.setResultIsNegative(false);
        effect.setTypeUsedForCalculation(StatType.ACTION_POINTS);
        effect.setApplyCalculationOnStat(StatType.NONE);
        effect.setEffectTarget(SkillEffectTarget.TARGET);

        skillEffectRepository.save(effect);

    }


    private void createTimeReversalSkill() {
        TimeReversalSkillEffect reversalSkillEffect = new TimeReversalSkillEffect();
        reversalSkillEffect.setName("Einen Schritt zurück!");
        reversalSkillEffect.setIdentifier("rev_target_step");
        reversalSkillEffect.setDefinition(TimeReversakSkillEffectRoundDefinition.STEP);
        reversalSkillEffect.setCountOfSkillEffectToReverse(1);
        reversalSkillEffect.setTypeUsedForCalculation(StatType.NONE);
        reversalSkillEffect.setApplyCalculationOnStat(StatType.NONE);
        reversalSkillEffect.setEffectTarget(SkillEffectTarget.TARGET);
        skillEffectRepository.save(reversalSkillEffect);

    }


    private void createCompleteRoundSkillEffect() {
        TimeReversalSkillEffect timeReversalSkillEffect = new TimeReversalSkillEffect();
        timeReversalSkillEffect.setName("Runde zurücksetzen");
        timeReversalSkillEffect.setIdentifier("rev_target_round");

        timeReversalSkillEffect.setDefinition(TimeReversakSkillEffectRoundDefinition.COMPLETE_ROUND);
        timeReversalSkillEffect.setCountOfSkillEffectToReverse(1);
        timeReversalSkillEffect.setEffectTarget(SkillEffectTarget.TARGET);
        timeReversalSkillEffect.setApplyCalculationOnStat(StatType.NONE);
        timeReversalSkillEffect.setTypeUsedForCalculation(StatType.NONE);

        skillEffectRepository.save(timeReversalSkillEffect);

    }

    private void createResetAPSkillEffect() {
        StatSkillEffect skillEffect = new StatSkillEffect();
        skillEffect.setName("Reset AP");
        skillEffect.setIdentifier("reset_caster_ap");

        skillEffect.setDescription("Resets AP to max value");
        skillEffect.setApplyCalculationOnStat(StatType.ACTION_POINTS);
        skillEffect.setResultIsNegative(false);
        skillEffect.setEffectTarget(SkillEffectTarget.CASTER);
        skillEffect.setTypeUsedForCalculation(StatType.AGILITY);
        skillEffectRepository.save(skillEffect);
    }

    private void createResetHPSkillEffect() {
        StatSkillEffect skillEffect = new StatSkillEffect();
        skillEffect.setName("Reset HP");
        skillEffect.setIdentifier("reset_caster_hp");

        skillEffect.setDescription("Resets HP to max value");
        skillEffect.setApplyCalculationOnStat(StatType.ACTION_POINTS);
        skillEffect.setResultIsNegative(false);
        skillEffect.setEffectTarget(SkillEffectTarget.CASTER);
        skillEffect.setTypeUsedForCalculation(StatType.AGILITY);
        skillEffectRepository.save(skillEffect);
    }

    private void createSelfDamageEffect() {
        StatSkillEffect skillEffect = new StatSkillEffect();
        skillEffect.setName("Selbstschadenseffekt");
        skillEffect.setIdentifier("dmg_caster_hp");

        skillEffect.setDescription("Schadet einem selber");
        skillEffect.setApplyCalculationOnStat(StatType.HEALTH_POINTS);
        skillEffect.setResultIsNegative(true);
        skillEffect.setEffectTarget(SkillEffectTarget.CASTER);
        skillEffect.setTypeUsedForCalculation(StatType.STRENGTH);

        SkillAnimationInfo info = new SkillAnimationInfo();
        info.setDuration(1.5f);
        info.setSource(AnimationSource.ANIMATION_CONTROLLER);
        info.setName("TAKING_DAMAGE");
        info.setTarget(SkillEffectTarget.CASTER);
        info.setEffectPath("CFX_Hit_A Red+RandomText");

        info.setWeaponType(WeaponType.MELEE1H);
    //    skillEffect.addAnimInfo(info);
        skillEffectRepository.save(skillEffect);
    }


    private void createHealEffect() {
        StatSkillEffect skillEffect = new StatSkillEffect();
        skillEffect.setName("Heile (Eigene Enheit)");
        skillEffect.setIdentifier("heal_target_hp");

        skillEffect.setDescription("Heilt jemand");
        skillEffect.setApplyCalculationOnStat(StatType.HEALTH_POINTS);
        skillEffect.setResultIsNegative(false);
        skillEffect.setEffectTarget(SkillEffectTarget.TARGET);
        skillEffect.setTypeUsedForCalculation(StatType.INTELIGENCE);
        skillEffectRepository.save(skillEffect);
    }

}
