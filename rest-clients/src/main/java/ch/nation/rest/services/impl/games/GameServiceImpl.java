package ch.nation.rest.services.impl.games;

import ch.nation.core.model.dto.game.GameDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.game.DBGameRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameServiceImpl extends AbstractGenericEntityService<GameDto,GameDto> implements GameService {


    public GameServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(GameDto.class,factory, massRestClientFactory);
    }
}
