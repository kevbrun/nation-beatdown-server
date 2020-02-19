package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum GameStatus implements IEnumFromValue<GameStatus> {
    None("None"), InProgress("InProgress"), WaitingForPlayer("WaitingForPlayer"), Finished("Finished");

    private String str;

    GameStatus(String str) {
        this.str = str;
    }

    @Override
    public GameStatus fromValue(String value) {
        return EnumUtilties.getEnumFromString(GameStatus.class, value);
    }

    @Override
    public String toJson() {
        return str;
    }
}
