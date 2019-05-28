package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.prejudices.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "prejudices_triggers",path = "triggers/char")
@Transactional
public interface CharacteristicPrejudiceTriggerRepository extends IPageableDao<CharacteristicPrejudiceTrigger> {
}
