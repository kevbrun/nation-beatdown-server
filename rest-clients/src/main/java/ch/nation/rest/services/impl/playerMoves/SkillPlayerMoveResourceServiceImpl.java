package ch.nation.rest.services.impl.playerMoves;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.playerMoves.DBPlayerMovesRestClient;
import ch.nation.rest.clients.playerMoves.DBSkillPlayerMoveRestClient;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillPlayerMoveResourceServiceImpl extends AbstractEntityService<SkillPlayerMoveDto,SkillPlayerMoveDto> {

    public SkillPlayerMoveResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillPlayerMoveDto.class, factory, massRestClientFactory);
    }


    public Optional<List<SkillPlayerMoveDto>> getMovesByGameRuntimeUuidAndCasterUuidAndRound(String gameRuntimeUuid,
                                                                                            String casterUuid,
                                                                                            int round,
                                                                                            QueryProjection projection){

        LOGGER.info("START | Querying moves by runtime round and caster");
        final List<SkillPlayerMoveDto> response = new ArrayList<>();


        Resources<SkillPlayerMoveDto> movesInRoundOfCaster = ((DBSkillPlayerMoveRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuidAndCasterUuidAndRound(gameRuntimeUuid,casterUuid,round,projection);


        if(movesInRoundOfCaster.getContent()==null)  return Optional.of(response);
        LOGGER.info("STOP | Querying moves by runtime round and caster");
        response.addAll(movesInRoundOfCaster.getContent());
        return Optional.of(response);
    }


    public Optional<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeInfo(String gameRuntimeUuid, QueryProjection projection){
        LOGGER.info("START | Querying moves by runtime");
        final List<AbstractPlayerMoveDto> response = new ArrayList<>();
        Resources<SkillPlayerMoveDto> moves = ((DBSkillPlayerMoveRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuid(gameRuntimeUuid,projection);
        if(moves!=null && moves.getContent()!=null) response.addAll(moves.getContent());
        LOGGER.info("STOP | Querying moves by runtime");
        return Optional.of(response);
    }

    public Optional<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeInfoAndUnit(String gameRuntimeUuid,String unitUuid,QueryProjection projection){
        LOGGER.info(String.format("START | Querying moves by runtime and unit | Unit: %s",unitUuid));
        final List<AbstractPlayerMoveDto> response = new ArrayList<>();
        Resources<SkillPlayerMoveDto> moves = ((DBSkillPlayerMoveRestClient) getDefaultClient()).getAllMovesByGameRuntimeUuid(gameRuntimeUuid,projection);
        if(moves!=null && moves.getContent()!=null){
            response.addAll(moves.getContent().stream().filter((x)-> x.getCaster().getId().equals(unitUuid)).collect(Collectors.toUnmodifiableList()));

        }
        LOGGER.info("STOP | Querying moves by runtime");

        LOGGER.info(String.format("STOP | Querying moves by runtime and unit | Unit: %s",unitUuid));

        return Optional.of(response);


    }


    public Optional<List<AbstractPlayerMoveDto>> getMovesByGameRuntimeAndCooldownCounterGraterThan(String gameRuntimeUUId, int counter, QueryProjection projection){
        LOGGER.info("START | Query all moves with skill cooldown greater zero");
        List<AbstractPlayerMoveDto> foundObjects = new ArrayList<>();
        Resources<SkillPlayerMoveDto> moves = ((DBSkillPlayerMoveRestClient) getDefaultClient()).getAllMovesByCounterGreaterThan(gameRuntimeUUId,counter,projection);
        foundObjects.addAll(moves.getContent());
        LOGGER.info("Result Item count "+foundObjects.size());
        LOGGER.info("START | Query all moves with skill cooldown greater zero");
        return Optional.of(foundObjects);

    }
}