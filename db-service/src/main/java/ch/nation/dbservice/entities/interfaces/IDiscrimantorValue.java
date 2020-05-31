package ch.nation.dbservice.entities.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;

public interface IDiscrimantorValue {

    @Transient
    @JsonProperty("type")
    public default String getDiscriminatorValue() {
        String val = this.getClass().getSimpleName();
        return val;


    }
}
