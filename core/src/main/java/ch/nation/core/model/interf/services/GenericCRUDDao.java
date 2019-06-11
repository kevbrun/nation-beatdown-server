package ch.nation.core.model.interf.services;

import java.util.Collection;
import java.util.Optional;


public interface GenericCRUDDao<TResultSingle,TInput> {

    Optional<Collection<TResultSingle>> getAll();
    Optional<TResultSingle> findById(String uuid);
    Optional<TResultSingle> create(TInput object) throws Exception;
    Optional<Boolean> delete(String uuid);
    Optional<TResultSingle> update(TInput object);




}
