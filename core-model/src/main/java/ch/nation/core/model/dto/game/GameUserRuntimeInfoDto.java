package ch.nation.core.model.dto.game;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.position.IVector3;
import ch.nation.core.model.position.Vector3Int;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameUserRuntimeInfoDto extends AbstractDto {


    @JsonProperty("consideration_time")
    private long considerationTime;

    @JsonProperty("moves")
    private List<AbstractPlayerMoveDto> actions;

    @JsonProperty("player_uuid")
    private String playerUuid;

    @JsonProperty("fow")
    private List<Vector3Int> uncoveredFogOfWar;

    public GameUserRuntimeInfoDto() {
    }

    public GameUserRuntimeInfoDto(String playerUuid, long considerationTime) {
        this.considerationTime = considerationTime;
        this.playerUuid = playerUuid;
    }

    public GameUserRuntimeInfoDto(long considerationTime) {
        this.considerationTime = considerationTime;
    }

    public long getConsiderationTime() {
        return considerationTime;
    }

    public void setConsiderationTime(long considerationTime) {
        this.considerationTime = considerationTime;
    }


    public List<Vector3Int> getUncoveredFogOfWar() {
        return uncoveredFogOfWar;
    }

    public void setUncoveredFogOfWar(List<Vector3Int> uncoveredFogOfWar) {
        this.uncoveredFogOfWar = uncoveredFogOfWar;
    }

    public List<AbstractPlayerMoveDto> getActions() {
        return actions;
    }

    public void setActions(List<AbstractPlayerMoveDto> actions) {
        this.actions = actions;
    }


    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    @Override
    public String ResourceCollectionName() {
        return "user-runtimes";
    }


    public void addFogOfWarTilePositon(IVector3 position) {
        if (!uncoveredFogOfWar.contains(position)) {
            uncoveredFogOfWar.add((Vector3Int) position);
        }
    }

}
