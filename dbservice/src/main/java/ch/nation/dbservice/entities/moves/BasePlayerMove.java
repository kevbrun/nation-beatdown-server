package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.values.AbstractBasePlayerMoveValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Entity(name="PLAYER_MOVES")
@Table(name="PLAYER_MOVES")
@Transactional

public class BasePlayerMove extends AbstractNationEntityBase implements IDiscrimantorValue {



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @RestResource(path = "game", rel="game")
    @JsonProperty("game")
    private Game game;


    @Column(name="round")
    private int round;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonProperty("user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caster_id")
    @JsonProperty("caster")
    private Unit caster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    @JsonProperty("target")
    private Unit target;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id")
    @JsonProperty("skill")
    private Skill skill;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("effect_values")
    @RestResource(path = "values",rel = "values",exported = false)
    private List<AbstractBasePlayerMoveValue> appliedEffects;



    public BasePlayerMove() {
        super();

    }


    public List<AbstractBasePlayerMoveValue> getAppliedEffects() {
        return appliedEffects;
    }

    public void setAppliedEffects(List<AbstractBasePlayerMoveValue> appliedEffects) {

        this.appliedEffects = appliedEffects;
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

        LOGGER.info("Custom set Method called");

        if(caster!=null) {


            if (this.caster != null) {
                this.caster.removeCasterMovement(this);


                this.caster = caster;
                caster.addCasterMovement(this);
            } else {
                this.caster = caster;
                caster.addCasterMovement(this);
            }

        }   else if(caster!=null && this.caster.getSource()!=null){
            this.caster.removeCasterMovement(this);
            this.caster=null;
        }


    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {
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
