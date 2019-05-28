package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.prejudices.StatPrejudiceTrigger;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "stat_prejudices_triggers",path = "triggers/stat")
@Transactional
public interface StatPrejudiceTriggerRepository extends IPageableDao<StatPrejudiceTrigger> {
}
