package ch.nation.core.model.dto.move.values;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StatSkillPlayerMoveSkillValueDto extends BasePlayerMoveValueDto {

    @JsonProperty("value")
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
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
