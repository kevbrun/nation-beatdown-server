package ch.nation.dbservice.entities.Clazzes;

import ch.nation.dbservice.entities.Enums.StatGrowthType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Stat {


        @Column(name="base")
        @JsonProperty("base")
        private float baseValue;

        @Column(name="min")
        @JsonProperty("min")
        private float minValue;

        @Column(name="max")
        @JsonProperty("max")
        private float maxValue;
        @Enumerated(EnumType.STRING)
        @JsonProperty("growthType")
        private StatGrowthType growthType;



    public Stat() {
    }


    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
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
        return "Stat{" +
                "baseValue=" + baseValue +
                ", maxValue=" + maxValue +
                ", growthType=" + growthType +
                '}';
    }
}
