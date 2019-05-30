package ch.nation.rest.services.impl.games;

import ch.nation.core.model.dto.game.GameDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.game.DBGameRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameServiceImpl extends AbstractGenericEntityService<GameDto,GameDto> implements GameService {


    @Autowired
    public GameServiceImpl(DBGameRestClient client) {
        super(client);
    }
}
