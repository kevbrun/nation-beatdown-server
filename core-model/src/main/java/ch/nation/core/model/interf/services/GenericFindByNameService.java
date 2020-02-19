package ch.nation.core.model.interf.services;

import java.util.Optional;

public interface GenericFindByNameService<TResult> {
    public Optional<TResult> findByName(String name);

}
