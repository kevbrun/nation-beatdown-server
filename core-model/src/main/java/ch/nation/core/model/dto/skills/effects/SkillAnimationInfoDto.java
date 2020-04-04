package ch.nation.core.model.dto.skills.effects;

import ch.nation.core.model.Enums.AnimationSource;
import ch.nation.core.model.Enums.SkillEffectTarget;
import ch.nation.core.model.Enums.WeaponType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class SkillAnimationInfoDto implements Serializable {
        @JsonProperty("effect_path")
        private String effectPath;
        @JsonProperty("duration")
        private float duration;
        @JsonProperty("anim_target")
        private SkillEffectTarget target;
    @JsonProperty("anim_name")
    private String name;
    @JsonProperty("anim_source")
    private AnimationSource source;
    @JsonProperty("anim_weapon")
    private WeaponType weaponType;

    public SkillAnimationInfoDto() {
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

    public String getName() {
        return name;
    }

    public AnimationSource getSource() {
        return source;
    }

    public void setSource(AnimationSource source) {
        this.source = source;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillAnimationInfoDto)) return false;
        SkillAnimationInfoDto that = (SkillAnimationInfoDto) o;
        return Float.compare(that.duration, duration) == 0 &&
                Objects.equals(effectPath, that.effectPath) &&
                target == that.target &&
                Objects.equals(name, that.name) &&
                source == that.source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(effectPath, duration, target, name, source);
    }

    @Override
    public String toString() {
        return "SkillEffectAnimationInfoDto{" +
                "effectPath='" + effectPath + '\'' +
                ", duration=" + duration +
                ", target=" + target +
                ", name='" + name + '\'' +
                ", source=" + source +
                '}';
    }
}
