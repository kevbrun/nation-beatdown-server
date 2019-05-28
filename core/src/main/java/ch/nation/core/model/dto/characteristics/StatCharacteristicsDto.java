package ch.nation.core.model.dto.characteristics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatCharacteristicsDto extends AbstractCharacteristicsDto {


    @JsonProperty("delta")
    private StatBonusDeltaDto delta;


    public StatCharacteristicsDto(StatBonusDeltaDto delta) {
        this.delta = delta;

    }

    public StatCharacteristicsDto() {
    }

    public StatBonusDeltaDto getDelta() {
        return delta;
    }

    public void setDelta(StatBonusDeltaDto delta) {
        this.delta = delta;
    }

    @Override
    public String toString() {
        return "StatCharacteristicsDto{" +
                "delta=" + delta +
                "} " + super.toString();
    }
}
