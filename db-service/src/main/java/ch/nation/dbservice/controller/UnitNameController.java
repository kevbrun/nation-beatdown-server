package ch.nation.dbservice.controller;

import ch.nation.core.model.dto.names.UnitFirstNameDto;
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
@RequestMapping(value="/name-builder")
public class UnitNameController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final UnitLastNameRepository lastNameRepository;
    private final UnitFirstNameRepository firstNameRepository;

    @Autowired
    public UnitNameController(final UnitLastNameRepository lastNameRepository, final UnitFirstNameRepository firstNameRepository) {
        this.lastNameRepository = lastNameRepository;
        this.firstNameRepository = firstNameRepository;
    }

    @RequestMapping(path = "/first-name/random",method = RequestMethod.GET,produces ="application/json")
    public Optional<UnitFirstName> getRandomFirstName(){
        LOGGER.info("START Generating random name");
        long tableSize = firstNameRepository.count();
        long generatedLong = calculateRandomIndex(tableSize);
        LOGGER.debug("Random value"+generatedLong);
        LOGGER.info("STOP Generating random name");
        Optional<UnitFirstName> response = firstNameRepository.findById(generatedLong);
        LOGGER.debug("Found random name "+response.get().getFirstName());
        return response;
    }



    @RequestMapping(path = "/last-name/random",method = RequestMethod.GET,produces ="application/json")
    public Optional<UnitLastName> getRandomLastName(){
        LOGGER.info("START Generating random name");
        long tableSize = lastNameRepository.count();
        long generatedLong = calculateRandomIndex(tableSize);
        LOGGER.debug("Random value"+generatedLong);
        LOGGER.info("STOP Generating random name");
        Optional<UnitLastName> response = lastNameRepository.findById(generatedLong);
        LOGGER.debug("Found random name "+response.get().getSecondName());
        return response;
    }


    private long calculateRandomIndex(long tableSize) {
        long leftLimit = 1L;
        long rightLimit = tableSize;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }


}
