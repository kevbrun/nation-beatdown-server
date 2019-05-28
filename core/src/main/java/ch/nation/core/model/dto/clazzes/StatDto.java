package ch.nation.core.model.dto.clazzes;

import ch.nation.core.model.Enums.StatGrowthType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatDto {


    @JsonProperty("base")
    private float baseValue;


    @JsonProperty("min")
    private float minValue;

    @JsonProperty("max")
    private float maxValue;

    @JsonProperty("growthType")
    private StatGrowthType growthType;


    public StatDto(float baseValue, float minValue, float maxValue, StatGrowthType growthType) {
        this.baseValue = baseValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.growthType = growthType;
    }

    public StatDto() {
    }

    public float getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public StatGrowthType getGrowthType() {
        return growthType;
    }

    public void setGrowthType(StatGrowthType growthType) {
        this.growthType = growthType;
    }

    @Override
    public String toString() {
        return "StatDto{" +
                "baseValue=" + baseValue +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", growthType=" + growthType +
                '}';
    }
}
