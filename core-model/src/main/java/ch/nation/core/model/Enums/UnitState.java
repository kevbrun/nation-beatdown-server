package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum UnitState implements IEnumFromValue<UnitState> {
    IDLE("Idle"), INIT_OBJECT("InitObject"), IS_SELECTED("IsSelected"), Attack("Attack"), READY_FOR_MOVING("ReadyForMoving"),
    IS_MOVING("IsMoving"), TAKING_DAMAGE("TakingDamage"), DEAD("DEAD"), TURN_FINISHED("TurnFinished");

    private String str;

    UnitState(String str) {
        this.str = str;
    }

    @Override
    public UnitState fromValue(String value) {
        return EnumUtilties.getEnumFromString(UnitState.class, value);
    }

    @Override
    public String toJson() {
        return str;
    }
}
