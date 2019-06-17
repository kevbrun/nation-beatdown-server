package ch.nation.dbservice.repositories.characteristics;

import ch.nation.dbservice.entities.characteristics.Characteristic;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "characteristics",path = "characteristics")
@Transactional
public interface CharacteristicsRepository extends IPageableDao<Characteristic>,INamedObjectDao<Characteristic> {
        }
//http://blog.netgloo.com/2014/12/18/handling-entities-inheritance-with-spring-data-jpa/