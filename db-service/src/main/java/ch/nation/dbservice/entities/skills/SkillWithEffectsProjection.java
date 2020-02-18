package ch.nation.dbservice.entities.skills;

import ch.nation.core.model.Enums.Target;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.projection.components.IIdentityProjection;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "max", types = {Skill.class, MoveSkill.class})
public interface SkillWithEffectsProjection extends TimestampProjection, NamedClassesProjection, IIdentityProjection {


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

    @JsonProperty("effects")
    public List<SkillEffect> getSkillEffects();


}
