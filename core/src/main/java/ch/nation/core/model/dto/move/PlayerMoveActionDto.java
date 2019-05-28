package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

public class PlayerMoveActionDto extends AbstractPlayerMoveDto {



    @RestResource(path = "game", rel="game")
    @JsonProperty("game")
    private GameDto game;



    @JsonProperty("user")
    private UserDto user;


    @JsonProperty("caster")
    private UnitDto caster;


    @JsonProperty("target")
    private UnitDto target;


    @JsonProperty("skill")
    private SkillDto skill;



    @JsonProperty("value")
    private AbstractMoveValueDto value;


    public PlayerMoveActionDto(GameDto game, UserDto user, UnitDto caster, UnitDto target, SkillDto skill, AbstractMoveValueDto value) {
        this.game = game;
        this.user = user;
        this.caster = caster;
        this.target = target;
        this.skill = skill;
        this.value = value;
    }

    public PlayerMoveActionDto() {
    }

    public GameDto getGame() {
        return game;
    }

    public void setGame(GameDto game) {
        this.game = game;
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

    public UnitDto getTarget() {
        return target;
    }

    public void setTarget(UnitDto target) {
        this.target = target;
    }

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    public AbstractMoveValueDto getValue() {
        return value;
    }

    public void setValue(AbstractMoveValueDto value) {
        this.value = value;
    }
}
