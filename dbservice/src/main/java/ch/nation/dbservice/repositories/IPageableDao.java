package ch.nation.dbservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface IPageableDao<T> extends Repository<T, Long> {
    T findOne(Long id);
    Iterable<T> findAll();
    Iterable<T> findAll(Sort sort);
    Page<T> findAll(Pageable pageable);
}