package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.NationRessource;
import org.springframework.cache.annotation.Cacheable;

public interface IFindByIdentifier<T extends NationRessource> {


    T findByIdentifier(String identifier);
}
