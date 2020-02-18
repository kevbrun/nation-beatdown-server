package ch.nation.units.services;

import ch.nation.core.clients.db.names.DBNameBuilderRestClient;
import ch.nation.core.clients.db.names.DBUnitFirstNameRestClient;
import ch.nation.core.clients.db.names.DBUnitLastNameRestClient;
import ch.nation.core.model.dto.names.UnitCompleteNameDto;
import ch.nation.core.model.dto.names.UnitFirstNameDto;
import ch.nation.core.model.dto.names.UnitLastNameDto;
import ch.nation.core.model.dto.unit.UnitDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractMassNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitResourceServiceImpl extends AbstractMassNamedEntityService<UnitDto, UnitDto> implements UnitResourceService {

    private final DBUnitFirstNameRestClient firstNameRestClient;
    private final DBUnitLastNameRestClient lastNameRestClient;
    private final DBNameBuilderRestClient nameRestClient;


    @Autowired
    public UnitResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, DBUnitFirstNameRestClient firstNameRestClient, DBUnitLastNameRestClient lastNameRestClient, DBNameBuilderRestClient nameRestClient) {
        super(UnitDto.class, factory, massRestClientFactory);
        this.firstNameRestClient = firstNameRestClient;
        this.lastNameRestClient = lastNameRestClient;
        this.nameRestClient = nameRestClient;
    }


    public ResponseEntity<UnitFirstNameDto> getRandomFirstName() {
        UnitFirstNameDto firstName = createFirstName();
        return ResponseEntity.ok(firstName);
    }

    private UnitFirstNameDto createFirstName() {
        LOGGER.info("Get Random First name");
        UnitFirstNameDto firstName = nameRestClient.getRandomFirstName();
        LOGGER.info("Got name " + firstName);
        return firstName;
    }

    public ResponseEntity<UnitLastNameDto> getRandomLastName() {
        UnitLastNameDto lastName = createRandomLastName();
        return ResponseEntity.ok(lastName);
    }

    private UnitLastNameDto createRandomLastName() {
        LOGGER.info("Get Random last name");
        UnitLastNameDto lastName = nameRestClient.getRandomLastName();
        LOGGER.info("Got name " + lastName);
        return lastName;
    }

    public ResponseEntity<UnitCompleteNameDto> getRandomFullName() {
        UnitCompleteNameDto fullname = createRandomFullName();
        return ResponseEntity.ok(fullname);
    }

    private UnitCompleteNameDto createRandomFullName() {
        LOGGER.info("Get Random full name");
        UnitCompleteNameDto fullname = nameRestClient.getRandomFullName();
        LOGGER.info("Got name " + fullname);
        return fullname;
    }

    public ResponseEntity<List<UnitCompleteNameDto>> getRandomFullNames(int countOfNamesToCreate) {

        LOGGER.info(String.format("START|Create a list of full names | Count: %d", countOfNamesToCreate));
        final List<UnitCompleteNameDto> names = new ArrayList<>(countOfNamesToCreate);
        if (countOfNamesToCreate <= 0) countOfNamesToCreate = 1;

        for (int idx = 0; idx < countOfNamesToCreate; idx++) {
            names.add(createRandomFullName());

            if (LOGGER.isDebugEnabled()) LOGGER.debug(String.format("Created Name %s", names.get(idx)));
        }


        LOGGER.info(String.format("FINISH|Create a list of full names | Count: %d", countOfNamesToCreate));
        return ResponseEntity.ok(names);
    }


}
