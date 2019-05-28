package ch.nation.dbservice.projection.components;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface IDescriptionProjection {

    @JsonProperty("desc")
    String getDescription();


}
