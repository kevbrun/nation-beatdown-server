package ch.nation.dbservice.dummyImporter.data.skills;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;
import ch.nation.core.model.Enums.TimeReversakSkillEffectRoundDefinition;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.skills.effects.SelfMoveEffect;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.skills.effects.StatSkillEffect;
import ch.nation.dbservice.entities.skills.effects.TimeReversalSkillEffect;
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

    private void createSkillEffects(){
        LOGGER.info("START MIGRATING SKILL EFFEFCTS");
    createSchadenDexEffekt();
    createSchadenStrEffekt();
   createSelfMoveEffect();
   createMoveEffect();
    createTimeReversalSkill();
        createCompleteRoundSkillEffect();


        LOGGER.info("START MIGRATING SKILL EFFEFCTS");
    }

    private void createSchadenDexEffekt() {
        SkillEffect effect;
        effect =  new StatSkillEffect();
        effect.setName("Schadenseffekt (Dex)");
        effect.setApplyCalculationOnStat(StatType.HEALTH_POINTS);
        effect.setDescription("Eine langweilige Nahkampfattacke!");
        effect.setResultIsNegative(true);
        effect.setTypeUsedForCalculation(StatType.DEXTERITY);
        effect.setEffectTarget(SkillEffectTarget.TARGET);

        skillEffectRepository.save(effect);

    }

    private void createSchadenStrEffekt() {
        SkillEffect effect = new StatSkillEffect();
        effect.setName("Schadenseffekt (Str)");
        effect.setApplyCalculationOnStat(StatType.HEALTH_POINTS);
        effect.setDescription("Eine langweilige Nahkampfattacke!");
        effect.setResultIsNegative(true);
        effect.setTypeUsedForCalculation(StatType.STRENGTH);
        effect.setEffectTarget(SkillEffectTarget.TARGET);

        skillEffectRepository.save(effect);



    }

    private void createSelfMoveEffect(){
        SelfMoveEffect effect =new SelfMoveEffect();
        effect.setName("Selbstbewegungseffekt!");
        effect.setDescription("Deine Figure bewegt sich");
        effect.setResultIsNegative(false);
        effect.setTypeUsedForCalculation(StatType.ACTION_POINTS);
        effect.setApplyCalculationOnStat(StatType.NONE);
        effect.setEffectTarget(SkillEffectTarget.CASTER);

        skillEffectRepository.save(effect);




    }

    private void createMoveEffect(){
        SkillEffect effect =new SkillEffect();
        effect.setName("Bewegungseffekt!");
        effect.setDescription("Etwas bewegt sich");
        effect.setResultIsNegative(false);
        effect.setTypeUsedForCalculation(StatType.ACTION_POINTS);
        effect.setApplyCalculationOnStat(StatType.NONE);
        effect.setEffectTarget(SkillEffectTarget.CASTER);

        skillEffectRepository.save(effect);

    }


    private void createTimeReversalSkill(){
        TimeReversalSkillEffect reversalSkillEffect = new TimeReversalSkillEffect();
        reversalSkillEffect.setName("Einen Schritt zurück!");
        reversalSkillEffect.setDefinition(TimeReversakSkillEffectRoundDefinition.STEP);
        reversalSkillEffect.setCountOfSkillEffectToReverse(1);
        reversalSkillEffect.setTypeUsedForCalculation(StatType.NONE);
        reversalSkillEffect.setApplyCalculationOnStat(StatType.NONE);
        reversalSkillEffect.setEffectTarget(SkillEffectTarget.TARGET);
        skillEffectRepository.save(reversalSkillEffect);

    }


    private void createCompleteRoundSkillEffect(){
        TimeReversalSkillEffect timeReversalSkillEffect = new TimeReversalSkillEffect();
        timeReversalSkillEffect.setName("Runde zurücksetzen");
        timeReversalSkillEffect.setDefinition(TimeReversakSkillEffectRoundDefinition.COMPLETE_ROUND);
        timeReversalSkillEffect.setCountOfSkillEffectToReverse(1);
        timeReversalSkillEffect.setEffectTarget(SkillEffectTarget.TARGET);
        timeReversalSkillEffect.setApplyCalculationOnStat(StatType.NONE);
        timeReversalSkillEffect.setTypeUsedForCalculation(StatType.NONE);

        skillEffectRepository.save(timeReversalSkillEffect);

    }

}
