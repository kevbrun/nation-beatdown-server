package ch.nation.core.model.dto;

import ch.nation.core.model.dto.characteristics.SkillCharacteristicsDto;
import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.move.MoveSkillValueDto;
import ch.nation.core.model.dto.move.PlayerMoveActionDto;
import ch.nation.core.model.dto.move.StatMoveValueDtoDto;
import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.core.model.dto.prejudices.triggers.CharacteristicPrejudiceTriggerDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.skills.effects.TimeReversalSkillEffectDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.NationDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type",visible = true)
@JsonSubTypes({

        //BASE
        @JsonSubTypes.Type(value = SkillCharacteristicsDto.class, name = "SkillCharacteristic"),
        @JsonSubTypes.Type(value = StatCharacteristicsDto.class, name = "StatCharacteristic"),
        @JsonSubTypes.Type(value = CharacterClassDto.class, name = "CharacterClass"),
        @JsonSubTypes.Type(value = GameDto.class, name = "Game"),


        //MOVES
        @JsonSubTypes.Type(value = MoveSkillValueDto.class, name = "MoveSkillValue"),
        @JsonSubTypes.Type(value = StatMoveValueDtoDto.class, name = "StatMoveValue"),
        @JsonSubTypes.Type(value = PlayerMoveActionDto.class, name = "PlayerMoveAction"),


        //PREJUDICES
        @JsonSubTypes.Type(value = StatPrejudiceDto.class, name = "StatPrejudice"),


        //TRIGGERS
        @JsonSubTypes.Type(value = CharacteristicPrejudiceTriggerDto.class, name = "CharacteristicPrejudiceTrigger"),
        @JsonSubTypes.Type(value = StatPrejudiceDto.class, name = "StatPrejudice"),



        //SKILL
        @JsonSubTypes.Type(value = SkillDto.class, name = "Skill"),


        //SKILL_EFFECTS
        @JsonSubTypes.Type(value = SkillEffectDto.class, name = "SkillEffect"),
        @JsonSubTypes.Type(value = TimeReversalSkillEffectDto.class, name = "TimeReversalSkillEffect"),


        //UNITS
        @JsonSubTypes.Type(value = UnitDto.class, name = "Unit"),

        //NATION
        @JsonSubTypes.Type(value = NationDto.class, name = "Nation"),


        //USER
        @JsonSubTypes.Type(value = UserDto.class, name = "User")




})
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