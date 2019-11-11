package ch.nation.dbservice.repositories.prejudices;

import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.prejudices.SkillPrejudice;
import ch.nation.dbservice.repositories.IFindByIdentifier;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "prejudices",path = "prejudices-skill")
public interface SkillPrejudiceRepository extends IPageableDao<SkillPrejudice>, INamedObjectDao<SkillPrejudice>, IFindByIdentifier<SkillPrejudice> {
}
