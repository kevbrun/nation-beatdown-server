package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.Characteristics.Characteristics;
import ch.nation.dbservice.entities.Clazzes.CharacterClass;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

//@RepositoryRestResource(collectionResourceRel = "characteristics",path = "characteristics")
public interface CharacteristicsRepository extends PagingAndSortingRepository<Characteristics,UUID> {
}
//http://blog.netgloo.com/2014/12/18/handling-entities-inheritance-with-spring-data-jpa/