package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.NamedEntityBase;
import org.springframework.cache.annotation.Cacheable;

public interface INamedObjectDao<T extends NamedEntityBase> {



    T findByName(String name);

    boolean existsByName(String name);


}
