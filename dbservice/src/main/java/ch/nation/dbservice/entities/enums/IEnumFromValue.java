package ch.nation.dbservice.entities.enums;

import ch.nation.dbservice.utils.EnumUtilties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public interface IEnumFromValue<T> {


    @JsonCreator
    public  T fromValue(String value);

    @JsonValue
    public String toJson();

}
