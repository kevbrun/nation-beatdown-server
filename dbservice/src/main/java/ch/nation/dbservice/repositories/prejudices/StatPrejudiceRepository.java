package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.prejudices.StatPrejudice;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "prejudices",path = "prejudices-stat")
@Transactional
public interface StatPrejudiceRepository extends IPageableDao<StatPrejudice> {
}
