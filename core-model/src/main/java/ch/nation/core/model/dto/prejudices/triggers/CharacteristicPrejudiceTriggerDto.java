package ch.nation.core.model.dto.prejudices.triggers;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharacteristicPrejudiceTriggerDto extends AbstractPrejudiceTriggerDto {


    @JsonProperty("characteristics")
    private List<AbstractCharacteristicsDto> characteristics;


    public CharacteristicPrejudiceTriggerDto() {
    }


    public List<AbstractCharacteristicsDto> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<AbstractCharacteristicsDto> characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "CharacteristicPrejudiceTriggerDto{" +
                "characteristics=" + characteristics +
                "} " + super.toString();
    }


}
