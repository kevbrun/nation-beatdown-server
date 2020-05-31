package ch.nation.core.model.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserStatisticsDto implements Serializable {

    @JsonProperty("lost")
    private long countOfLostGames;
    @JsonProperty("won")
    private long countOfWonGames;
    @JsonProperty("run")
    private long countOfRunningGames;


    public UserStatisticsDto() {
        countOfLostGames = 0;
        countOfWonGames = 0;
        countOfRunningGames = 0;
    }

    public long getCountOfLostGames() {
        return countOfLostGames;
    }

    public void setCountOfLostGames(long countOfLostGames) {
        this.countOfLostGames = countOfLostGames;
    }

    public long getCountOfWonGames() {
        return countOfWonGames;
    }

    public void setCountOfWonGames(long countOfWonGames) {
        this.countOfWonGames = countOfWonGames;
    }

    public long getCountOfRunningGames() {
        return countOfRunningGames;
    }

    public void setCountOfRunningGames(long countOfRunningGames) {
        this.countOfRunningGames = countOfRunningGames;
    }

    @Override
    public String toString() {
        return "UserStatisticsDto{" +
                "countOfLostGames=" + countOfLostGames +
                ", countOfWonGames=" + countOfWonGames +
                ", countOfRunningGames=" + countOfRunningGames +
                '}';
    }
}
