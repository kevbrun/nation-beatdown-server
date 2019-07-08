package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.values.deserializer.PlayerMoveValueDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity(name="PLAYER_MOVES_VALUES")
@Table(name="PLAYER_MOVES_VALUES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PLAYER_MOVE_VALUE_TYPE",discriminatorType = DiscriminatorType.STRING)
@Transactional
@JsonDeserialize(using = PlayerMoveValueDeserializer.class)
public abstract class AbstractBasePlayerMoveValue extends AbstractNationEntityBase implements IDiscrimantorValue {


    public AbstractBasePlayerMoveValue() {
    }
}
