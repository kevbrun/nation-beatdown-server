package ch.nation.dbservice.entities.skills.effects;

import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="SELF_MOVE_SKILL_EFFECTS")
@DiscriminatorValue("SELF_MOVE_EFFECT")
public class SelfMoveEffect extends SkillEffect implements  IDiscrimantorValue{
}
