package ch.nation.rest.services.impl.games;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.position.Vector3Int;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.game.DBGameRuntimeInfoRestClient;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameUserRuntimeInfoServiceImpl extends AbstractEntityService<GameUserRuntimeInfoDto,GameUserRuntimeInfoDto>  implements GameUserRuntimeInfoService{


    public GameUserRuntimeInfoServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(GameUserRuntimeInfoDto.class, factory, massRestClientFactory);
    }

    @Override
    public Optional<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(String gameUuid, String playerUuid) {
        return getUserRuntimeInfoByGameUuidAndByPlayerUuid(gameUuid,playerUuid,QueryProjection.def);
    }

    @Override
    public Optional<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(String gameUuid, String playerUuid, QueryProjection projection) {

       GameUserRuntimeInfoDto result= ((DBGameRuntimeInfoRestClient)getDefaultClient()).findByGame_UuidAnAndPlayerUuid(gameUuid,playerUuid,projection);


        return Optional.of(result);
    }






}
