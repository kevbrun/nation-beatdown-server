package ch.nation.rest.services.impl.playerMoves;

import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.stereotype.Service;


@Service
public class PlayerMoveResourceServiceImpl extends AbstractEntityService<BasePlayerMoveDto,BasePlayerMoveDto> {

    public PlayerMoveResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePlayerMoveDto.class, factory, massRestClientFactory);
    }
}
