package ch.nation.dbservice.entities.clazzes;

import ch.nation.core.model.Enums.StatGrowthType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

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
       super();
    }


    public Stat(float baseValue, float minValue, float maxValue, StatGrowthType growthType) {
        this.baseValue = baseValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.growthType = growthType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stat)) return false;
        Stat stat = (Stat) o;
        return Float.compare(stat.baseValue, baseValue) == 0 &&
                Float.compare(stat.minValue, minValue) == 0 &&
                Float.compare(stat.maxValue, maxValue) == 0 &&
                growthType == stat.growthType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseValue, minValue, maxValue, growthType);
    }
}
