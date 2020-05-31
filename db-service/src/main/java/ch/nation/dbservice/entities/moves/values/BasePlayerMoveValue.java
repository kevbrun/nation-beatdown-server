package ch.nation.dbservice.entities.moves.values;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity(name = "PLAYER_MOVES_VALUES")
@Table(name = "PLAYER_MOVES_VALUES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PLAYER_MOVE_VALUE_TYPE", discriminatorType = DiscriminatorType.STRING)
@Transactional
@DiscriminatorValue("BASE")
//@JsonDeserialize(using = PlayerMoveValueDeserializer.class)
public class BasePlayerMoveValue extends AbstractNationEntityBase implements IDiscrimantorValue {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_id")
    @RestResource(path = "moves", rel = "moves")
    @JsonIgnore
    private BasePlayerMove move;


    //LAZY Will cause Buddy Exception
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "target_id")
    @RestResource(path = "target", rel = "target", exported = false)
    // @JsonBackReference(value = "unit-target")
    @JsonProperty("target")
    private Unit target;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_effect_id")
    @RestResource(path = "skill-effect", rel = "skill-effect", exported = false)
    @JsonProperty("skill_effect")
    private SkillEffect skillEffect;

    public BasePlayerMoveValue() {
        super();
    }


    public Unit getTarget() {
        return target;
    }

    public SkillEffect getSkillEffect() {
        return skillEffect;
    }

    public void setSkillEffect(SkillEffect skillEffect) {
        this.skillEffect = skillEffect;
    }

    public void setTarget(Unit target) {

        LOGGER.debug("Custom set Method called");

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

    public BasePlayerMove getMove() {
        return move;
    }

    public void setMove(BasePlayerMove move) {
        this.move = move;
    }


    public void removeTarget() {
        if (target != null) {
            target.removeMovementValue(this);
            target = null;
            LOGGER.info("Remove associations with Target");

        }
    }

    public void removeSkillEffect() {
        if (skillEffect != null) {
            skillEffect.removeMoveValue(this);
            skillEffect = null;
            LOGGER.info("Remove associations with SkillEffect");

        }

    }


    @PreRemove
    public void preRemoveEntity() {
        LOGGER.info("Start to remove associations between objects:");
        removeTarget();
        removeSkillEffect();


    }


}
