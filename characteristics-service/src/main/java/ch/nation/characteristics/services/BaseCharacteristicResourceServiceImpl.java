package ch.nation.characteristics.services;

import ch.nation.core.model.dto.characteristics.BaseCharacteristicDto;


import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractNamedEntityService;
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
