package ch.nation.core.model.interf.services;

import ch.nation.core.model.Enums.QueryProjection;

import java.util.Collection;
import java.util.Optional;

public interface GenericCRUDQueryable<TResultSingle, TInput> {
    Optional<Collection<TResultSingle>> getAll(QueryProjection queryProjection);

    Optional<TResultSingle> findById(String uuid, QueryProjection queryProjection);

    Optional<TResultSingle> create(TInput object, QueryProjection queryProjection) throws Exception;

    Optional<Boolean> delete(String uuid, QueryProjection queryProjection);

    Optional<TResultSingle> update(TInput object, QueryProjection queryProjection);

}
