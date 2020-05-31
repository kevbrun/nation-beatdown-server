package ch.nation.dbservice.dummyImporter.data.names;

import ch.nation.dbservice.entities.SimpleIdEntity;
import ch.nation.dbservice.entities.names.UnitFirstName;
import ch.nation.dbservice.entities.names.UnitLastName;
import ch.nation.dbservice.repositories.names.UnitFirstNameRepository;
import ch.nation.dbservice.repositories.names.UnitLastNameRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public class NameImporter extends AbstractNamesImporter {

    private final UnitFirstNameRepository firstNameRepository;
    private final UnitLastNameRepository secondNameRepository;

    private final String PATH_TO_FIRST_NAME_CSV = "babies-first-names-2009.csv";
    private final String PATH_TO_SECOND_NAME_CSV = "last-names.csv";


    public NameImporter(UnitFirstNameRepository firstNameRepository, UnitLastNameRepository secondNameRepository) throws Exception {
        this.firstNameRepository = firstNameRepository;
        this.secondNameRepository = secondNameRepository;
        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        super.handleCration();
        importFirstNames();
        importLastNames();
    }

    private void importFirstNames() {
        LOGGER.info("START importing First names");
        importName(UnitFirstName.class, PATH_TO_FIRST_NAME_CSV, firstNameRepository);

        LOGGER.info("STOP importing First names");
    }

    private void importLastNames() {

        LOGGER.info("START importing Last names");
        importName(UnitLastName.class, PATH_TO_SECOND_NAME_CSV, secondNameRepository);
        LOGGER.info("STOP importing last names");
    }

    private <T> void importName(Class<T> clazz, String pathToCsv, CrudRepository repo) {
        List<SimpleIdEntity> names = loadObjectList(clazz, pathToCsv);
        removeIdFromList(names);
        repo.saveAll(names);
    }
}
