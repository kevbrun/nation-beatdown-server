package ch.nation.core.model.dto.move.values;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatSkillPlayerMoveSkillValueDto extends AbstractMoveSkillEffectValueDto {

    @JsonProperty("value")
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
