package ch.nation.rest.services.impl.characteristics;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicResourceServiceImpl extends AbstractNamedEntityService<AbstractCharacteristicsDto,AbstractCharacteristicsDto> implements CharacteristicResourceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public CharacteristicResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(AbstractCharacteristicsDto.class,factory, massRestClientFactory);
    }

}
