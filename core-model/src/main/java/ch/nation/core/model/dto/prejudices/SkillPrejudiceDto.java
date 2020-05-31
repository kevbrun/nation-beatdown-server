package ch.nation.core.model.dto.prejudices;

import ch.nation.core.model.dto.skills.SkillDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SkillPrejudiceDto extends BasePrejudiceDto {


    @JsonProperty("skill")
    private SkillDto skillDto;


    public SkillPrejudiceDto() {
        super();
    }

    public SkillDto getSkillDto() {
        return skillDto;
    }

    public void setSkillDto(SkillDto skillDto) {
        this.skillDto = skillDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillPrejudiceDto)) return false;
        if (!super.equals(o)) return false;
        SkillPrejudiceDto that = (SkillPrejudiceDto) o;
        return Objects.equals(skillDto, that.skillDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skillDto);
    }

    @Override
    public String toString() {
        return "SkillPrejudiceDto{" +
                "skillDto=" + skillDto +
                ", id='" + id + '\'' +
                '}';
    }
}
