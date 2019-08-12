package ch.nation.dbservice.repositories.moves;

import ch.nation.dbservice.entities.moves.BasePlayerMove;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface IMoveFind<T> {


    Iterable<T> findAllByGameInfo_IdAndCaster_IdAndRound(@Param("runtime") UUID runtimeUuid, @Param("caster")UUID casterUuid, @Param("round") int round);

    Iterable<T> findAllByCaster_Id(@Param("caster") UUID caster);

    Iterable<T> findAllByRound(@Param("round") int round);

    Iterable<T> findAllByGameInfo_Id(@Param("runtime")UUID runtimeUuid);


}
