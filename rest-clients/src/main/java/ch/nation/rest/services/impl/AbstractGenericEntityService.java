package ch.nation.rest.services.impl;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.interf.services.GenericCRUDDao;
import ch.nation.core.model.interf.services.GenericFindByNameService;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.utils.MessageUtils;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

public abstract class AbstractGenericEntityService<TResult,TInput extends NamedObjectAbstractDto>   implements GenericCRUDDao<TResult,TInput>, GenericFindByNameService<TResult> {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    protected final DBRestClientFactory factory;
    protected final DBMassRestClientFactory massRestClientFactory;
    private final  String resourceClassName;


    public AbstractGenericEntityService(Class<?> resourceClass,DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        this.factory = factory;
        this.massRestClientFactory = massRestClientFactory;
        this.resourceClassName = resourceClass.getName();

    }



    protected boolean validateCreateParameter(TInput payload) {
        return payload.isNameValid();

    }


    public String GetResourceName(){

        return resourceClassName;
    }


    private DBRestServiceBaseInterface GetBaseClient(){
        return DBRestClientFactory.getService(GetResourceName());
    }

    protected boolean validateUpdateParameter(TInput payload) {
        return !payload.getId().isBlank();
    }

    private boolean validateDeleteParameter(String uuid) {
        return !uuid.isBlank() && validateUuid(uuid);
    }


    @Override
    public Optional<Collection<TResult>> getAll() {
        LOGGER.info(String.format("START | Get ALL | Used client %s", GetBaseClient().getClass().getName()));

        Collection<TResult> resultsFromDB = GetBaseClient().getAll().getContent();
        ArrayList<TResult> responseList = new ArrayList<>(resultsFromDB);

        if (responseList.size() > 0) {
            LOGGER.info(String.format("Found %d entries", responseList.size()));
            return Optional.of(responseList);
        }
        LOGGER.info(String.format("FINISH | Getting ALL entities | Used client %s", GetBaseClient().getClass().getName()));

        return Optional.empty();
    }


    @Override
    public Optional<TResult> findById(String uuid) {
        LOGGER.info(String.format("START | Find By Id | uuid : %s", uuid));
        if (!validateUuid(uuid))
            throw new IllegalArgumentException(String.format("Provided parameter %s is not valid!", uuid));
        TResult response = (TResult) GetBaseClient().findById(uuid).getContent();

        if (response == null) {

            LOGGER.info(String.format("Nothing found | uuid: %s!", uuid));
            return Optional.empty();
        }
        LOGGER.info("Found entry: %s", response.toString());
        LOGGER.info(String.format("FINISH | Find By Id | uuid : %s", uuid));

        return Optional.of(response);
    }

    @Override
    public Optional<TResult> findByName(String name) {
        LOGGER.info(String.format("START | Find By Name | name : %s", name));
        if(name==null ||name.isBlank()) throw new IllegalArgumentException(String.format("Provided parameter %s is not valid!", name));
        TResult response = (TResult) GetBaseClient().findByName(name).getContent();

        if (response == null) {

            LOGGER.info(String.format("Nothing found | name: %s!", name));
            return Optional.empty();
        }


        LOGGER.info("Found entry: %s", response.toString());
        LOGGER.info(String.format("STOP | Find By Name | name : %s", name));
        return Optional.of(response);
    }

    @Override
    public Optional<TResult> create(TInput object) throws Exception {
        LOGGER.info(String.format("Creating entity in db | Payload: %s", object.toString()));
        if (!validateCreateParameter(object))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", object.toString()));


        TResult result = (TResult) getBindedClient(object).create(object).getContent();

        if (result == null) {
            LOGGER.info(String.format("Could not create | payload: %s!", object.toString()));
            throw new Exception("Internal error");
        }
        return Optional.of(result);
    }


    @Override
    public Optional<TResult> update(TInput object) {
        LOGGER.info(String.format("START | Updating entity in db | Payload: %s", object.toString()));
        if (!validateUpdateParameter(object))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", object.toString()));
        TResult result = (TResult) getBindedClient(object).update(object.getId(), object).getContent();
        if (result == null) {
            LOGGER.info(String.format("Could not update % entity", object.toString()));
            return Optional.empty();
        }
        LOGGER.info(String.format("FINISH | Updating entity | Payload %s", object.toString()));
        return Optional.of(result);
    }

