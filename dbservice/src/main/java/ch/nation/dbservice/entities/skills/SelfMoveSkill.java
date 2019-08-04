package ch.nation.dbservice.entities.skills;

import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="SELF_MOVE_SKILL")
@DiscriminatorValue("SELF_MOVE_SKILL")
public class SelfMoveSkill extends Skill implements IDiscrimantorValue {
}
