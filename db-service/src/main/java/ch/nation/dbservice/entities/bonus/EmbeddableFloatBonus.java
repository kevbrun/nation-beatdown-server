package ch.nation.dbservice.entities.bonus;

import ch.nation.core.model.Bonus.IBonus;
import ch.nation.core.model.Enums.StatModTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class EmbeddableFloatBonus implements IBonus<Float> {

    @JsonProperty("bonus")
    private Float bonus;

    @JsonProperty("stat_target")
    @Enumerated(EnumType.STRING)
    @Column(name = "stat_target")
    private StatModTarget statTarget;


    public EmbeddableFloatBonus(Float bonus, StatModTarget statTarget) {
        this.bonus = bonus;
        this.statTarget = statTarget;
    }

    public EmbeddableFloatBonus() {
        this.bonus = 0.0f;
        this.statTarget = StatModTarget.NONE;
    }

    @Override
    public Float getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    @Override
    public StatModTarget getStatTarget() {
        return statTarget;
    }

    @Override
    public void setStatTarget(StatModTarget statTarget) {
        this.statTarget = statTarget;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmbeddableFloatBonus)) return false;
        EmbeddableFloatBonus that = (EmbeddableFloatBonus) o;
        return Objects.equals(bonus, that.bonus) &&
                statTarget == that.statTarget;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bonus, statTarget);
    }
}