    @Override
    public Optional<Boolean> delete(String uuid) {
        LOGGER.info(String.format("START | Deleting entity | Payload: %s", uuid));
        boolean deletionWasSuccesfull = false;

        if (!validateDeleteParameter(uuid))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", uuid));

        ResponseEntity<?> result = GetBaseClient().delete(uuid);

        if(result.getStatusCode().is2xxSuccessful()){
            deletionWasSuccesfull = true;
        }


        if (result == null) {
            LOGGER.info(String.format("Could not delete % entity", uuid.toString()));
            return Optional.empty();
        }


        LOGGER.info(String.format("FINISH | Deleting entity | Payload: %s", uuid.toString()));

        return Optional.of(deletionWasSuccesfull);
    }


    public Optional<TResult> createAssociation(String uuid,List<AbstractDto> children) throws Exception {

        Resource<TResult> resultEntity = null;
        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid,children.getClass().getName()));
        if (!validateDeleteParameter(uuid))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", uuid));

        Resource<TResult> parent= GetBaseClient().findById(uuid);

        if(parent.getContent()==null) throw new Exception("Could not find parent entity with uuid:"+uuid);



        for(AbstractDto child : children) {
            Resource<AbstractDto> childObject = (Resource<AbstractDto>) getBindedClient(child).findById(child.getId());

            if (childObject.getContent() == null) throw new Exception("Could not find child node!");


            boolean result = createSingleAssociation((Resource<AbstractDto>) parent, childObject);

            LOGGER.info("Status for creation: "+result);


        }


        resultEntity =  GetBaseClient().findById(uuid);

        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid,children.getClass().getName()));

        return Optional.of(resultEntity.getContent());
    }


    public Optional<?> getChildrenEntites(String uuid, String resource){
        Resources<?> results =null;
        LOGGER.info(String.format("START | Try to find all children | Parent: %s | Child Resource Type: %s", uuid,resource));
        if(!validateUuid(uuid) && resource==null && resource.isEmpty()) throw new IllegalArgumentException("Uuid or resource type is null!");

         results = getDefaultClient().getChildrenEntities(uuid,resource);


         LOGGER.info("Found entries: "+results.getContent().size());

        LOGGER.info(String.format("START | Try to find all children | Parent: %s | Child Resource Type: %s", uuid,resource));

        return Optional.of(results.getContent());
    }


    protected boolean createSingleAssociation(Resource<AbstractDto>  parentObject, Resource<AbstractDto> child) throws ExecutionControl.NotImplementedException {


     boolean wasCreated = false;
        if(parentObject.getContent()!=null && child.getContent()!=null){



            parentObject.add(child.getId());
            String childrenURl = child.getId().getHref();
            ResponseEntity<Resource<TResult>> updatedParent = getBindedClient(parentObject.getContent()).createAssocations(parentObject.getContent().getId(),child.getContent().ResourceCollectionName(),childrenURl);


            if(updatedParent.getStatusCode()!= HttpStatus.NO_CONTENT){
                LOGGER.error("Could not update associations");
            }else{
                wasCreated = true;
            }






        }else{
            LOGGER.info("Could not create relationship. The parent or child is null");
        }




        return wasCreated;
    }


    protected boolean validateUuid(String uuid) {
        try {
            UUID.fromString(uuid);
        } catch (IllegalArgumentException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return false;
        }
        return true;
    }




    protected DBRestServiceBaseInterface<TResult,TInput> getBindedClient(AbstractDto object){

       DBRestServiceBaseInterface client=  DBRestClientFactory.getService(object.getClass().getName());
        LOGGER.info(MessageUtils.getSelectedRestClientMessage(client));
       return client;
    }

    protected DBRestServiceBaseInterface<TResult,TInput> getDefaultClient(){
        DBRestServiceBaseInterface client = DBRestClientFactory.getService(GetResourceName());
        LOGGER.info(MessageUtils.getSelectedRestClientMessage(client));
        return client;
    }

}
