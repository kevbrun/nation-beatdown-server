package ch.nation.dbservice.entities.Bonus;

import ch.nation.core.model.Bonus.FloatBonus;
import ch.nation.core.model.Bonus.IBonus;
import ch.nation.core.model.Enums.StatModTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class EmbeddableFloatBonus implements IBonus<Float> {

    @JsonProperty("bonus")
    private Float bonus;

    @JsonProperty("stat_target")
    @Enumerated(EnumType.STRING)
    @Column(name="stat_target")
    private StatModTarget statTarget;


    public EmbeddableFloatBonus() {
    }

    @Override
    public Float getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(Float bonus) {
        this.bonus =bonus;
    }

    @Override
    public StatModTarget getStatTarget() {
        return statTarget;
    }

    @Override
    public void setStatTarget(StatModTarget statTarget) {
        this.statTarget = statTarget;
    }
}
