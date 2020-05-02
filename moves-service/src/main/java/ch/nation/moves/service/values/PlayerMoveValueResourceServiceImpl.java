package ch.nation.moves.service.values;


import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.model.dto.move.values.BasePlayerMoveValueDto;
import ch.nation.core.services.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class PlayerMoveValueResourceServiceImpl extends AbstractEntityService<BasePlayerMoveValueDto, BasePlayerMoveValueDto> {


    public PlayerMoveValueResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePlayerMoveValueDto.class, factory, massRestClientFactory);
    }


}
