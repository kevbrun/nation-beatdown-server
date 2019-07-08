package ch.nation.rest.services.impl;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.interf.services.GenericCRUDDao;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class AbstractEntityService<TResult, TInput extends AbstractDto> implements GenericCRUDDao<TResult, TInput> {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    protected final DBRestClientFactory factory;
    protected final DBMassRestClientFactory massRestClientFactory;
    private final String resourceClassName;



    public AbstractEntityService(Class<?> resourceClass,DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {

        this.factory = factory;
        this.massRestClientFactory = massRestClientFactory;
        this.resourceClassName = resourceClass.getName();
    }

    protected boolean validateCreateParameter(TInput payload) {
        return true;

    }

    public String GetResourceName(){


        return resourceClassName;
    }


    protected DBRestServiceBaseInterface GetBaseClient() {
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

        return getAll(QueryProjection.def);

    }

    public Optional<Collection<TResult>> getAll(QueryProjection queryProjection) {
        LOGGER.info(String.format("START | Get ALL | Used client %s", GetBaseClient().getClass().getName()));

        Collection<TResult> resultsFromDB = GetBaseClient().getAll(queryProjection).getContent();
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
        return findById(uuid, QueryProjection.def);
    }

    public Optional<TResult> findById(String uuid, QueryProjection queryProjection) {
        LOGGER.info(String.format("START | Find By Id | uuid : %s", uuid));
        if (!validateUuid(uuid))
            throw new IllegalArgumentException(String.format("Provided parameter %s is not valid!", uuid));
        TResult response = (TResult) GetBaseClient().findById(uuid, queryProjection).getContent();

        if (response == null) {

            LOGGER.info(String.format("Nothing found | uuid: %s!", uuid));
            return Optional.empty();
        }
        LOGGER.info("Found entry: %s", response.toString());
        LOGGER.info(String.format("FINISH | Find By Id | uuid : %s", uuid));

        return Optional.of(response);
    }

    @Override
    public Optional<TResult> create(TInput object) throws Exception {
        return create(object, QueryProjection.def);
    }

    public Optional<TResult> create(TInput object, QueryProjection projection) throws Exception {
        LOGGER.info(String.format("Creating entity in db | Payload: %s", object.toString()));
        if (!validateCreateParameter(object))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", object.toString()));

        //TODO WHY binded client?
     //   TResult result = (TResult) getBindedClient(object).create(object, projection).getContent();
        TResult result = (TResult) getDefaultClient().create(object, projection).getContent();

        if (result == null) {
            LOGGER.info(String.format("Could not create | payload: %s!", object.toString()));
            throw new Exception("Internal error");
        }
        return Optional.of(result);

    }

    @Override
    public Optional<TResult> update(TInput object) {
        return update(object, QueryProjection.def);
    }

    public Optional<TResult> update(TInput object, QueryProjection projection) {
        LOGGER.info(String.format("START | Updating entity in db | Payload: %s", object.toString()));
        if (!validateUpdateParameter(object))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", object.toString()));
        TResult result = (TResult) getBindedClient(object).update(object.getId(), object, projection).getContent();
        if (result == null) {
            LOGGER.info(String.format("Could not update % entity", object.toString()));
            return Optional.empty();
        }
        LOGGER.info(String.format("FINISH | Updating entity | Payload %s", object.toString()));
        return Optional.of(result);
    }

    public Optional<Boolean> delete(String uuid, QueryProjection queryProjection) {
        LOGGER.info(String.format("START | Deleting entity | Payload: %s", uuid));
        boolean deletionWasSuccesfull = false;

        if (!validateDeleteParameter(uuid))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", uuid));

        ResponseEntity<?> result = GetBaseClient().delete(uuid, queryProjection);

        if (result.getStatusCode().is2xxSuccessful()) {
            deletionWasSuccesfull = true;
        }


        if (result == null) {
            LOGGER.info(String.format("Could not delete % entity", uuid.toString()));
            return Optional.empty();
        }


        LOGGER.info(String.format("FINISH | Deleting entity | Payload: %s", uuid.toString()));

        return Optional.of(deletionWasSuccesfull);
    }

    @Override
    public Optional<Boolean> delete(String uuid) {
        return delete(uuid, QueryProjection.def);

    }

    public Optional<TResult> createAssociation(String uuid, List<AbstractDto> children) throws Exception {
        return createAssociation(uuid, children, QueryProjection.def);
    }

    public Optional<TResult> createAssociation(String uuid, List<AbstractDto> children, QueryProjection projection) throws Exception {

        Resource<TResult> resultEntity = null;
        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid, children.getClass().getName()));
        if (!validateDeleteParameter(uuid))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", uuid));

        Resource<TResult> parent = GetBaseClient().findById(uuid, QueryProjection.max);



         StringBuilder builder = new StringBuilder();


        for (AbstractDto child:
             children) {

            Resource<AbstractDto> childObject = (Resource<AbstractDto>) getBindedClient(child).findById(child.getId(), QueryProjection.min);
            if(childObject!=null) builder.append(childObject.getLink(Link.REL_SELF).getHref()).append("\n");



        }

        String listOfUris = builder.toString();

       ResponseEntity<?> responseEntity= GetBaseClient().createAssocationsPut(uuid,children.get(0).ResourceCollectionName(),listOfUris,projection);


       LOGGER.info(""+responseEntity.getStatusCode());


        resultEntity = GetBaseClient().findById(uuid, projection);

        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid, children.getClass().getName()));

        return Optional.of(resultEntity.getContent());


    }

    public Optional<?> createEntityWithChildren(TInput parent, List<AbstractDto> children, QueryProjection projection) throws Exception {
        Optional<TResult> parentResult= create(parent,projection);
        if(!parentResult.isPresent()) throw new Exception("Could not create parent node!");

        List<AbstractDto> createdChildren = new ArrayList<>(children.size());


       DBRestServiceBaseInterface client= getBindedClient(children.get(0));

        for (AbstractDto child:
                children) {
          Resource<AbstractDto> dto=  client.create(child,QueryProjection.min);

          if(dto==null || dto.getContent().getId()==null || dto.getContent().getId().isEmpty())  throw  new Exception("ERROR COULD NOT CREATE CHILD NODE!");

          createdChildren.add(dto.getContent());


        }


             return    createAssociation(((AbstractDto)parentResult.get()).getId(),createdChildren,QueryProjection.def);

    }

    public Optional<?> getChildrenEntites(String uuid, String resource) {
      return getChildrenEntites(uuid,resource,QueryProjection.def);
    }

    public Optional<?> getChildrenEntites(String uuid, String resource, QueryProjection queryProjection) {

        return Optional.of(getChildren(uuid,resource,queryProjection).getContent());
    }

    public Resources<?> getChildren(String uuid, String resource, QueryProjection projection){
        Resources<?> results = null;
        LOGGER.info(String.format("START | Try to find all children | Parent: %s | Child Resource Type: %s", uuid, resource));
        if (!validateUuid(uuid) && resource == null && resource.isEmpty())
            throw new IllegalArgumentException("Uuid or resource type is null!");

        results = getDefaultClient().getChildrenEntities(uuid, resource, projection);


        LOGGER.info("Found entries: " + results.getContent().size());

        LOGGER.info(String.format("START | Try to find all children | Parent: %s | Child Resource Type: %s", uuid, resource));
       return results;
    }

    /**   protected boolean createSingleAssociation(Resource<AbstractDto> parentObject, Resource<AbstractDto> child) {
           return createSingleAssociation(parentObject,child,QueryProjection.def);

       }**/


           protected boolean validateUuid(String uuid) {
           try {
               UUID.fromString(uuid);
           } catch (IllegalArgumentException ex) {
               LOGGER.error(ex.getMessage(), ex);
               return false;
           }
           return true;
       }

    protected DBRestServiceBaseInterface<TResult, TInput> getBindedClient(AbstractDto object) {
          return getBindedClient(object.getClass().getName());
       }

       protected DBRestServiceBaseInterface<TResult,TInput> getBindedClient(String objectClassName){
           DBRestServiceBaseInterface client = DBRestClientFactory.getService(objectClassName);
           LOGGER.info(MessageUtils.getSelectedRestClientMessage(client));
           return client;
       }

    protected DBRestServiceBaseInterface<TResult, TInput> getDefaultClient() {
           DBRestServiceBaseInterface client = DBRestClientFactory.getService(GetResourceName());
           LOGGER.info(MessageUtils.getSelectedRestClientMessage(client));
           return client;
       }
}
