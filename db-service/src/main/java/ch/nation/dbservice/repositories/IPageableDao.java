package ch.nation.dbservice.repositories;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

@NoRepositoryBean
public interface IPageableDao<T extends AbstractNationEntityBase> extends PagingAndSortingRepository<T, UUID> {


    T findOneById(UUID id);


    Iterable<T> findAll();


    Iterable<T> findAll(Sort sort);


    Page<T> findAll(Pageable pageable);


}