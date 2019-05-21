package ch.nation.dbservice.entities.Bonus;

import ch.nation.core.model.Bonus.IntegerBonus;
import ch.nation.core.model.Enums.StatModTarget;

import javax.persistence.Embeddable;


@Embeddable
public class EmbeddableIntegerBonus extends IntegerBonus {
    public EmbeddableIntegerBonus(Integer bonus, StatModTarget statTarget) {
        super(bonus, statTarget);
    }
}
