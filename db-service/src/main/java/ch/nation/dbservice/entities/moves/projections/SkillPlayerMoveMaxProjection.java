package ch.nation.dbservice.entities.moves.projections;

import ch.nation.dbservice.entities.moves.SkillPlayerMove;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


@Projection(types = SkillPlayerMove.class,name="max")
public interface SkillPlayerMoveMaxProjection extends BasePlayerMoveMaxProjection {
    @JsonProperty("caster_skill_cost")
    int getSkillCost();
    @JsonProperty("effect_values")
    List<BasePlayerMoveValue> getAppliedEffects();
    @JsonProperty("cnt_cooldown")
    int getCooldownCounter();
}
