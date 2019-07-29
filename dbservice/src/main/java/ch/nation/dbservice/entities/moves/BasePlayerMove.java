package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
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



    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @RestResource(path = "user-runtimes", rel="user-runtimes",exported = false)
    @JsonIgnore
    private GameUserRuntimeInfo gameInfo;


    @Column(name="round")
    @JsonProperty("round")
    private int round;

    @Column(name="caster_skill_cost")
    @JsonProperty("caster_skill_cost")
    private int skillCost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonProperty("user")
    @RestResource(path = "user", rel="user",exported = true)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "caster_id")
    @JsonProperty("caster")
    @RestResource(path = "caster", rel="caster",exported = true)
 //  @JsonBackReference(value = "unit-caster")
    private Unit caster;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id")
    @JsonProperty("skill")
    @RestResource(path = "skill", rel="skill",exported = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Skill skill;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("effect_values")
    @RestResource(path = "values",rel = "values",exported = true)
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


    public int getSkillCost() {
        return skillCost;
    }

    public void setSkillCost(int skillCost) {
        this.skillCost = skillCost;
    }

    public GameUserRuntimeInfo getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameUserRuntimeInfo gameInfo) {
        this.gameInfo = gameInfo;
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



    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }




    //JPA FUNC
    @PrePersist
    @PreUpdate
    public void BeforePersist(){

    }

}
