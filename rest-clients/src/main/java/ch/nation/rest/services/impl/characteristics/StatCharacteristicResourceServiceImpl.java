package ch.nation.rest.services.impl.characteristics;

import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StatCharacteristicResourceServiceImpl extends AbstractNamedEntityService<StatCharacteristicsDto,StatCharacteristicsDto> implements CharacteristicResourceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public StatCharacteristicResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(StatCharacteristicsDto.class, factory, massRestClientFactory);

    }
}