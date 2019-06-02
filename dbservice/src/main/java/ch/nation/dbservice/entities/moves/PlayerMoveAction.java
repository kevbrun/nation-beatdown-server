package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.moves.values.MoveValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;

@Entity(name="PLAYER_MOVES")
@Table(name="PLAYER_MOVES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Transactional
public class PlayerMoveAction extends AbstractNationEntityBase {



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @RestResource(path = "game", rel="game")
    @JsonProperty("game")
    private Game game;


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


    @OneToOne
    @JsonProperty("value")
    private MoveValue value;



    public PlayerMoveAction() {
        super();

    }


    public PlayerMoveAction(Game game, User user, Unit caster, Unit target, Skill skill, MoveValue value) {
        this.game = game;
        this.user = user;
        this.caster = caster;
        this.target = target;
        this.skill = skill;
        this.value = value;
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


    public void setCaster(Unit caster) {

        LOGGER.info("Custom set Method called");

        if(caster!=null){


            if(this.caster!=null){
                this.caster.removeCasterMovement(this);


                this.caster = caster;
                caster.addCasterMovement(this);
            }else{
                this.caster = caster;
                caster.addCasterMovement(this);
            }

        }else{
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

    public MoveValue getValue() {
        return value;
    }

    public void setValue(MoveValue value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "PlayerMoveAction{" +
                "game=" + game +
                ", user=" + user +
                ", caster=" + caster +
                ", target=" + target +
                ", skill=" + skill +
                ", value=" + value +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerMoveAction)) return false;
        if (!super.equals(o)) return false;
        PlayerMoveAction that = (PlayerMoveAction) o;
        return Objects.equals(game, that.game) &&
                Objects.equals(user, that.user) &&
                Objects.equals(caster, that.caster) &&
                Objects.equals(target, that.target) &&
                Objects.equals(skill, that.skill) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), game, user, caster, target, skill, value);
    }
}
