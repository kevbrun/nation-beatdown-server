package ch.nation.dbservice.entities.moves.projections;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public interface SkillPlayerMoveMaxProjection extends BasePlayerMoveMaxProjection {
    @JsonProperty("caster_skill_cost")
    int getSkillCost();
    @JsonProperty("effect_values")
    List<AbstractNationEntityBase> getAppliedEffects();
    @JsonProperty("cnt_cooldown")
    int getCooldownCounter();
}
