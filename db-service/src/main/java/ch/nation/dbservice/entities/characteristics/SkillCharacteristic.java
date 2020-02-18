package ch.nation.dbservice.entities.characteristics;


import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.skills.Skill;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "SKILL_CHARACTERISTICS")
@DiscriminatorValue("SKILL")
public class SkillCharacteristic extends BaseCharacteristic implements IDiscrimantorValue {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    @JsonProperty("skill")
    @RestResource(exported = false)
    private Skill skill;


    public SkillCharacteristic() {
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
        if (!(o instanceof SkillCharacteristic)) return false;
        if (!super.equals(o)) return false;
        SkillCharacteristic that = (SkillCharacteristic) o;
        return Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), skill);
    }


    //Manual

    public void addSkill(Skill skill) {
        if (skill != null) {
            this.setSkill(skill);
            skill.addSkillCharacteristic(this);
        }

    }

    public void removeSkill() {

        if (skill != null) {

            skill.removeSkillCharacteristics(this);
            skill = null;

        }

    }


}
