package ch.nation.rest.services.impl.characteristics;

import ch.nation.core.model.dto.characteristics.BaseCharacteristicDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BaseCharacteristicResourceServiceImpl extends AbstractNamedEntityService<BaseCharacteristicDto,BaseCharacteristicDto> implements CharacteristicResourceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public BaseCharacteristicResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BaseCharacteristicDto.class,factory, massRestClientFactory);
    }

}
