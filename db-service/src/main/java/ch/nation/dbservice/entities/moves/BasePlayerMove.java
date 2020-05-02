package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity(name = "PLAYER_MOVES")
@Table(name = "PLAYER_MOVES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PLAYER_MOVE", discriminatorType = DiscriminatorType.STRING)
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DiscriminatorValue("BASE")
public class BasePlayerMove extends AbstractNationEntityBase implements IDiscrimantorValue {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @RestResource(path = "user-runtimes", rel = "user-runtimes", exported = false)
    @JsonIgnore
    private GameUserRuntimeInfo gameInfo;
    @Column(name = "round")
    @JsonProperty("round")
    private int round;

    @JsonProperty("seqId")
    private int sequenceIdentifier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonProperty("user")
    @RestResource(path = "user", rel = "user", exported = true)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "caster_id")
    @JsonProperty("caster")
    @RestResource(path = "caster", rel = "caster", exported = true)
    //  @JsonBackReference(value = "unit-caster")
    private Unit caster;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    @JsonProperty("skill")
    @RestResource(path = "skill", rel = "skill", exported = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Skill skill;

    @JsonProperty("was_reversed")
    private boolean wasReversed;


    public BasePlayerMove() {
        wasReversed = false;
    }

    public int getSequenceIdentifier() {
        return sequenceIdentifier;
    }

    public void setSequenceIdentifier(int sequenceIdentifier) {
        this.sequenceIdentifier = sequenceIdentifier;
    }

    public boolean isWasReversed() {
        return wasReversed;
    }

    public void setWasReversed(boolean wasReversed) {
        this.wasReversed = wasReversed;
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


    public void removeSkill() {
        if (getSkill() != null) {
            getSkill().removeMove(this);
            setSkill(null);
            LOGGER.info("Removed skill association");
        }
    }

    public void removeUserRuntime() {
        if (getGameInfo() != null) {
            getGameInfo().removeMove(this);
            setGameInfo(null);
            LOGGER.info("Removed UserRuntime association");

        }
    }

    public void removeUser() {
        if (getUser() != null) {
            getUser().removePlayerMove(this);
            setUser(null);
            LOGGER.info("Removed User association");

        }
    }

    public void removeCaster() {
        if (getCaster() != null) {
            getCaster().removeCasterMovement(this);
            setCaster(null);
            LOGGER.info("Removed Caster association");

        }
    }

    @PreRemove
    public void preRemoveEntity() {
        LOGGER.info("Start to remove associations between objects:");
        removeSkill();
        removeUserRuntime();
        removeUser();
        removeCaster();


    }


}
