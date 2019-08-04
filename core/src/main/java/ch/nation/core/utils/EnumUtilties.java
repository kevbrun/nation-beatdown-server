package ch.nation.core.utils;

public class EnumUtilties {

    public static <T extends Enum<T>> T getEnumFromString(Class<T> enumClass,String value){

        if(enumClass==null) throw new IllegalArgumentException("Enum class cannot be null");

        for(Enum<?> enumValue : enumClass.getEnumConstants()){
            if(enumValue.toString().equalsIgnoreCase(value)){
                return (T) enumValue;
            }
        }

        //Create Error Message

        StringBuilder errorMessage = new StringBuilder();
        boolean firstTime= true;

        for(Enum<?> enumValue : enumClass.getEnumConstants()){
            errorMessage.append(firstTime ? "":",")
                    .append(enumValue);
            firstTime = false;
        }
        throw new IllegalArgumentException(value+ "is not a valid enum. Supported are "+errorMessage);


    }


}
