package ch.nation.moves.service;

import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.clients.db.playerMoves.DBPlayerMovesRestClient;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dtoWrapper.SimpleResourceDto;
import ch.nation.core.services.AbstractEntityService;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlayerMoveResourceServiceImpl extends AbstractEntityService<BasePlayerMoveDto, BasePlayerMoveDto> {

    public PlayerMoveResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePlayerMoveDto.class, factory, massRestClientFactory);
    }


    public Optional<SimpleResourceDto> getMovesByGameRuntimeUuidAndCasterUuidAndRound(String gameRuntimeUuid,
                                                                                      String casterUuid,
                                                                                      int round,
                                                                                      QueryProjection projection) {

        LOGGER.info("START | Querying moves by runtime round and caster");

        PagedResources<BasePlayerMoveDto> movesInRoundOfCaster = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuidAndCasterUuidAndRound(gameRuntimeUuid, casterUuid, round, projection);
        if (movesInRoundOfCaster.getContent() == null) return Optional.of(new SimpleResourceDto());
        LOGGER.info("STOP | Querying moves by runtime round and caster");
        return Optional.of(new SimpleResourceDto(movesInRoundOfCaster));
    }


    public Optional<SimpleResourceDto> getMovesByGameRuntimeInfo(String gameRuntimeUuid, long page, long size, QueryProjection projection) {
        LOGGER.info("START | Querying moves by runtime");
        PagedResources<BasePlayerMoveDto> moves = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuid(gameRuntimeUuid, page, size, projection);
        LOGGER.info("STOP | Querying moves by runtime");
        return Optional.of(new SimpleResourceDto(moves));
    }

    public Optional<SimpleResourceDto> getMovesByGameRuntimeInfoAndUnit(String gameRuntimeUuid, String unitUuid, long page, long size, QueryProjection projection) {
        LOGGER.info(String.format("START | Querying moves by runtime and unit | Unit: %s", unitUuid));
        final List<AbstractPlayerMoveDto> response = new ArrayList<>();
        PagedResources<BasePlayerMoveDto> moves = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuid(gameRuntimeUuid, page, size, projection);
        if (moves != null && moves.getContent() != null) {
            response.addAll(moves.getContent().stream().filter((x) -> x.getCaster().getId().equals(unitUuid)).collect(Collectors.toUnmodifiableList()));

        }


        LOGGER.info(String.format("STOP | Querying moves by runtime and unit | Unit: %s", unitUuid));

        //TODO Test if multiple pages are available
        return Optional.of(new SimpleResourceDto(size, response.size(), 1L, page, new ArrayList<AbstractDto>(response)));


    }


    public int getCountOfMovesPerPlayerByGameRuntime(final String gameRuntimeUuid) {
        LOGGER.info(String.format("START | Get count of moves by runtime  | Unit: %s", gameRuntimeUuid));
        int countOfMoves = ((DBPlayerMovesRestClient) getDefaultClient()).getAllMovesPerPlayerByGameRuntimeUuid(gameRuntimeUuid);
        LOGGER.debug(String.format("Count of moves | Game Runtime %s | Count: %d", gameRuntimeUuid, countOfMoves));
        LOGGER.info(String.format("STOP | Get count of moves by runtime  | Unit: %s", gameRuntimeUuid));
        return countOfMoves;
    }
}
