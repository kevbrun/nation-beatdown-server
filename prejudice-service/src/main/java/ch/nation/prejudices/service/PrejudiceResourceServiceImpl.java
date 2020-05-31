package ch.nation.prejudices.service;

import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import ch.nation.core.model.dto.prejudices.BasePrejudiceDto;
import ch.nation.core.services.AbstractNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrejudiceResourceServiceImpl extends AbstractNamedEntityService<AbstractPrejudiceDto, AbstractPrejudiceDto> implements PrejudiceResourceService {


    @Autowired
    public PrejudiceResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePrejudiceDto.class, factory, massRestClientFactory);
    }


}
