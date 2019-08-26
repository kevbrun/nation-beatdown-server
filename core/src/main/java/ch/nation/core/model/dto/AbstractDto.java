package ch.nation.core.model.dto;

import ch.nation.core.model.dto.characteristics.BaseCharacteristicDto;
import ch.nation.core.model.dto.characteristics.SkillCharacteristicsDto;
import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.core.model.dto.prejudices.BasePrejudiceDto;
import ch.nation.core.model.dto.prejudices.SkillPrejudiceDto;
import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.core.model.dto.prejudices.triggers.CharacteristicPrejudiceTriggerDto;
import ch.nation.core.model.dto.prejudices.triggers.StatPrejudiceTriggerDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.skills.effects.StatSkillEffectDto;
import ch.nation.core.model.dto.skills.effects.TimeReversalSkillEffectDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type",visible = true)
@JsonSubTypes({

        //BASE
        @JsonSubTypes.Type(value = SkillCharacteristicsDto.class, name = "SkillCharacteristic"),
        @JsonSubTypes.Type(value = StatCharacteristicsDto.class, name = "StatCharacteristic"),
        @JsonSubTypes.Type(value = BaseCharacteristicDto.class, name = "BaseCharacteristic"),
        @JsonSubTypes.Type(value = CharacterClassDto.class, name = "CharacterClass"),
        @JsonSubTypes.Type(value = GameDto.class, name = "Game"),


        //MOVES
        @JsonSubTypes.Type(value = StatSkillPlayerMoveSkillValueDto.class, name = "StatPlayerMoveValue"),
        @JsonSubTypes.Type(value = MoveSkillEffectPlayerMoveSkillValueDto.class, name = "MoveSkillPlayerMoveValue"),
        @JsonSubTypes.Type(value = BasePlayerMoveDto.class, name = "BasePlayerMove"),
        @JsonSubTypes.Type(value = SkillPlayerMoveDto.class, name = "SkillPlayerMove"),
        @JsonSubTypes.Type(value = GameUserRuntimeInfoDto.class, name = "GameUserRuntimeInfo"),


        //PREJUDICES
        @JsonSubTypes.Type(value = StatPrejudiceDto.class, name = "StatPrejudice"),
        @JsonSubTypes.Type(value = SkillPrejudiceDto.class, name = "SkillPrejudice"),
        @JsonSubTypes.Type(value = BasePrejudiceDto.class, name = "BasePrejudice"),




        //TRIGGERS
        @JsonSubTypes.Type(value = CharacteristicPrejudiceTriggerDto.class, name = "CharacteristicPrejudiceTrigger"),
        @JsonSubTypes.Type(value = StatPrejudiceTriggerDto.class, name = "StatPrejudiceTrigger"),


        //SKILL
        @JsonSubTypes.Type(value = SkillDto.class, name = "Skill"),
        @JsonSubTypes.Type(value = SkillDto.class, name = "MoveSkill"),
        @JsonSubTypes.Type(value = SkillDto.class, name = "SelfMoveSkill"),


        //SKILL_EFFECTS
        @JsonSubTypes.Type(value = SkillEffectDto.class, name = "SkillEffect"),
        @JsonSubTypes.Type(value = TimeReversalSkillEffectDto.class, name = "TimeReversalSkillEffect"),
        @JsonSubTypes.Type(value = SkillEffectDto.class, name = "SelfMoveEffect"),
        @JsonSubTypes.Type(value = StatSkillEffectDto.class, name = "StatSkillEffect"),


        //UNITS
        @JsonSubTypes.Type(value = UnitDto.class, name = "Unit"),

        //NATION
        @JsonSubTypes.Type(value = NationDto.class, name = "Nation"),

        //USER
        @JsonSubTypes.Type(value = UserDto.class, name = "User")




})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractDto implements Serializable {
    @JsonProperty("uuid")
    protected String id;
    @JsonProperty("type")
    private String type;

    public AbstractDto() {
        super();
    }

    @JsonIgnore
    public abstract String ResourceCollectionName();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
