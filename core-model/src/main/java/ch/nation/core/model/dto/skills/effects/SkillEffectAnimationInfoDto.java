package ch.nation.core.model.dto.skills.effects;

import ch.nation.core.model.Enums.SkillEffectTarget;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SkillEffectAnimationInfoDto {
        @JsonProperty("effect_path")
        private String effectPath;
        @JsonProperty("duration")
        private float duration;
    @JsonProperty("anim_target")
    private SkillEffectTarget target;
    public SkillEffectAnimationInfoDto() {
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
