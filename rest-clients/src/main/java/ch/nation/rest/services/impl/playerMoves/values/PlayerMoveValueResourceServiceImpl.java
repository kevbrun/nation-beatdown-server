package ch.nation.rest.services.impl.playerMoves.values;


import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class PlayerMoveValueResourceServiceImpl extends AbstractEntityService<BasePlayerMoveValueDto,BasePlayerMoveValueDto> {


    public PlayerMoveValueResourceServiceImpl( DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePlayerMoveValueDto.class, factory, massRestClientFactory);
    }



}
