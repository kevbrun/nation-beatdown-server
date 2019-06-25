package ch.nation.dbservice.entities.projection;

import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "uuid_only", types = {Skill.class,SkillEffect.class,Character.class})
public interface IUUIDOnlyProjection {


    @JsonProperty("uuid")
    public UUID getId();

}
