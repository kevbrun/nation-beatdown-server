package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SkillPlayerMoveDto extends BasePlayerMoveDto
{
    @JsonProperty("effect_values")
    private List<AbstractMoveSkillEffectValueDto> effectValues;


    @JsonProperty("caster_skill_cost")
    private int skillCost;


    public SkillPlayerMoveDto() {
     super();
    }

    public List<AbstractMoveSkillEffectValueDto> getEffectValues() {
        return effectValues;
    }


    public void setEffectValues(List<AbstractMoveSkillEffectValueDto> effectValues) {
        this.effectValues = effectValues;
    }


    public int getSkillCost() {
        return skillCost;
    }


    public void setSkillCost(int skillCost) {
        this.skillCost = skillCost;
    }
}
