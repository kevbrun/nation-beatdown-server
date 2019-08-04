package ch.nation.core.model.dto.characteristics;

import ch.nation.core.model.dto.skills.SkillDto;

public class SkillCharacteristicsDto extends AbstractCharacteristicsDto {


    private SkillDto  skill;


    public SkillCharacteristicsDto(SkillDto skill) {
        this.skill = skill;
    }


    public SkillCharacteristicsDto() {
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
