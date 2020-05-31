package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.NamedEntityBase;

public interface INamedObjectDao<T extends NamedEntityBase> {


    T findByName(String name);

    boolean existsByName(String name);


}
