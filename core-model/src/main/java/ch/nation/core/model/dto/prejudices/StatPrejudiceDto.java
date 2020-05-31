package ch.nation.core.model.dto.prejudices;

import ch.nation.core.model.dto.characteristics.StatBonusDeltaDto;
import com.fasterxml.jackson.annotation.JsonProperty;


public class StatPrejudiceDto extends BasePrejudiceDto {


    @JsonProperty("delta")
    private StatBonusDeltaDto deltaDto;


    public StatPrejudiceDto() {
        super();

    }

    public StatBonusDeltaDto getDeltaDto() {
        return deltaDto;
    }

    public void setDeltaDto(StatBonusDeltaDto deltaDto) {
        this.deltaDto = deltaDto;
    }


    @Override
    public String toString() {
        return "StatPrejudiceDto{" +
                ", deltaDto=" + deltaDto +
                '}';
    }
}
