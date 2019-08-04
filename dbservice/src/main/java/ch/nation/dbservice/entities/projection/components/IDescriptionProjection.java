package ch.nation.dbservice.entities.projection.components;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface IDescriptionProjection {

    @JsonProperty("desc")
    String getDescription();


}
