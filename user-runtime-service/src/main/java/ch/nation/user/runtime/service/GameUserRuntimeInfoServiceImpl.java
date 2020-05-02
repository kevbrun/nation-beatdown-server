package ch.nation.user.runtime.service;

import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.clients.db.game.DBGameRuntimeInfoRestClient;
import ch.nation.core.model.Enums.GameStatus;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.services.AbstractEntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GameUserRuntimeInfoServiceImpl extends AbstractEntityService<GameUserRuntimeInfoDto, GameUserRuntimeInfoDto> implements GameUserRuntimeInfoService {


    public GameUserRuntimeInfoServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(GameUserRuntimeInfoDto.class, factory, massRestClientFactory);
    }

    @Override
    public Optional<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(String gameUuid, String playerUuid) {
        return getUserRuntimeInfoByGameUuidAndByPlayerUuid(gameUuid, playerUuid, QueryProjection.def);
    }

    @Override
    public Optional<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(String gameUuid, String playerUuid, QueryProjection projection) {

        GameUserRuntimeInfoDto result = ((DBGameRuntimeInfoRestClient) getDefaultClient()).findByGame_UuidAnAndPlayerUuid(gameUuid, playerUuid, projection);


        return Optional.of(result);
    }

    public long getCountOfGamesByUserUuidAndGameStatus(String playerUuid, GameStatus status){

        long result =0;

        result = ((DBGameRuntimeInfoRestClient) getDefaultClient()).countAllByPlayerUuidAndGame_GameStatus(playerUuid, status);



        return result;
    }


}
