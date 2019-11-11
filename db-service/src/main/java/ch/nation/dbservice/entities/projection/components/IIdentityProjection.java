package ch.nation.dbservice.entities.projection.components;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface IIdentityProjection {

    @JsonProperty("ident")
    public String getIdentifier();

}
