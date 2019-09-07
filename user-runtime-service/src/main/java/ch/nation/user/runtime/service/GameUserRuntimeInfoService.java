package ch.nation.user.runtime.service;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;

import java.util.Optional;

public interface GameUserRuntimeInfoService {


    Optional<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(String gameUuid,String playerUuid);
    Optional<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(String gameUuid, String playerUuid, QueryProjection projection);
}
