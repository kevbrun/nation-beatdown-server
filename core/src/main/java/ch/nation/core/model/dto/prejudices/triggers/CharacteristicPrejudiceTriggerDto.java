package ch.nation.core.model.dto.prejudices.triggers;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;

import java.util.List;

public class CharacteristicPrejudiceTriggerDto extends AbstractDto {

    private List<AbstractCharacteristicsDto> characteristics;


    public CharacteristicPrejudiceTriggerDto() {
    }

    public CharacteristicPrejudiceTriggerDto(List<AbstractCharacteristicsDto> characteristics) {
        this.characteristics = characteristics;
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


    @Override
    public String ResourceCollectionName() {
        return "prejudices";
    }
}
