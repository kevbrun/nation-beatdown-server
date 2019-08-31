package ch.nation.moves.service;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractEntityService;
import ch.nation.core.clients.db.playerMoves.DBPlayerMovesRestClient;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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


    public Optional<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeInfo(String gameRuntimeUuid, QueryProjection projection){
        LOGGER.info("START | Querying moves by runtime");
        final List<AbstractPlayerMoveDto> response = new ArrayList<>();
        Resources<BasePlayerMoveDto> moves = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuid(gameRuntimeUuid,projection);
        if(moves!=null && moves.getContent()!=null) response.addAll(moves.getContent());
        LOGGER.info("STOP | Querying moves by runtime");
        return Optional.of(response);
    }

    public Optional<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeInfoAndUnit(String gameRuntimeUuid,String unitUuid,QueryProjection projection){
        LOGGER.info(String.format("START | Querying moves by runtime and unit | Unit: %s",unitUuid));
        final List<AbstractPlayerMoveDto> response = new ArrayList<>();
        Resources<BasePlayerMoveDto> moves = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuid(gameRuntimeUuid,projection);
        if(moves!=null && moves.getContent()!=null){
         response.addAll(moves.getContent().stream().filter((x)-> x.getCaster().getId().equals(unitUuid)).collect(Collectors.toUnmodifiableList()));

        }
        LOGGER.info("STOP | Querying moves by runtime");

        LOGGER.info(String.format("STOP | Querying moves by runtime and unit | Unit: %s",unitUuid));

        return Optional.of(response);


    }
}
