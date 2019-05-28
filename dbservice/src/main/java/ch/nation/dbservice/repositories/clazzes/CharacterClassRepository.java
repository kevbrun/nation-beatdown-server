package ch.nation.dbservice.repositories.clazzes;

import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;


@RepositoryRestResource(collectionResourceRel = "classes",path = "classes")
@Transactional
public interface CharacterClassRepository extends IPageableDao<CharacterClass> {
}
