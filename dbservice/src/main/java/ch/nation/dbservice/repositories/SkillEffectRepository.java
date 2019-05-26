package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.Skills.SkillEffect;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.UUID;
@RepositoryRestResource(collectionResourceRel = "skill_effects",path = "skill_effects")
@Transactional
public interface SkillEffectRepository extends IPageableDao<SkillEffect> {
}
