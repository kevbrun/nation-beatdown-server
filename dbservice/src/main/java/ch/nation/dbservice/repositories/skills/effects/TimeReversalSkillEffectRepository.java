package ch.nation.dbservice.repositories.skills.effects;

import ch.nation.dbservice.entities.skills.effects.TimeReversalSkillEffect;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "skill_effects",path = "skill-time-effects")
@Transactional
public interface TimeReversalSkillEffectRepository extends IPageableDao<TimeReversalSkillEffect>, INamedObjectDao<TimeReversalSkillEffect> {
}
