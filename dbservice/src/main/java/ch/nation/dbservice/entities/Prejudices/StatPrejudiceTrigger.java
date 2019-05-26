package ch.nation.dbservice.entities.Prejudices;


import ch.nation.core.model.Enums.ConditionComparer;
import ch.nation.core.model.Enums.StatType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "STAT_PREJUDICE_TRIGGER")
@DiscriminatorValue("STAT")
public class StatPrejudiceTrigger extends PrejudiceTrigger {

    @JsonProperty("threshold")
    @Column(name="threshold")
    private float threshold;

    @JsonProperty("stat")
    @Column(name="stat")
    private StatType statType;

    @JsonProperty("comp")
    @Column(name="comp")
    private ConditionComparer comparer;


    public StatPrejudiceTrigger() {
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
        return "StatPrejudiceTrigger{" +
                "threshold=" + threshold +
                ", statType=" + statType +
                ", comparer=" + comparer +
                "} " + super.toString();
    }
}
