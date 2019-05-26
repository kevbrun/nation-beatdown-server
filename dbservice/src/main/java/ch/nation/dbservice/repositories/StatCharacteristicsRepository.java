package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.Characteristics.StatCharacteristics;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface StatCharacteristicsRepository extends PagingAndSortingRepository<StatCharacteristics,UUID> {
}
