package ch.nation.dbservice.entities.projection.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface NamedClassesProjection {
    @JsonProperty("desc")
    public String getDescription();

    @JsonProperty("name")
    public String getName();


}
