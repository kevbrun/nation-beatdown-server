package ch.nation.core.model.Bonus;

import ch.nation.core.model.Enums.StatModTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public abstract class AbstractBonus<T> implements Serializable, IBonus<T> {

    @JsonProperty("bonus")
    private T bonus;

    @JsonProperty("stat_target")
    private StatModTarget statTarget;


    public AbstractBonus(T bonus, StatModTarget statTarget) {
        this.bonus = bonus;
        this.statTarget = statTarget;
    }

    public AbstractBonus() {
    }

    public T getBonus() {
        return bonus;
    }

    public void setBonus(T bonus) {
        this.bonus = bonus;
    }

    public StatModTarget getStatTarget() {
        return statTarget;
    }

    public void setStatTarget(StatModTarget statTarget) {
        this.statTarget = statTarget;
    }

    @Override
    public String toString() {
        return "AbstractBonus{" +
                "bonus=" + bonus +
                ", statTarget=" + statTarget +
                '}';
    }
}
