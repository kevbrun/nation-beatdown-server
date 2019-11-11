package ch.nation.dbservice.entities.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.clazzes.Stat;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.moves.SkillPlayerMove;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name="unit_state")
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
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @RestResource(rel = "caster",path = "caster")
    @JsonProperty("caster")
  // @JsonManagedReference(value="unit-caster")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<BasePlayerMove> caster = new ArrayList<>();

    @OneToMany(
            mappedBy = "target",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @RestResource(rel="target",path = "target",exported = true)
    @JsonProperty("target")
 //   @JsonManagedReference(value = "unit-target")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<BasePlayerMoveValue> target = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



    @Column(name="hp")
    @JsonProperty("hp")
    private int healthPoints;


    @Column(name="ap")
    @JsonProperty("ap")
    private int actionPoints;


    @Column(name="str")
    @JsonProperty("str")
    private int strength;


    @Column(name="vit")
    @JsonProperty("vit")
    private int vitality;

    @Column(name="intelligence")
    @JsonProperty("int")
    private int intelligence;


    @Column(name="dex")
    @JsonProperty("dex")
    private int dexterity;


    @Column(name="agi")
    @JsonProperty("agi")
    private int agility;



    public Unit() {
        super();


    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
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
        LOGGER.info("Execute custom setter");

        if(unitAssets==null)unitAssets = new UnitAssets();
        return unitAssets;
    }

    public void setUnitAssets(UnitAssets unitAssets) {
        this.unitAssets = unitAssets;
    }

    public List<BasePlayerMove> getCaster() {

        if(caster ==null) caster = new ArrayList<>();

        return caster;
    }

    public void setCaster(List<BasePlayerMove> caster) {
        LOGGER.info("Execute custom setter");

        if (this.caster == null) {
            this.caster = caster;
        } else if(this.caster != caster) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.caster.clear();
            if(caster != null){
                this.caster.addAll(caster);
            }
        }



    }

    public List<BasePlayerMoveValue> getTarget() {

        if(target==null) target = new ArrayList<>();
        return target;
    }

    public void setTarget(List<BasePlayerMoveValue> target) {

        if (this.target == null) {
            this.target = target;
        } else if(this.target != target) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.target.clear();
            if(target != null){
                this.target.addAll(target);
            }
        }



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
                Objects.equals(caster, unit.caster) &&
                Objects.equals(target, unit.target);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), characterClass, state, UnitIsDead, position, unitAssets, caster, target);
    }


    //JPA

    public void addCasterMovement(BasePlayerMove action){
        if(!getCaster().add(action)){
            getCaster().add(action);
            action.setCaster(this);

            }
    }

    public void removeCasterMovement(BasePlayerMove action){
        if(getCaster().contains(action)){
            getCaster().remove(action);
            action.setCaster(null);
        }
    }


    public void removeMovementValue(BasePlayerMoveValue value){
        if(getTarget().contains(value)){
            getTarget().remove(value);
            value.setTarget(null);
        }


    }


  /**  public void addTargetMovement(BasePlayerMoveValue action){
        if(!getTarget().add(action)){
            getTarget().add(action);
            action.setTarget(this);
        }
    }


    public void removeTargetMovement(BasePlayerMoveValue action){
        if(getTarget().contains(action)){
            getTarget().remove(action);
            action.setTarget(null);
        }
    }

**/


}
