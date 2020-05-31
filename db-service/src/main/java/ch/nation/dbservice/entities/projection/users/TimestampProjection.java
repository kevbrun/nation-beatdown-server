package ch.nation.dbservice.entities.projection.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

public interface TimestampProjection extends MinimizedEntityResponseProjection {

    @JsonProperty("created")
    public Calendar getCreationTimestamp();

    @JsonProperty("updated")
    public Calendar getUpdateTimemstamp();

}
