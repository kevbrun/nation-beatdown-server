package ch.nation.core.model.dto.game;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameUserRuntimeInfoDto extends AbstractDto {


    @JsonProperty("consideration_time")
    private long considerationTime;




    public GameUserRuntimeInfoDto(long considerationTime) {
        this.considerationTime = considerationTime;
    }

    public long getConsiderationTime() {
        return considerationTime;
    }

    public void setConsiderationTime(long considerationTime) {
        this.considerationTime = considerationTime;
    }

    @Override
    public String ResourceCollectionName() {
        return "";
    }
}
