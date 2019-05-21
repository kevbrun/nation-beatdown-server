package ch.nation.core.model.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public interface IEnumFromValue<T> {


    @JsonCreator
    public  T fromValue(String value);

    @JsonValue
    public String toJson();

}
