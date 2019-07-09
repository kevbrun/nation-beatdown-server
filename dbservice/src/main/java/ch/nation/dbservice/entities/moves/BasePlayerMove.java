package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name="PLAYER_MOVES")
@Table(name="PLAYER_MOVES")
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BasePlayerMove extends AbstractNationEntityBase implements IDiscrimantorValue {



    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    @RestResource(path = "games", rel="games",exported = false)
    @JsonProperty("game")
    @JsonIgnore
    private Game game;


    @Column(name="round")
    private int round;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonProperty("user")
    @RestResource(path = "users", rel="users",exported = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caster_id")
    @JsonProperty("caster")
    @RestResource(path = "caster", rel="caster",exported = false)
    @JsonBackReference(value = "unit-caster")
    private Unit caster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    @RestResource(path = "target", rel="target",exported = false)
    @JsonBackReference(value = "unit-target")
    private Unit target;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id")
    @JsonProperty("skill")
    @RestResource(path = "skills", rel="skills",exported = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Skill skill;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("effect_values")
    @RestResource(path = "values",rel = "values",exported = false)
    private List<BasePlayerMoveValue> appliedEffects = new ArrayList<>();



    public BasePlayerMove() {
        super();

    }


    public List<BasePlayerMoveValue> getAppliedEffects() {
        return appliedEffects;
    }

    public void setAppliedEffects(List<BasePlayerMoveValue> appliedEffects) {
        LOGGER.info("Execute custom setter");

        if (this.appliedEffects == null) {
            this.appliedEffects = appliedEffects;
        } else if(this.appliedEffects != appliedEffects) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.appliedEffects.clear();
            if(appliedEffects != null){
                this.appliedEffects.addAll(appliedEffects);
            }
        }

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Unit getCaster() {
        return caster;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setCaster(Unit caster) {

   /**     LOGGER.info("Custom set Method called");

        if(caster!=null) {


            if (this.caster != null) {
                this.caster.removeCasterMovement(this);


                this.caster = caster;
                caster.addCasterMovement(this);
            } else {
                this.caster = caster;
                caster.addCasterMovement(this);
            }

        }   else if(caster!=null && this.caster.getCaster()!=null){
            this.caster.removeCasterMovement(this);
            this.caster=null;
        }**/

   this.caster = caster;


    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {

        LOGGER.info("Custom set Method called");

     /**   if(target!=null) {


            if (this.target != null) {
                this.target.removeCasterMovement(this);


                this.target = caster;
                target.addCasterMovement(this);
            } else {
                this.target = caster;
                target.addCasterMovement(this);
            }

        }   else if(target!=null && this.target.getTarget()!=null){
            this.target.removeCasterMovement(this);
            this.target=null;
        }**/
     this.target = target;


    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }



    @Override
    public String toString() {
        return "BasePlayerMove{" +
                "game=" + game +
                ", user=" + user +
                ", caster=" + caster +
                ", target=" + target +
                ", skill=" + skill +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePlayerMove)) return false;
        if (!super.equals(o)) return false;
        BasePlayerMove that = (BasePlayerMove) o;
        return Objects.equals(game, that.game) &&
                Objects.equals(user, that.user) &&
                Objects.equals(caster, that.caster) &&
                Objects.equals(target, that.target) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), game, user, caster, target, skill);
    }


    //JPA FUNC
    @PrePersist
    @PreUpdate
    public void BeforePersist(){
        if(game!=null &&game.getRound()!=round){
            round = game.getRound();
        }
    }

}
