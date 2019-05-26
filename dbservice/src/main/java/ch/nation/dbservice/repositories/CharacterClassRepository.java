package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.Clazzes.CharacterClass;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.UUID;


@RepositoryRestResource(collectionResourceRel = "classes",path = "classes")
@Transactional
public interface CharacterClassRepository extends IPageableDao<CharacterClass> {
}
