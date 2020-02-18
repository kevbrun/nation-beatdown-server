package ch.nation.dbservice.repositories;

import ch.nation.dbservice.converter.UuidConverter;
import ch.nation.dbservice.entities.AbstractNationEntityBase;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@NoRepositoryBean
public interface IPageableDao<T extends AbstractNationEntityBase> extends PagingAndSortingRepository<T, UUID> {

    @Cacheable
    T findOneById(UUID id);

    @Cacheable
    Iterable<T> findAll();

    @Cacheable
    Iterable<T> findAll(Sort sort);

    @Cacheable
    Page<T> findAll(Pageable pageable);


}