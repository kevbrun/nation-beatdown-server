package ch.nation.rest.services.impl.games;

import ch.nation.core.model.dto.game.GameDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.game.DBGameRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;

public class GameServiceImpl extends AbstractGenericEntityService<GameDto,GameDto> implements GameService {

    private final DBRestServiceBaseInterface client;


    public GameServiceImpl(DBGameRestClient client) {
        super(client);
        this.client = client;
    }
}
