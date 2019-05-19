package ch.nation.dbservice.entities.Clazzes;

import ch.nation.dbservice.entities.enums.StatGrowthType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Stat {


        @Column(name="base")
        private float baseValue;

        @Column(name="max")
        private float maxValue;
        @Enumerated(EnumType.STRING)
        private StatGrowthType growthType;


    public Stat(float baseValue, float maxValue, StatGrowthType growthType) {
        this.baseValue = baseValue;
        this.maxValue = maxValue;
        this.growthType = growthType;
    }

    public Stat() {
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
