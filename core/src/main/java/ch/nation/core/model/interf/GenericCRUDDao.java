package ch.nation.core.model.interf;

import java.util.Optional;


public interface GenericCRUDDao<TResultSingle,TResultMultiple,TInput> {

    Optional<TResultMultiple> getAll();
    Optional<TResultSingle> findById(String uuid);
    Optional<TResultSingle> create(TInput object) throws Exception;
    Optional<TResultSingle> delete(String uuid);
    Optional<TResultSingle> update(TInput object);




}
