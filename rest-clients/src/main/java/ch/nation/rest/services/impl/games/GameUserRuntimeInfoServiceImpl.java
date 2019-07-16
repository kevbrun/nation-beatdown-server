package ch.nation.rest.services.impl.games;

import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.stereotype.Service;


@Service
public class GameUserRuntimeInfoServiceImpl extends AbstractEntityService<GameUserRuntimeInfoDto,GameUserRuntimeInfoDto> {


    public GameUserRuntimeInfoServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(GameUserRuntimeInfoDto.class, factory, massRestClientFactory);
    }
}
