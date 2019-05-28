package ch.nation.core.model.dto.move;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatMoveValueDtoDto extends AbstractMoveValueDto {

    @JsonProperty("value")
    private float value;


    public StatMoveValueDtoDto(float value) {
        this.value = value;
    }

    public StatMoveValueDtoDto() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StatMoveValueDtoDto{" +
                "value=" + value +
                "} " + super.toString();
    }
}
