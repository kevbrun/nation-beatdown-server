package ch.nation.core.model.dto.user;

import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class NationDto extends NamedObjectAbstractDto implements Serializable {


    @JsonProperty("user")
    private UserDto user;


    @JsonProperty("characteristics")
    private List<AbstractCharacteristicsDto> characteristics;


  /**  @JsonProperty("prejudices")
    private List<AbstractPrejudiceDto> prejudices;**/


    public NationDto(UserDto user) {
        this.user = user;
    }

    public NationDto() {
        super();
    }

    @Override
    public String ResourceCollectionName() {
        return "nations";
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    public List<AbstractCharacteristicsDto> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<AbstractCharacteristicsDto> characteristics) {
        this.characteristics = characteristics;
    }

 /**   public List<AbstractPrejudiceDto> getPrejudices() {
        return prejudices;
    }

    public void setPrejudices(List<AbstractPrejudiceDto> prejudices) {
        this.prejudices = prejudices;
    }**/

    @Override
    public String toString() {
        return "Dto{" +
                "user=" + user +
                "} " + super.toString();
    }
}

