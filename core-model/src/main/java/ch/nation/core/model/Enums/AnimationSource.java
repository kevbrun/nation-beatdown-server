package ch.nation.core.model.Enums;

import ch.nation.core.utils.EnumUtilties;

public enum AnimationSource implements IEnumFromValue<AnimationSource> {
    NONE("None"), ANIMATION_CONTROLLER("Animation_Controller"), FX("FX"), SCRIPT("Script");


    private String str;

    AnimationSource(String source) {
        this.str = source;
    }


    @Override
    public AnimationSource fromValue(String value) {
        return EnumUtilties.getEnumFromString(AnimationSource.class, value);
    }

    @Override
    public String toJson() {
        return str;
    }
}
