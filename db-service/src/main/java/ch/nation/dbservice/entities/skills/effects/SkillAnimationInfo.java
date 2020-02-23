package ch.nation.dbservice.entities.skills.effects;

import ch.nation.core.model.Enums.AnimationSource;
import ch.nation.core.model.Enums.SkillEffectTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

//@Table(name = "SKILL_EFFECTS_ANIM")
//@Entity(name = "SKILL_EFFECTS_ANIM")
@Embeddable
public class SkillAnimationInfo {


        @JsonProperty("anim_name")
        private String name;
        @JsonProperty("effect_path")
        private String effectPath;
        @JsonProperty("duration")
        private float duration;
        @JsonProperty("anim_target")
        @Enumerated(EnumType.STRING)
        private SkillEffectTarget target;
        @JsonProperty("anim_source")
        @Enumerated(EnumType.STRING)
        private AnimationSource source;

    public SkillAnimationInfo() {
        effectPath="";
        duration = 0.0f;
        target = SkillEffectTarget.NONE;
        source = AnimationSource.NONE;
    }




    public SkillEffectTarget getTarget() {
        return target;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimationSource getSource() {
        return source;
    }

    public void setSource(AnimationSource source) {
        this.source = source;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillAnimationInfo)) return false;
        SkillAnimationInfo that = (SkillAnimationInfo) o;
        return Float.compare(that.duration, duration) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(effectPath, that.effectPath) &&
                target == that.target &&
                source == that.source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, effectPath, duration, target, source);
    }

    @Override
    public String toString() {
        return "SkillEffectAnimationInfo{" +
                "name='" + name + '\'' +
                ", effectPath='" + effectPath + '\'' +
                ", duration=" + duration +
                ", target=" + target +
                ", source=" + source +
                '}';
    }
}
