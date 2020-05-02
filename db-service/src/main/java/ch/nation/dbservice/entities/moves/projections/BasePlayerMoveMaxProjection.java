package ch.nation.dbservice.entities.moves.projections;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.Calendar;


@Projection(name = "max", types = {BasePlayerMove.class})
public interface BasePlayerMoveMaxProjection extends MinimizedEntityResponseProjection {

    @JsonProperty("user")
    User getUser();

    @JsonProperty("caster")
    Unit getCaster();

    @JsonProperty("round")
    int getRound();

    @JsonProperty("skill")
    Skill getSkill();

    @JsonProperty("created")
    Calendar getCreationTimestamp();

    @JsonProperty("updated")
    Calendar getUpdateTimemstamp();

    @JsonProperty("seqId")
    int getSequenceIdentifier();

}
