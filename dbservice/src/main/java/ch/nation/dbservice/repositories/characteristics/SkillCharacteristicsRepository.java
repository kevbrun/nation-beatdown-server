package ch.nation.dbservice.repositories.characteristics;

import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "characteristics",path = "characteristics/skill")
public interface SkillCharacteristicsRepository extends IPageableDao<SkillCharacteristic> {
}
