package ch.nation.dbservice.entities.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.game.PlayerMoveAction;
import ch.nation.dbservice.entities.NationEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;


@Table(name="UNITS")
@Entity(name="UNITS")
public class Unit extends NationEntityBase {



    @JsonProperty("class")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clazz_id")
    @RestResource(path = "classes", rel="classes")
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
    @RestResource(path = "assets", rel="assets")
    private GraphicalRepresentation graphicalRepresentation;


    @OneToMany(
            mappedBy = "caster",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayerMoveAction> source;

    @OneToMany(
            mappedBy = "target",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayerMoveAction> target;

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

    public List<PlayerMoveAction> getSource() {
        return source;
    }

    public void setSource(List<PlayerMoveAction> source) {
        this.source = source;
    }

    public List<PlayerMoveAction> getTarget() {
        return target;
    }

    public void setTarget(List<PlayerMoveAction> target) {
        this.target = target;
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
