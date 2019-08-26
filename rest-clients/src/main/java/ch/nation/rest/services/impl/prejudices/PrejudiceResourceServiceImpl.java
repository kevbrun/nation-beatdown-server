package ch.nation.rest.services.impl.prejudices;

import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import ch.nation.core.model.dto.prejudices.BasePrejudiceDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrejudiceResourceServiceImpl extends AbstractNamedEntityService<AbstractPrejudiceDto,AbstractPrejudiceDto> implements PrejudiceResourceService {


    @Autowired
    public PrejudiceResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(BasePrejudiceDto.class,factory, massRestClientFactory);
    }


}
