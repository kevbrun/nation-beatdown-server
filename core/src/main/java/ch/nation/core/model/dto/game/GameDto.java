package ch.nation.core.model.dto.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class GameDto extends NamedObjectAbstractDto {

    @JsonProperty("users")
    private List<UserDto> users;

    @JsonProperty("round")
    private int round;

    @JsonProperty("status")
    private GameStatus status;


    public GameDto() {
        super();
        users = new ArrayList<>();
        round = 1;
        status = GameStatus.NONE;
    }

    @Override
    public String ResourceCollectionName() {
        return "games";
    }


    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public void addUser(UserDto userDto){
        if(users==null) users = new ArrayList<>();
        if(!users.contains(userDto)) users.add(userDto);
    }

    public void removeUser(UserDto userDto){
        if(users!=null && users.contains(userDto)){

            users.remove(userDto);


        }
    }


    @Override
    public String toString() {
        return "GameDto{" +
                "users=" + users +
                ", round=" + round +
                ", status=" + status +
                ", id='" + id + '\'' +
                "} " + super.toString();
    }
}
