package ch.nation.dbservice.entities.Bonus;

import ch.nation.core.model.Bonus.IntegerBonus;
import ch.nation.core.model.Enums.StatModTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
public class EmbeddableIntegerBonus {
    @JsonProperty("bonus")
    private  Integer bonus;

    @JsonProperty("stat_target")
    @Enumerated(EnumType.STRING)
    @Column(name="stat_target")
    private StatModTarget statTarget;

    public EmbeddableIntegerBonus(Integer bonus, StatModTarget statTarget) {
        this.bonus = bonus;
        this.statTarget = statTarget;
    }

    public EmbeddableIntegerBonus() {
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public StatModTarget getStatTarget() {
        return statTarget;
    }

    public void setStatTarget(StatModTarget statTarget) {
        this.statTarget = statTarget;
    }
}
