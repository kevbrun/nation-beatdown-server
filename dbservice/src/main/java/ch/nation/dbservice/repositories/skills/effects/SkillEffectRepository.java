package ch.nation.dbservice.repositories.skills.effects;

import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "skill_effects",path = "skill-effects")
@Transactional
public interface SkillEffectRepository extends IPageableDao<SkillEffect> {
}
