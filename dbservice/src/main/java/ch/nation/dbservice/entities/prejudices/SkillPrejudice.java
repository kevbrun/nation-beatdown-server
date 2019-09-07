package ch.nation.dbservice.entities.prejudices;

import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.skills.Skill;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name="SKILL_PREJUDICE")
@DiscriminatorValue("SKILL")
public class SkillPrejudice extends BasePrejudice  implements IDiscrimantorValue {


    @ManyToOne
    @JsonProperty("skill")
    @RestResource(rel="skill",path = "skills")
    private Skill skill;

    public SkillPrejudice() {
        super();
    }


    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillPrejudice)) return false;
        if (!super.equals(o)) return false;
        SkillPrejudice that = (SkillPrejudice) o;
        return Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skill);
    }

    @Override
    public String toString() {
        return "SkillPrejudice{" +
                "skill=" + skill +
                '}';
    }
}
