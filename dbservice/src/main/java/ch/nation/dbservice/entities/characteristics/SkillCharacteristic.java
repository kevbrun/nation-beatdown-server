package ch.nation.dbservice.entities.characteristics;


import ch.nation.dbservice.entities.skills.Skill;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity(name="SKILL_CHARACTERISTICS")
@DiscriminatorValue("SKILL")
public class SkillCharacteristic extends Characteristics {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "skill_skill_characteristic",
            joinColumns = { @JoinColumn(name = "skill_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_characteristic_id", referencedColumnName = "id") })
    @RestResource(path = "skills", rel="skills")
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
    public String toString() {
        return "SkillCharacteristic{" +
                "skill=" + skill +
                "} " + super.toString();
    }
}
