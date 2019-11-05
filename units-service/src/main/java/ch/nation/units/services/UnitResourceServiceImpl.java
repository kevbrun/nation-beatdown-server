package ch.nation.units.services;

import ch.nation.core.clients.db.names.DBUnitFirstNameRestClient;
import ch.nation.core.clients.db.names.DBUnitLastNameRestClient;
import ch.nation.core.model.dto.names.UnitFirstNameDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractMassNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitResourceServiceImpl extends AbstractMassNamedEntityService<UnitDto,UnitDto> implements UnitResourceService {

    private final DBUnitFirstNameRestClient firstNameRestClient;
    private final DBUnitLastNameRestClient lastNameRestClient;


    @Autowired
    public UnitResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, DBUnitFirstNameRestClient firstNameRestClient, DBUnitLastNameRestClient lastNameRestClient) {
        super(UnitDto.class,factory, massRestClientFactory);
        this.firstNameRestClient = firstNameRestClient;
        this.lastNameRestClient = lastNameRestClient;
    }


    public UnitFirstNameDto getRandomFirstName(){




        return null;
    }


}
