package ch.nation.core.model.dto.prejudices;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.core.model.dto.characteristics.StatBonusDeltaDto;
import ch.nation.core.model.dto.prejudices.triggers.AbstractPrejudiceTriggerDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


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
