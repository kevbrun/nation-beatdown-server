package ch.nation.dbservice.entities.characteristics;


import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.skills.Skill;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name="SKILL_CHARACTERISTICS")
@DiscriminatorValue("SKILL")
public class SkillCharacteristic extends Characteristics {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill skill;


    public SkillCharacteristic(Skill skill) {
        this.skill = skill;
    }

    public SkillCharacteristic(List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers, Skill skill) {
        super(characteristicPrejudiceTriggers);
        this.skill = skill;
    }

    public SkillCharacteristic(String name, String description, List<CharacteristicPrejudiceTrigger> characteristicPrejudiceTriggers, Skill skill) {
        super(name, description, characteristicPrejudiceTriggers);
        this.skill = skill;
    }

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

    public void addSkill(Skill skill){
        if(skill!=null){
            this.setSkill(skill);
            skill.addSkillCharacteristic(this);
        }

    }

    public void removeSkill(){

        if(skill!=null){

            skill.removeSkillCharacteristics(this);
            skill =null;

        }

    }



}
