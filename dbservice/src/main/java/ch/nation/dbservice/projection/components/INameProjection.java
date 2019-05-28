package ch.nation.dbservice.projection.components;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface INameProjection {

    @JsonProperty("name")
    String getName();

}
