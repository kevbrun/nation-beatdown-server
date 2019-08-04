package ch.nation.core.model.dto.game;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.catalina.User;
import org.springframework.data.rest.core.annotation.RestResource;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GameDto extends NamedObjectAbstractDto {

    @JsonProperty("users")
    private List<UserDto> users;

    @JsonProperty("round")
    private int round;

    @JsonProperty("status")
    private GameStatus status;

    @JsonProperty("current_player")
    private String currentPlayerUuid;

    @JsonProperty("first_player")
    private String firstPlayerUuid;

    @JsonProperty("next_player")
    private String nextPlayerUuid;

    @JsonProperty("runtimes")
    private List<GameUserRuntimeInfoDto> userGameUserRuntimeInfo;

    @JsonProperty("winner_player")
    private String winner;

    public GameDto() {
        super();
        users = new ArrayList<>();
        userGameUserRuntimeInfo = new ArrayList<>();
        round = 1;
        status = GameStatus.None;
    }

    @Override
    public String ResourceCollectionName() {
        return "games";
    }


    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
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


    public List<GameUserRuntimeInfoDto> getUserGameUserRuntimeInfo() {
        return userGameUserRuntimeInfo;
    }

    public void setUserGameUserRuntimeInfo(List<GameUserRuntimeInfoDto> userGameUserRuntimeInfo) {
        this.userGameUserRuntimeInfo = userGameUserRuntimeInfo;
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

    public String getCurrentPlayerUuid() {
        return currentPlayerUuid;
    }

    public void setCurrentPlayerUuid(String currentPlayerUuid) {
        this.currentPlayerUuid = currentPlayerUuid;
    }

    public String getFirstPlayerUuid() {
        return firstPlayerUuid;
    }

    public void setFirstPlayerUuid(String firstPlayerUuid) {
        this.firstPlayerUuid = firstPlayerUuid;
    }

    public String getNextPlayerUuid() {
        return nextPlayerUuid;
    }

    public void setNextPlayerUuid(String nextPlayerUuid) {
        this.nextPlayerUuid = nextPlayerUuid;
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "users=" + users +
                ", round=" + round +
                ", status=" + status +
                ", currentPlayerUuid='" + currentPlayerUuid + '\'' +
                ", firstPlayerUuid='" + firstPlayerUuid + '\'' +
                ", nextPlayerUuid='" + nextPlayerUuid + '\'' +
                "} " + super.toString();
    }
}
