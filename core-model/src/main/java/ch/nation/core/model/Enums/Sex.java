package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum Sex implements IEnumFromValue<Sex> {
    MALE("Male"),FEMALE("Female"),NO_GENDER("No_Gender");
    private String gender;


    Sex(String gender) {
        this.gender = gender;
    }


    @Override
    public Sex fromValue(String value) {
        return EnumUtilties.getEnumFromString(Sex.class,value);
    }

    @Override
    public String toJson() {
        return gender;
    }
}
