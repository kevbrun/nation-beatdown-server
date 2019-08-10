package ch.nation.dbservice.entities.characteristics.projection;


import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.SkillWithEffectsProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = SkillCharacteristic.class,name="def")
public interface SkillCharacteristicDefaultProjection extends BaseCharacteristicProjecton{


    @JsonProperty("skill")
    SkillWithEffectsProjection getSkill();


}
