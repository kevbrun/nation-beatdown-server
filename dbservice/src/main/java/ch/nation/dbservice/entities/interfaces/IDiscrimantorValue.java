package ch.nation.dbservice.entities.interfaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Transient;

public interface IDiscrimantorValue {

    @Transient
    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public default String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

        return val == null ? null : val.value();
    }
}
