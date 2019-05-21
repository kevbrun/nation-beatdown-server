package ch.nation.core.model.Bonus;

import ch.nation.core.model.Enums.StatModTarget;

public class DoubleBonus extends AbstractBonus<Double>{
    public DoubleBonus(Double bonus, StatModTarget statTarget) {
        super(bonus, statTarget);
    }

    public DoubleBonus() {
    }
}
