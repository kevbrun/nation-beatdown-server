package ch.nation.core.model.interf;


import java.util.List;
import java.util.Optional;

public interface CRUDDao<T> {

    Optional<List<T>> getAll();
    Optional<T> findById(String uuid);
    Optional<T> create(T object);
    Optional<T> delete(T object);

    Optional<T> update(T object);



}
