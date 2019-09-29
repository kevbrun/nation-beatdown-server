package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.prejudices.BasePrejudice;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "prejudices",path = "prejudices")
public interface PrejudiceRepository extends IPageableDao<BasePrejudice>, INamedObjectDao<BasePrejudice> {
}