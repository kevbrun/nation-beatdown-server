package ch.nation.core.model.Bonus;

import ch.nation.core.model.Enums.StatModTarget;

public class FloatBonus extends AbstractBonus<Float> {
    public FloatBonus(Float bonus, StatModTarget statTarget) {
        super(bonus, statTarget);
    }

    public FloatBonus() {
    }
}
