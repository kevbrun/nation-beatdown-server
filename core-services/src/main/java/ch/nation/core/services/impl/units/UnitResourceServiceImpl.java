package ch.nation.core.services.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractMassNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitResourceServiceImpl extends AbstractMassNamedEntityService<UnitDto,UnitDto> implements UnitResourceService {


    @Autowired
    public UnitResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(UnitDto.class,factory, massRestClientFactory);
    }
}
