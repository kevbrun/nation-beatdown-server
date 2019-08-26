package ch.nation.rest.services.impl.prejudices;

import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class StatPrejudiceResourceServiceImpl extends AbstractNamedEntityService<StatPrejudiceDto,StatPrejudiceDto> {
    public StatPrejudiceResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(StatPrejudiceDto.class, factory, massRestClientFactory);
    }
}
