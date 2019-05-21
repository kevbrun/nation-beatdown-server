package ch.nation.core.model.Bonus;

import ch.nation.core.model.Enums.StatModTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;



public abstract class AbstractBonus<T> implements Serializable {

    @JsonProperty("bonus")
    private  T bonus;

    @JsonProperty("stat_target")
    private StatModTarget statTarget;


    public AbstractBonus(T bonus, StatModTarget statTarget) {
        this.bonus = bonus;
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
