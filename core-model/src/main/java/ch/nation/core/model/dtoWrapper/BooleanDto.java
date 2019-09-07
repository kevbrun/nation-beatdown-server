package ch.nation.core.model.dtoWrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BooleanDto implements Serializable {


    @JsonProperty("boolean_answer")
    private boolean value;



    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
