package ch.nation.rest.services.impl.playerMoves;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.playerMoves.DBPlayerMovesRestClient;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerMoveResourceServiceImpl extends AbstractEntityService<BasePlayerMoveDto,BasePlayerMoveDto> {

    public PlayerMoveResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePlayerMoveDto.class, factory, massRestClientFactory);
    }


     public Optional<List<BasePlayerMoveDto>> getMovesByGameRuntimeUuidAndCasterUuidAndRound(String gameRuntimeUuid,
                                                                                          String casterUuid,
                                                                                          int round,
                                                                                          QueryProjection projection){

        LOGGER.info("START | Querying moves by runtime round and caster");
        final List<BasePlayerMoveDto> response = new ArrayList<>();


      Resources<BasePlayerMoveDto>  movesInRoundOfCaster = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuidAndCasterUuidAndRound(gameRuntimeUuid,casterUuid,round,projection);


      if(movesInRoundOfCaster.getContent()==null)  return Optional.of(response);
        LOGGER.info("STOP | Querying moves by runtime round and caster");
        response.addAll(movesInRoundOfCaster.getContent());
        return Optional.of(response);
    }
}
