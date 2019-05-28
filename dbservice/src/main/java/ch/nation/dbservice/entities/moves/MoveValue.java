package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;

import javax.persistence.*;


@Entity(name="MOVE_VALUE")
@Table(name="MOVE_VALUE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACTION_TYPE",discriminatorType = DiscriminatorType.STRING)
public  class MoveValue extends AbstractNationEntityBase {




}
