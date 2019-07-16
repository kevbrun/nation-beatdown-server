package ch.nation.dbservice.entities.skills.effects;


import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="STAT_SKILL_EFFECT")
@DiscriminatorValue("STAT_SKILL_EFFECT")
public class StatSkillEffect extends SkillEffect implements IDiscrimantorValue {
}
