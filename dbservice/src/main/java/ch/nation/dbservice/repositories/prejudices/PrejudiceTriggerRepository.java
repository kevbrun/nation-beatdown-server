package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.prejudices.PrejudiceTrigger;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "prejudices_triggers",path = "triggers")
@Transactional
public interface PrejudiceTriggerRepository extends IPageableDao<PrejudiceTrigger> {
}
