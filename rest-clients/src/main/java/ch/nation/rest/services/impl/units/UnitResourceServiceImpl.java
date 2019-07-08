package ch.nation.rest.services.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractMassNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitResourceServiceImpl extends AbstractMassNamedEntityService<UnitDto,UnitDto> implements UnitResourceService {


    @Autowired
    public UnitResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(UnitDto.class,factory, massRestClientFactory);
    }
}
