package ch.nation.dbservice.entities.game.projections;

import ch.nation.core.model.position.Vector3Int;
import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.projections.BasePlayerMoveMaxProjection;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.vectors.EmbeddableVector3Int;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
@Projection(name = "max", types = GameUserRuntimeInfo.class)
public interface GameUserRuntimeInfoMaxProjection extends MinimizedEntityResponseProjection {

    @JsonProperty("consideration_time")
    long getConsiderationTime();
    @JsonProperty("player_uuid")
    String getPlayerUuid();
    @JsonProperty("moves")
    List<BasePlayerMoveMaxProjection> getMoves();
    @JsonProperty("fow")
    List<EmbeddableVector3Int> getUncoveredFogOfWar();

}
