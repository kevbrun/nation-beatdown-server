package ch.nation.dbservice.entities.Game;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NationEntityBase;
import ch.nation.dbservice.entities.Skills.Skill;
import ch.nation.dbservice.entities.Skills.SkillEffect;
import ch.nation.dbservice.entities.Units.Unit;
import ch.nation.dbservice.entities.User.User;

import javax.persistence.*;

@Entity(name="PLAYER_MOVES")
@Table(name="PLAYER_MOVES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PlayerMoveAction extends AbstractNationEntityBase {



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;
    @Column(name = "user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caster_id")
    private Unit caster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    private Unit target;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id")
    private Skill skill;


    @OneToOne
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
