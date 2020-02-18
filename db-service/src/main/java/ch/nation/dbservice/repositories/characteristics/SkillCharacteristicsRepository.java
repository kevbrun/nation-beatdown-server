package ch.nation.dbservice.repositories.characteristics;

import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.characteristics.projection.SkillCharacteristicDefaultProjection;
import ch.nation.dbservice.repositories.IFindByIdentifier;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "characteristics", path = "characteristics-skill", excerptProjection = SkillCharacteristicDefaultProjection.class)
public interface SkillCharacteristicsRepository extends IPageableDao<SkillCharacteristic>, INamedObjectDao<SkillCharacteristic>, IFindByIdentifier<SkillCharacteristic> {
}
