package ch.nation.dbservice.dummyImporter.data.names;

import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.names.UnitFirstName;
import ch.nation.dbservice.entities.names.UnitLastName;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.Collections;
import java.util.List;

public abstract class AbstractNamesImporter<T> extends AbstractDummyGenerator<T> {


    public AbstractNamesImporter() throws Exception {
    }

    @Override
    protected void handleCration() throws Exception {

    }

    public void removeIdFromList(List<T> list) {

        for (int idx = 0; idx < list.size(); idx++) {
            T item = list.get(idx);

            if (item instanceof UnitFirstName) {
                ((UnitFirstName) item).setId(null);
            }

            if (item instanceof UnitLastName) {
                ((UnitLastName) item).setId(null);
            }
        }


    }


    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            LOGGER.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}
