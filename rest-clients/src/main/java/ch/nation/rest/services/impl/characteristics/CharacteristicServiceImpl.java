package ch.nation.rest.services.impl.characteristics;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.core.model.dto.characteristics.SkillCharacteristicsDto;
import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.characteristics.DBBaseCharacteristicRestClient;
import ch.nation.rest.clients.characteristics.DBSkillCharacteristicRestClient;
import ch.nation.rest.clients.characteristics.DBStatCharacteristicRestClient;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import ch.nation.rest.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicServiceImpl extends AbstractGenericEntityService<AbstractCharacteristicsDto,AbstractCharacteristicsDto> implements CharacteristicService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public CharacteristicServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(AbstractCharacteristicsDto.class,factory, massRestClientFactory);
    }

}
