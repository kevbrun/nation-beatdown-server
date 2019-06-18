package ch.nation.dbservice.projection.skills;

import ch.nation.core.model.Enums.Target;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.moves.PlayerMoveAction;
import ch.nation.dbservice.entities.skills.ActionArea;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.projection.users.AbstractEntityProjection;
import ch.nation.dbservice.projection.users.NamedClassesProjection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Projection(name = "skill_complete_projection", types = Skill.class)
public interface SkillWithEffectsProjection extends AbstractEntityProjection,NamedClassesProjection {

    public List<SkillCharacteristic> getSkillCharacteristic();

    public void setSkillCharacteristic(List<SkillCharacteristic> skillCharacteristic);

    @JsonProperty("cost")
    public int getCost();

    @JsonProperty("base_value")
    public int getBaseValue();
    @JsonProperty("cooldown")
    public int getCooldown();

    @JsonProperty("current_cooldown")
    public int getCurrentCooldownTimer();

    @JsonProperty("skill_bar_order")
    public int getSkillBarOrder();

    @JsonProperty("area")
    public ActionArea getActionArea();

    @JsonProperty("skill_target")
    public Target getTarget();

    @JsonProperty("skill_effects")
    public List<SkillEffect> getSkillEffects();



}
