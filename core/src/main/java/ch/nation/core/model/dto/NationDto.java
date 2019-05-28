package ch.nation.core.model.dto;

import java.io.Serializable;

public class NationDto extends AbstractNationDto implements Serializable {

    private UserDto user;


    public NationDto(UserDto user) {
        this.user = user;
    }

    public NationDto(){
        super();
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "NationDto{" +
                "user=" + user +
                "} " + super.toString();
    }
}

