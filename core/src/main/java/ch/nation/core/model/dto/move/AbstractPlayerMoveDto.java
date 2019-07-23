package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class AbstractPlayerMoveDto extends AbstractDto {

    @JsonProperty("game")
    private GameDto gameDto;
    @JsonProperty("round")
    private int round;
    @JsonProperty("user")
    private UserDto user;
    @JsonProperty("caster")
    private UnitDto caster;

    @JsonProperty("skill")
    private SkillDto skillDto;
    @JsonProperty("effect_values")
    private List<AbstractMoveSkillEffectValueDto> effectValues;

    public AbstractPlayerMoveDto() {
    }

    public GameDto getGameDto() {
        return gameDto;
    }

    public void setGameDto(GameDto gameDto) {
        this.gameDto = gameDto;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public UnitDto getCaster() {
        return caster;
    }

    public void setCaster(UnitDto caster) {
        this.caster = caster;
    }



    public SkillDto getSkillDto() {
        return skillDto;
    }

    public void setSkillDto(SkillDto skillDto) {
        this.skillDto = skillDto;
    }

    public List<AbstractMoveSkillEffectValueDto> getEffectValues() {
        return effectValues;
    }

    public void setEffectValues(List<AbstractMoveSkillEffectValueDto> effectValues) {
        this.effectValues = effectValues;
    }

    @Override
    public String ResourceCollectionName() {
        return "moves";
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" {" +
                "gameDto=" + gameDto +
                ", round=" + round +
                ", user=" + user +
                ", caster=" + caster +
                ", skillDto=" + skillDto +
                ", effectValues=" + effectValues +
                ", id='" + id + '\'' +
                "} " + super.toString();
    }
}
