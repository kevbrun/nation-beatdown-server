package ch.nation.dbservice.repositories.skills;

import ch.nation.dbservice.entities.skills.TimeReversalSkillEffect;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "time_skill",path = "skills/effect/time")
@Transactional
public interface TimeReversalSkillEffectRepository extends IPageableDao<TimeReversalSkillEffect> {
}
