package ch.nation.dbservice.repositories.moves;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface IMoveFind<T> {


    Page<T> findAllByGameInfo_IdAndCaster_IdAndRound(@Param("runtime") UUID runtimeUuid, @Param("caster") UUID casterUuid, @Param("round") int round, Pageable pageable);

    Iterable<T> findAllByCaster_Id(@Param("caster") UUID caster);

    Iterable<T> findAllByRound(@Param("round") int round);

    Page<T> findAllByGameInfo_Id(@Param("runtime") UUID runtimeUuid, Pageable pageable);

    long countAllByGameInfo_Id(@Param("runtime") UUID runtimeUuid);


}
