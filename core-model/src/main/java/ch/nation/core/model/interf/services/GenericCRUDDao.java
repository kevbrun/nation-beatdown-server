package ch.nation.core.model.interf.services;

import ch.nation.core.model.dtoWrapper.SimpleResourceDto;

import java.util.Optional;


public interface GenericCRUDDao<TResultSingle, TInput> {

    Optional<SimpleResourceDto> getAll();

    Optional<TResultSingle> findById(String uuid);

    Optional<TResultSingle> create(TInput object) throws Exception;

    Optional<Boolean> delete(String uuid);

    Optional<TResultSingle> updatePatch(TInput object);

    Optional<TResultSingle> updatePut(TInput object);


}


