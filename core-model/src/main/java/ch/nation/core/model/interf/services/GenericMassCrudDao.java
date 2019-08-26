package ch.nation.core.model.interf.services;

import org.springframework.hateoas.Resource;

import java.util.Collection;
import java.util.Optional;

public interface GenericMassCrudDao <TResultSingle,TInput> {

    Optional<Collection<TResultSingle>> batchUpdate(Collection<TInput> object);
    Optional<Resource<Boolean>> batchDeletion(Collection<TInput> object);
}
