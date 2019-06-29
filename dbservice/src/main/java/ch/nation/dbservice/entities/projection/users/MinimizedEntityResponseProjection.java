package ch.nation.dbservice.entities.projection.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public interface MinimizedEntityResponseProjection {
    @JsonProperty("uuid")
    UUID getId();

    @JsonProperty("type")
    String getDiscriminatorValue();
}
