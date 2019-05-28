package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity(name="PLAYER_MOVES")
@Table(name="PLAYER_MOVES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PlayerMoveAction extends AbstractNationEntityBase {



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @RestResource(path = "game", rel="game")
    @JsonProperty("game")
    private Game game;


    @Column(name = "user")
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
        this.caster = caster;
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
}
