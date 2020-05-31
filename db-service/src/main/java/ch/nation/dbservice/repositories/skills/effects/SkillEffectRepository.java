package ch.nation.dbservice.repositories.skills.effects;

import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.IFindByIdentifier;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "skill-effects", path = "skill-effects")
@Transactional
public interface SkillEffectRepository extends IPageableDao<SkillEffect>, INamedObjectDao<SkillEffect>, IFindByIdentifier<SkillEffect> {
}
