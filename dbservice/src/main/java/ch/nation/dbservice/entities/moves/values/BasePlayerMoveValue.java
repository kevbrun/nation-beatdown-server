package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.values.deserializer.PlayerMoveValueDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity(name="PLAYER_MOVES_VALUES")
@Table(name="PLAYER_MOVES_VALUES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PLAYER_MOVE_VALUE_TYPE",discriminatorType = DiscriminatorType.STRING)
@Transactional
@DiscriminatorValue("BASE")
@JsonDeserialize(using = PlayerMoveValueDeserializer.class)
public class BasePlayerMoveValue extends AbstractNationEntityBase implements IDiscrimantorValue {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="move_id")
    @RestResource(path = "moves",rel = "moves")
    @JsonIgnore
    private BasePlayerMove move;

    public BasePlayerMoveValue() {
    }


    public BasePlayerMove getMove() {
        return move;
    }

    public void setMove(BasePlayerMove move) {
        this.move = move;
    }




}
