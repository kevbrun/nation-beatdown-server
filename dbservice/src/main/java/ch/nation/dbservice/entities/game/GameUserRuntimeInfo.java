package ch.nation.dbservice.entities.game;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity(name="USER_RUNTIME_INFO")
@Table(name="USER_RUNTIME_INFO")
public class GameUserRuntimeInfo extends AbstractNationEntityBase {


    @JsonProperty("consideration_time")
    private long considerationTime;

    public GameUserRuntimeInfo() {
    }

    public GameUserRuntimeInfo(long considerationTime) {
        this.considerationTime = considerationTime;
    }

    public long getConsiderationTime() {
        return considerationTime;
    }

    public void setConsiderationTime(long considerationTime) {
        this.considerationTime = considerationTime;
    }
}
