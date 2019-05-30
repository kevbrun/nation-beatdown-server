package ch.nation.rest.services.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.units.DBUnitRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;

public class UnitServiceImpl extends AbstractGenericEntityService<UnitDto,UnitDto> implements UnitService {


    private final DBRestServiceBaseInterface baseClient;

    public UnitServiceImpl(DBUnitRestClient client) {
        super(client);
        baseClient = client;

    }
}
