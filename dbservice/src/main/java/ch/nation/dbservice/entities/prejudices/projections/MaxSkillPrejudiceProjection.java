package ch.nation.dbservice.entities.prejudices.projections;


import ch.nation.dbservice.entities.prejudices.SkillPrejudice;
import ch.nation.dbservice.entities.skills.Skill;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="max",types = SkillPrejudice.class)
public interface MaxSkillPrejudiceProjection extends MaxBasePrejudiceProjection {

    @JsonProperty("skill")
    Skill getSkill();


}
