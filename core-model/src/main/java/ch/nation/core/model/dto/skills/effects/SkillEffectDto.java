package ch.nation.core.model.dto.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;

public class SkillEffectDto extends AbstractSkillEffectDto {


    public SkillEffectDto(SkillEffectTarget effectTarget, StatType typeUsedForCalculation, StatType applyCalculationOnStat, boolean resultIsNegative) {
        super(effectTarget, typeUsedForCalculation, applyCalculationOnStat, resultIsNegative);
    }

    public SkillEffectDto() {
    }
}
