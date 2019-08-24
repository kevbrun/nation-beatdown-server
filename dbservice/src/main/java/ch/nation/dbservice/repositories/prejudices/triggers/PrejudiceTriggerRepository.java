package ch.nation.dbservice.repositories.prejudices.triggers;

import ch.nation.dbservice.entities.prejudices.triggers.BasePrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.StatPrejudiceTrigger;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "prejudices_triggers",path = "triggers")
@Transactional
public interface PrejudiceTriggerRepository extends IPageableDao<BasePrejudiceTrigger>  , INamedObjectDao<StatPrejudiceTrigger> {
}
