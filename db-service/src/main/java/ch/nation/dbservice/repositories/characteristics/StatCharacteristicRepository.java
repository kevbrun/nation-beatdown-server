package ch.nation.dbservice.repositories.characteristics;

import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.characteristics.StatCharacteristic;
import ch.nation.dbservice.entities.characteristics.projection.StatCharacteristicDefaultProjection;
import ch.nation.dbservice.repositories.IFindByIdentifier;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "characteristics",path = "characteristics-stat",excerptProjection = StatCharacteristicDefaultProjection.class)
@Transactional
public interface StatCharacteristicRepository extends IPageableDao<StatCharacteristic> , INamedObjectDao<StatCharacteristic>, IFindByIdentifier<StatCharacteristic> {
}
