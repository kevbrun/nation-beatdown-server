package ch.nation.dbservice.utils;

import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.StatType;

public final class IdentifierBuilderHelper {

    public static String buildIdentifier(final String shortname, final SkillEffectTarget target, final StatType stat) {
        return String.format("%s_%s_%s", shortname.toUpperCase(), target.toString(), stat.toString());
    }


}
