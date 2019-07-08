package ch.nation.dbservice.entities.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.user.User;
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
    @RestResource(path = "classes", rel="classes",exported = false)
    private CharacterClass characterClass;

    @JsonProperty("state")
    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private UnitState state = UnitState.INIT_OBJECT;

    @JsonProperty("dead")
    @Column(name="is_dead")
    private boolean UnitIsDead = false;

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
    private List<BasePlayerMove> source = new ArrayList<>();

    @OneToMany(
            mappedBy = "target",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BasePlayerMove> target = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public Unit() {
        super();


    }

    public Unit(String name, String description, CharacterClass characterClass, UnitState state, boolean isUnitDead, EmeddableVector3 position, UnitAssets unitAssets, List<BasePlayerMove> source, List<BasePlayerMove> target) {
        super(name, description);
        this.characterClass = characterClass;
        this.state = state;
        this.UnitIsDead = isUnitDead;
        this.position = position;
        this.unitAssets = unitAssets;
        this.source = source;
        this.target = target;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isUnitIsDead() {
        return UnitIsDead;
    }

    public void setUnitIsDead(boolean unitIsDead) {
        UnitIsDead = unitIsDead;
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

    public List<BasePlayerMove> getSource() {

        if(source==null) source = new ArrayList<>();

        return source;
    }

    public void setSource(List<BasePlayerMove> source) {
        this.source = source;
    }

    public List<BasePlayerMove> getTarget() {

        if(target==null) target = new ArrayList<>();
        return target;
    }

    public void setTarget(List<BasePlayerMove> target) {
        this.target = target;
    }



    @Override
    public String toString() {
        return "Unit{" +
                "characterClass=" + characterClass +
                ", state=" + state +
                ", UnitIsDead=" + UnitIsDead +
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
        return UnitIsDead == unit.UnitIsDead &&
                Objects.equals(characterClass, unit.characterClass) &&
                state == unit.state &&
                Objects.equals(position, unit.position) &&
                Objects.equals(unitAssets, unit.unitAssets) &&
                Objects.equals(source, unit.source) &&
                Objects.equals(target, unit.target);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), characterClass, state, UnitIsDead, position, unitAssets, source, target);
    }


    //JPA

    public void addCasterMovement(BasePlayerMove action){
        if(!getSource().add(action)){
            getSource().add(action);
            action.setCaster(this);

            }
    }

    public void addTargetMovement(BasePlayerMove action){
        if(!getTarget().add(action)){
            getTarget().add(action);
            action.setTarget(this);
        }
    }


    public void removeCasterMovement(BasePlayerMove action){
        if(getSource().contains(action)){
            getSource().remove(action);
            action.setCaster(null);
        }
    }

    public void removeTargetMovement(BasePlayerMove action){
        if(getTarget().contains(action)){
            getTarget().remove(action);
            action.setTarget(null);
        }
    }




}
