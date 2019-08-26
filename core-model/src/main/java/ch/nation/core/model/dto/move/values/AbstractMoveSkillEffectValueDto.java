package ch.nation.core.model.dto.move.values;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.unit.UnitDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public abstract class AbstractMoveSkillEffectValueDto extends AbstractDto {

    @JsonProperty("target")
    private UnitDto target;

    @JsonProperty("skill_effect")
    private SkillEffectDto effectDto;

    public UnitDto getTarget() {
        return target;
    }

    public void setTarget(UnitDto target) {
        this.target = target;
    }

    public SkillEffectDto getEffectDto() {
        return effectDto;
    }

    public void setEffectDto(SkillEffectDto effectDto) {
        this.effectDto = effectDto;
    }

    @Override
    public String ResourceCollectionName() {
        return "values";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractMoveSkillEffectValueDto)) return false;
        AbstractMoveSkillEffectValueDto that = (AbstractMoveSkillEffectValueDto) o;
        return Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target);
    }
}
