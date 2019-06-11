package ch.nation.core.model.dto.user;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class NationDto extends AbstractDto implements Serializable {


    @JsonProperty("user")
    private UserDto user;


    public NationDto(UserDto user) {
        this.user = user;
    }

    public NationDto(){
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


    @Override
    public String toString() {
        return "Dto{" +
                "user=" + user +
                "} " + super.toString();
    }
}

