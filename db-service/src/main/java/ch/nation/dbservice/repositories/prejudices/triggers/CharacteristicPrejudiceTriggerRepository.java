package ch.nation.dbservice.repositories.prejudices.triggers;

import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.StatPrejudiceTrigger;
import ch.nation.dbservice.entities.prejudices.triggers.projection.MaxCharacteristicPrejudiceTriggerProjection;
import ch.nation.dbservice.repositories.IFindByIdentifier;
import ch.nation.dbservice.repositories.INamedObjectDao;
import ch.nation.dbservice.repositories.IPageableDao;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "prejudices_triggers", path = "triggers-char"/**,excerptProjection = MaxCharacteristicPrejudiceTriggerProjection.class**/)
@Transactional
public interface CharacteristicPrejudiceTriggerRepository extends IPageableDao<CharacteristicPrejudiceTrigger>, INamedObjectDao<CharacteristicPrejudiceTrigger>, IFindByIdentifier<CharacteristicPrejudiceTrigger> {
}
