package ch.nation.dbservice.entities.enums;

public enum StatGrowthType {
    NONE("None"),LINEAR("Linear"),LOGARITHMIC("Logarithmic"),EXPONENTIAL("Exponential");

     private String type;

    StatGrowthType(String type) {
        this.type = type;
    }
}
