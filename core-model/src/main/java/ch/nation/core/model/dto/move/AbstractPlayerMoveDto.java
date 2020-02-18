package ch.nation.core.model.dto.move;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.move.values.AbstractMoveSkillEffectValueDto;
import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.List;

public abstract class AbstractPlayerMoveDto extends AbstractDto {

    @JsonProperty("game")
    private GameDto gameDto;
    @JsonProperty("round")
    private int round;
    @JsonProperty("seqId")
    private int sequenceIdentifier;
    @JsonProperty("user")
    private UserDto user;
    @JsonProperty("caster")
    private UnitDto caster;

    @JsonProperty("skill")
    private SkillDto skillDto;


    @JsonProperty("created")
    private Calendar creationTimestamp;
    @JsonProperty("updated")
    private Calendar updateTimemstamp;

    @JsonProperty("was_reversed")
    private boolean wasReversed;


    public AbstractPlayerMoveDto() {
    }


    public GameDto getGameDto() {
        return gameDto;
    }


    public boolean isWasReversed() {
        return wasReversed;
    }

    public void setWasReversed(boolean wasReversed) {
        this.wasReversed = wasReversed;
    }

    public void setGameDto(GameDto gameDto) {
        this.gameDto = gameDto;
    }

    public Calendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public int getSequenceIdentifier() {
        return sequenceIdentifier;
    }

    public void setSequenceIdentifier(int sequenceIdentifier) {
        this.sequenceIdentifier = sequenceIdentifier;
    }

    public void setCreationTimestamp(Calendar creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Calendar getUpdateTimemstamp() {
        return updateTimemstamp;
    }

    public void setUpdateTimemstamp(Calendar updateTimemstamp) {
        this.updateTimemstamp = updateTimemstamp;
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


    @Override
    public String ResourceCollectionName() {
        return "moves";
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " {" +
                "gameDto=" + gameDto +
                ", round=" + round +
                ", user=" + user +
                ", caster=" + caster +
                ", skillDto=" + skillDto +
                ", id='" + id + '\'' +
                "} " + super.toString();
    }
}
