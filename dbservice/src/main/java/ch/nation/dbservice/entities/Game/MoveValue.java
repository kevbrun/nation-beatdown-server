package ch.nation.dbservice.entities.Game;

import ch.nation.core.model.AbstractNationModelBase;
import ch.nation.dbservice.entities.AbstractNationEntityBase;

import javax.persistence.*;


@Entity(name="MOVE_VALUE")
@Table(name="MOVE_VALUE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACTION_TYPE",discriminatorType = DiscriminatorType.STRING)
public  class MoveValue extends AbstractNationEntityBase {




}
