package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.prejudices.StatPrejudice;
import ch.nation.dbservice.entities.prejudices.projections.MaxStatPrejudiceProjection;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "prejudices",path = "prejudices-stat"/**,excerptProjection = MaxStatPrejudiceProjection.class**/)
@Transactional
public interface StatPrejudiceRepository extends IPageableDao<StatPrejudice>, INamedObjectDao<StatPrejudice> {
}
