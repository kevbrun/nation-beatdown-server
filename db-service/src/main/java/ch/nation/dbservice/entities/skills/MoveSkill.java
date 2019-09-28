package ch.nation.dbservice.entities.skills;


import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="MOVE_SKILL")
@DiscriminatorValue("MOVE_SKILL")
public class MoveSkill extends Skill implements IDiscrimantorValue {
}
