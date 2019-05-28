package ch.nation.core.model.dto.prejudices;

import ch.nation.core.model.Enums.ConditionComparer;
import ch.nation.core.model.Enums.StatType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatPrejudiceTriggerDto extends AbstractPrejudiceTriggerDto {

    @JsonProperty("threshold")
    private float threshold;
    @JsonProperty("stat")
    private StatType statType;
    @JsonProperty("comp")
    private ConditionComparer comparer;


    public StatPrejudiceTriggerDto(float threshold, StatType statType, ConditionComparer comparer) {
        this.threshold = threshold;
        this.statType = statType;
        this.comparer = comparer;
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    public StatType getStatType() {
        return statType;
    }

    public void setStatType(StatType statType) {
        this.statType = statType;
    }

    public ConditionComparer getComparer() {
        return comparer;
    }

    public void setComparer(ConditionComparer comparer) {
        this.comparer = comparer;
    }

    @Override
    public String toString() {
        return "StatPrejudiceTriggerDto{" +
                "threshold=" + threshold +
                ", statType=" + statType +
                ", comparer=" + comparer +
                "} " + super.toString();
    }
}
