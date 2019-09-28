package ch.nation.dbservice.entities.moves;

import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity(name="SKILL_PLAYER_MOVES")
//@Table(name="SKILL_PLAYER_MOVES")
@DiscriminatorValue("SKILL")
public class SkillPlayerMove extends BasePlayerMove {


    @Column(name="caster_skill_cost")
    @JsonProperty("caster_skill_cost")
    private int skillCost;

    @Column(name="cnt_cooldown")
    @JsonProperty("cnt_cooldown")
    private int cooldownCounter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty("effect_values")
    @RestResource(path = "values",rel = "values")
    private List<BasePlayerMoveValue> appliedEffects = new ArrayList<>();



    public SkillPlayerMove() {
        super();
        cooldownCounter = 0;
    }


    public int getCooldownCounter() {
        return cooldownCounter;
    }

    public void setCooldownCounter(int cooldownCounter) {
        this.cooldownCounter = cooldownCounter;
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








    //JPA FUNC
    @PrePersist
    @PreUpdate
    public void BeforePersist(){

    }

}
