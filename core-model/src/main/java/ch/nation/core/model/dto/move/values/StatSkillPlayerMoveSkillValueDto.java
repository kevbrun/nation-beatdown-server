package ch.nation.core.model.dto.move.values;

import ch.nation.core.model.Enums.StatType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StatSkillPlayerMoveSkillValueDto extends BasePlayerMoveValueDto {


    @JsonProperty("applied_on_stat")
    private StatType appliedOn;

    @JsonProperty("value")
    private float value;

    public final static String TYPE_IDENTIFIER = "StatSkillPlayerMoveSkillValueDto";

    public StatSkillPlayerMoveSkillValueDto(String type) {
        super();
        this.setType(type);
    }

    public StatSkillPlayerMoveSkillValueDto() {
        super();
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    public StatType getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(StatType appliedOn) {
        this.appliedOn = appliedOn;
    }

    @Override
    public String toString() {
        return "StatSkillPlayerMoveSkillValueDto{" +
                "value=" + value +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatSkillPlayerMoveSkillValueDto)) return false;
        StatSkillPlayerMoveSkillValueDto that = (StatSkillPlayerMoveSkillValueDto) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
