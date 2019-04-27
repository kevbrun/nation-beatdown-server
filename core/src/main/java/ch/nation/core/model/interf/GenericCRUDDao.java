package ch.nation.core.model.interf;

import java.util.List;
import java.util.Optional;


public interface GenericCRUDDao<TResultSingle,TResultMultiple,TInput> {

    Optional<TResultMultiple> getAll();
    Optional<TResultSingle> findById(String uuid);
    Optional<TResultSingle> create(TInput object) throws Exception;
    Optional<TResultSingle> delete(TInput object);
    Optional<TResultSingle> update(TInput object);




}
