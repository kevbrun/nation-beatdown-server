package ch.nation.dbservice.entities.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.moves.PlayerMoveAction;
import ch.nation.dbservice.entities.NamedEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table(name="UNITS")
@Entity(name="UNITS")
public class Unit extends NamedEntityBase {



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
    private UnitAssets unitAssets;


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
        super();


    }

    public Unit(String name, String description, CharacterClass characterClass, UnitState state, boolean isDead, EmeddableVector3 position, UnitAssets unitAssets, List<PlayerMoveAction> source, List<PlayerMoveAction> target) {
        super(name, description);
        this.characterClass = characterClass;
        this.state = state;
        this.isDead = isDead;
        this.position = position;
        this.unitAssets = unitAssets;
        this.source = source;
        this.target = target;
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

        if(position==null) position = new EmeddableVector3();
        return position;
    }

    public void setPosition(EmeddableVector3 position) {
        this.position = position;
    }

    public UnitAssets getUnitAssets() {
        if(unitAssets==null)unitAssets = new UnitAssets();
        return unitAssets;
    }

    public void setUnitAssets(UnitAssets unitAssets) {
        this.unitAssets = unitAssets;
    }

    public List<PlayerMoveAction> getSource() {

        if(source==null) source = new ArrayList<>();

        return source;
    }

    public void setSource(List<PlayerMoveAction> source) {
        this.source = source;
    }

    public List<PlayerMoveAction> getTarget() {

        if(target==null) target = new ArrayList<>();
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
                ", unitAssets=" + unitAssets +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        if (!super.equals(o)) return false;
        Unit unit = (Unit) o;
        return isDead == unit.isDead &&
                Objects.equals(characterClass, unit.characterClass) &&
                state == unit.state &&
                Objects.equals(position, unit.position) &&
                Objects.equals(unitAssets, unit.unitAssets) &&
                Objects.equals(source, unit.source) &&
                Objects.equals(target, unit.target);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), characterClass, state, isDead, position, unitAssets, source, target);
    }
}
