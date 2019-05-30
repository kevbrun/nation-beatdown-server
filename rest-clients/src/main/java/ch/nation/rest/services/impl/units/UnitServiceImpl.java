package ch.nation.rest.services.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.units.DBUnitRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends AbstractGenericEntityService<UnitDto,UnitDto> implements UnitService {


    @Autowired
    public UnitServiceImpl(DBUnitRestClient client) {
        super(client);


    }
}
