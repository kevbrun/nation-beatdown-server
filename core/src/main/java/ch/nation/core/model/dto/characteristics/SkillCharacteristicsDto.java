package ch.nation.core.model.dto.characteristics;

import ch.nation.core.model.dto.skills.SkillDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SkillCharacteristicsDto extends AbstractCharacteristicsDto {


    @JsonProperty("skill")
    private SkillDto  skill;


    public SkillCharacteristicsDto() {
        super();
    }

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }


    @Override
    public String toString() {
        return "SkillCharacteristicsDto{" +
                "skill=" + skill +
                "} " + super.toString();
    }
}
