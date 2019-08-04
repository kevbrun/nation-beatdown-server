package ch.nation.dbservice.repositories.characteristics;

import ch.nation.dbservice.entities.characteristics.StatCharacteristic;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "characteristics",path = "characteristics-stat")
@Transactional
public interface StatCharacteristicRepository extends IPageableDao<StatCharacteristic> , INamedObjectDao<StatCharacteristic> {
}
