package ch.nation.dbservice.projection.components;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public interface IUuidProjection {

    @JsonProperty("uuid")
    public UUID getId();
}
