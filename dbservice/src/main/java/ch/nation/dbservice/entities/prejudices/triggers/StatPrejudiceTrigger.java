package ch.nation.dbservice.entities.prejudices.triggers;


import ch.nation.core.model.Enums.ConditionComparer;
import ch.nation.core.model.Enums.StatType;
import ch.nation.dbservice.entities.prejudices.Prejudice;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "STAT_PREJUDICE_TRIGGER")
@DiscriminatorValue("STAT")
public class StatPrejudiceTrigger extends PrejudiceTrigger {

    @JsonProperty("threshold")
    @Column(name="threshold")
    private float threshold;

    @JsonProperty("stat")
    @Column(name="stat")
    @Enumerated(EnumType.STRING)
    private StatType statType;

    @JsonProperty("comp")
    @Column(name="comp")
    @Enumerated(EnumType.STRING)
    private ConditionComparer comparer;


    public StatPrejudiceTrigger() {
    }

    public StatPrejudiceTrigger(float threshold, StatType statType, ConditionComparer comparer) {
        this.threshold = threshold;
        this.statType = statType;
        this.comparer = comparer;
    }

    public StatPrejudiceTrigger(List<Prejudice> prejudices, float threshold, StatType statType, ConditionComparer comparer) {
        super(prejudices);
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
        return "StatPrejudiceTrigger{" +
                "threshold=" + threshold +
                ", statType=" + statType +
                ", comparer=" + comparer +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatPrejudiceTrigger)) return false;
        if (!super.equals(o)) return false;
        StatPrejudiceTrigger that = (StatPrejudiceTrigger) o;
        return Float.compare(that.threshold, threshold) == 0 &&
                statType == that.statType &&
                comparer == that.comparer;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), threshold, statType, comparer);
    }
}
