package ch.nation.dbservice.controller;

import ch.nation.core.model.dto.names.UnitCompleteNameDto;
import ch.nation.core.model.dto.names.UnitFirstNameDto;
import ch.nation.core.model.dto.names.UnitLastNameDto;
import ch.nation.dbservice.entities.names.UnitFirstName;
import ch.nation.dbservice.entities.names.UnitLastName;
import ch.nation.dbservice.repositories.names.UnitFirstNameRepository;
import ch.nation.dbservice.repositories.names.UnitLastNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@RestController()
@RequestMapping(value = "/name-builder")
public class UnitNameController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final UnitLastNameRepository lastNameRepository;
    private final UnitFirstNameRepository firstNameRepository;

    @Autowired
    public UnitNameController(final UnitLastNameRepository lastNameRepository, final UnitFirstNameRepository firstNameRepository) {
        this.lastNameRepository = lastNameRepository;
        this.firstNameRepository = firstNameRepository;
    }

    @RequestMapping(path = "/first-name/random", method = RequestMethod.GET, produces = "application/json")
    public UnitFirstNameDto getRandomFirstName() {
        LOGGER.info("START Generating random name");
        long tableSize = firstNameRepository.count();
        long generatedLong = calculateRandomIndex(tableSize);
        LOGGER.debug("Random value" + generatedLong);
        LOGGER.info("STOP Generating random name");
        Optional<UnitFirstName> response = firstNameRepository.findById(generatedLong);
        LOGGER.debug("Found random name " + response.get().getFirstName());
        if (response.isEmpty()) return getRandomFirstName();
        return new UnitFirstNameDto(response.get().getFirstName(), response.get().getSex());
    }


    @RequestMapping(path = "/last-name/random", method = RequestMethod.GET, produces = "application/json")
    public UnitLastNameDto getRandomLastName() {
        LOGGER.info("START Generating random name");
        long tableSize = lastNameRepository.count();
        long generatedLong = calculateRandomIndex(tableSize);
        LOGGER.debug("Random value" + generatedLong);
        LOGGER.info("STOP Generating random name");
        Optional<UnitLastName> response = lastNameRepository.findById(generatedLong);
        LOGGER.debug("Found random name " + response.get().getSecondName());
        if (response.isEmpty()) return getRandomLastName();
        return new UnitLastNameDto(response.get().getSecondName());
    }

    @RequestMapping(path = "/full-name/random", method = RequestMethod.GET, produces = "application/json")
    public UnitCompleteNameDto getRandomFullName() {
        LOGGER.info("START Generating random full name");

        final UnitFirstNameDto firstName = getRandomFirstName();
        final UnitLastNameDto lastName = getRandomLastName();
        LOGGER.info(String.format("Created Name| First name: %s | Last name: %s | Sex: %s", firstName.getFirstName(),
                lastName.getLastName(), firstName.getSex()));
        LOGGER.info("START Generating random full name");
        return new UnitCompleteNameDto(firstName, lastName);
    }


    private long calculateRandomIndex(long tableSize) {
        long leftLimit = 1L;
        long rightLimit = tableSize;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }


}
