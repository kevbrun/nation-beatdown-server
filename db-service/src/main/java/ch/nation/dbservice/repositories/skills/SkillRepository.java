package ch.nation.dbservice.repositories.skills;

import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.repositories.IFindByIdentifier;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "skills", path = "skills"/**, excerptProjection = SkillWithEffectsProjection.class**/)
@Transactional
public interface SkillRepository extends IPageableDao<Skill>, INamedObjectDao<Skill>, IFindByIdentifier<Skill> {
}
