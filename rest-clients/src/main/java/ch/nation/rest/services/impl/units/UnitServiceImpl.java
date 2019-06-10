package ch.nation.rest.services.impl.units;

import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.rest.clients.units.DBMassRestUnitRestClient;
import ch.nation.rest.clients.units.DBRestUnitRestClient;
import ch.nation.rest.services.impl.AbstractMassGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends AbstractMassGenericEntityService<UnitDto,UnitDto> implements UnitService {


    @Autowired
    public UnitServiceImpl(DBRestUnitRestClient client, DBMassRestUnitRestClient massClient) {
        super(client, massClient);

    }


}
