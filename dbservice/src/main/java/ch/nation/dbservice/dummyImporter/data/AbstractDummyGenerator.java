package ch.nation.dbservice.dummyImporter.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDummyGenerator<TData> implements IDummyGenerator<TData> {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected ArrayList<TData> entities;

    public AbstractDummyGenerator() throws Exception {
        entities = new ArrayList<>();
        

    }


    abstract protected void handleCration() throws Exception;


    @Override
    public void persistData() {
        LOGGER.info("SKIP PERSISTANCE FUNCTION. CAUSE IT IS ClASS WITH RELATIONS. IT WAS PERSISTET DURING CRAEATION");
    }

    @Override
    public List<TData> createdEntities() {
        return entities;
    }
}
