package ch.nation.rest.services.impl.characteristics;

import ch.nation.core.model.dto.characteristics.SkillCharacteristicsDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class SkillCharacteristicResourceServiceImpl extends AbstractNamedEntityService<SkillCharacteristicsDto,SkillCharacteristicsDto> {


    public SkillCharacteristicResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillCharacteristicsDto.class, factory, massRestClientFactory);
    }
}
