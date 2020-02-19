package ch.nation.prejudices.service;

import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class StatPrejudiceResourceServiceImpl extends AbstractNamedEntityService<StatPrejudiceDto, StatPrejudiceDto> {
    public StatPrejudiceResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(StatPrejudiceDto.class, factory, massRestClientFactory);
    }
}
