package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.NationRessource;

public interface IFindByIdentifier<T extends NationRessource> {


    T findByIdentifier(String identifier);
}
