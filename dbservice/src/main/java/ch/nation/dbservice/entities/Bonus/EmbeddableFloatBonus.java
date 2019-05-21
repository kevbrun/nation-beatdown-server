package ch.nation.dbservice.entities.Bonus;

import ch.nation.core.model.Bonus.FloatBonus;
import ch.nation.core.model.Enums.StatModTarget;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddableFloatBonus extends FloatBonus {
    public EmbeddableFloatBonus(Float bonus, StatModTarget statTarget) {
        super(bonus, statTarget);
    }

    public EmbeddableFloatBonus() {
    }
}
