package ch.nation.dbservice.entities.Units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.core.model.position.Vector3Float;
import ch.nation.core.model.position.Vector3Int;
import ch.nation.core.model.position.Vector3Number;
import ch.nation.dbservice.converter.VectorStringConverter;
import ch.nation.dbservice.entities.Clazzes.CharacterClass;
import ch.nation.dbservice.entities.NationEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Table(name="UNITS")
@Entity(name="UNITS")
public class Unit extends NationEntityBase {



    @JsonProperty("class")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clazz_id")
    private CharacterClass characterClass;

    @JsonProperty("state")
    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private UnitState state;

    @JsonProperty("dead")
    @Column(name="is_dead")
    private boolean isDead;

   // @Column(name="position")
    @JsonProperty("pos")
    @Embedded
    private EmeddableVector3 position;

    @Embedded
    @JsonProperty("assets")
    private GraphicalRepresentation graphicalRepresentation;


    public Unit() {
    }


    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public UnitState getState() {
        return state;
    }

    public void setState(UnitState state) {
        this.state = state;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }


    public EmeddableVector3 getPosition() {
        return position;
    }

    public void setPosition(EmeddableVector3 position) {
        this.position = position;
    }

    public GraphicalRepresentation getGraphicalRepresentation() {
        return graphicalRepresentation;
    }

    public void setGraphicalRepresentation(GraphicalRepresentation graphicalRepresentation) {
        this.graphicalRepresentation = graphicalRepresentation;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "characterClass=" + characterClass +
                ", state=" + state +
                ", isDead=" + isDead +
                ", position=" + position +
                ", graphicalRepresentation=" + graphicalRepresentation +
                "} " + super.toString();
    }
}
