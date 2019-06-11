package ch.nation.dbservice.projection.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.UUID;

public interface AbstractEntityProjection {

    @JsonProperty("uuid")
    public UUID getId();
    @JsonProperty("created")
    public Calendar getCreationTimestamp();
    @JsonProperty("updated")
    public Calendar getUpdateTimemstamp();
    @JsonProperty("type")
    public String getDiscriminatorValue();
}
