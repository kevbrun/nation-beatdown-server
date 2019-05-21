package ch.nation.core.model.Bonus;

import ch.nation.core.model.Enums.StatModTarget;

public class IntegerBonus extends AbstractBonus<Integer>{

    public IntegerBonus(Integer bonus, StatModTarget statTarget) {
        super(bonus, statTarget);
    }
}
