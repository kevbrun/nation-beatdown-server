package ch.nation.dbservice.repositories.moves;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@RepositoryRestResource(collectionResourceRel = "moves",path = "moves")
public interface PlayerMoveRepository extends IPageableDao<BasePlayerMove> {

    Iterable<BasePlayerMove> findAllByGameInfo_IdAndCaster_IdAndRound(@Param("runtime")UUID runtimeUuid,@Param("caster")UUID casterUuid, @Param("round") int round);

    Iterable<BasePlayerMove> findAllByCaster_Id(@Param("caster") UUID caster);

    Iterable<BasePlayerMove> findAllByRound(@Param("round") int round);

    Iterable<BasePlayerMove> findAllByGameInfo_Id(@Param("runtime")UUID runtimeUuid);



}
