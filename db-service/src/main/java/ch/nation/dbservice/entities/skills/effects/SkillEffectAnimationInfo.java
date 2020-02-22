package ch.nation.dbservice.entities.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "SKILL_EFFECTS_ANIM")
@Entity(name = "SKILL_EFFECTS_ANIM")
public class SkillEffectAnimationInfo {


        @Id
        @GeneratedValue
        private Long id;


    @JsonProperty("effect_path")
        private String effectPath;
        @JsonProperty("duration")
        private float duration;
        @JsonProperty("anim_target")
        @Enumerated(EnumType.STRING)
        private SkillEffectTarget target;

    public SkillEffectAnimationInfo() {
        effectPath="";
        duration = 0.0f;
        target = SkillEffectTarget.NONE;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillEffectTarget getTarget() {
        return target;
    }



    public void setTarget(SkillEffectTarget target) {
        this.target = target;
    }

    public String getEffectPath() {
        return effectPath;
    }

    public void setEffectPath(String effectPath) {
        this.effectPath = effectPath;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
