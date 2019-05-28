package ch.nation.rest.services.impl;

import ch.nation.core.model.dto.AbstractNationDto;
import ch.nation.core.model.interf.GenericCRUDDao;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractGenericEntityService<TResult,TInput extends AbstractNationDto>   implements GenericCRUDDao<TResult,ArrayList<TResult>,TInput> {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());



    private final DBRestServiceBaseInterface client;



    public AbstractGenericEntityService(DBRestServiceBaseInterface client) {
        this.client = client;
    }

    public DBRestServiceBaseInterface getClient() {
        return client;
    }


    protected  boolean validateCreateParameter(TInput payload){
        return payload.isNameValid();

    }
    protected boolean validateUpdateParameter(TInput payload){
        return !payload.getId().isBlank();
    }
    private boolean validateDeleteParameter(String uuid){
        return !uuid.isBlank() && validateUuid(uuid);
    }


    @Override
    public Optional<ArrayList<TResult>> getAll() {
        LOGGER.info(String.format("START | Get ALL | Used client %s",client.getClass().getName()));

        Collection<TResult>  resultsFromDB = client.getAll().getContent();
        ArrayList<TResult> responseList = new ArrayList<>(resultsFromDB);

        if(responseList.size()>0){
            LOGGER.info(String.format("Found %d entries",responseList.size()));
            return Optional.of(responseList);
        }
        LOGGER.info(String.format("FINISH | Getting ALL entities | Used client %s",client.getClass().getName()));

        return Optional.empty();
    }


    @Override
    public Optional<TResult> findById(String uuid) {
        LOGGER.info(String.format("START | Find By Id | uuid : %s",uuid));
        if(!validateUuid(uuid)) throw new IllegalArgumentException(String.format("Provided parameter %s is not valid!",uuid));
        TResult response = (TResult) client.findById(uuid).getContent();

        if(response==null) {

            LOGGER.info(String.format("Nothing found | uuid: %s!",uuid));
            return Optional.empty();
        }
        LOGGER.info("Found entry: %s",response.toString());
        LOGGER.info(String.format("FINISH | Find By Id | uuid : %s",uuid));

        return Optional.of(response);
    }

    @Override
    public Optional<TResult> create(TInput object) throws Exception {
        LOGGER.info(String.format("Creating entity in db | Payload: %s",object.toString()));
        if(!validateCreateParameter(object)) throw new IllegalArgumentException(String.format("Payload %s is not valid",object.toString()));


        TResult result = (TResult) client.create(object).getContent();

        if(result==null){
            LOGGER.info(String.format("Could not create | payload: %s!",object.toString()));
            throw new Exception("Internal error");
        }
        return Optional.of(result);
    }


    @Override
    public Optional<TResult> update(TInput object) {
        LOGGER.info(String.format("START | Updating entity in db | Payload: %s",object.toString()));
        if(!validateUpdateParameter(object)) throw new IllegalArgumentException(String.format("Payload %s is not valid",object.toString()));
        TResult result = (TResult) client.update(object.getId(),object).getContent();
        if(result==null){
            LOGGER.info(String.format("Could not update % entity",object.toString()));
            return Optional.empty();
        }
        LOGGER.info(String.format("FINISH | Updating entity | Payload %s",object.toString()));
        return Optional.of(result);
    }

    @Override
    public Optional<TResult> delete(String uuid) {
        LOGGER.info(String.format("START | Deleting entity | Payload: %s",uuid));
        if(!validateDeleteParameter(uuid)) throw new IllegalArgumentException(String.format("Payload %s is not valid",uuid));

        TResult result = (TResult) client.delete(uuid).getContent();
        if(result == null){
            LOGGER.info(String.format("Could not delete % entity",uuid.toString()));
            return Optional.empty();
        }


        LOGGER.info(String.format("FINISH | Deleting entity | Payload: %s",uuid.toString()));

        return Optional.of(result);
    }

    protected boolean validateUuid(String uuid){
        try {
            UUID.fromString(uuid);
        }catch (IllegalArgumentException ex){
            LOGGER.error(ex.getMessage(),ex);
            return false;
        }
        return true;
    }
}
