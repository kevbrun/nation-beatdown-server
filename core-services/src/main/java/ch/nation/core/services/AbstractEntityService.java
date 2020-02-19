package ch.nation.core.services;

import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dtoWrapper.SimpleResourceDto;
import ch.nation.core.model.interf.services.GenericCRUDDao;


import ch.nation.core.clients.db.utils.MessageUtils;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class AbstractEntityService<TResult, TInput extends AbstractDto> implements GenericCRUDDao<TResult, TInput> {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    protected final DBRestClientFactory factory;
    protected final DBMassRestClientFactory massRestClientFactory;
    private final String resourceClassName;


    public AbstractEntityService(Class<?> resourceClass, DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {

        this.factory = factory;
        this.massRestClientFactory = massRestClientFactory;
        this.resourceClassName = resourceClass.getName();
    }

    protected boolean validateCreateParameter(TInput payload) {
        return true;

    }

    public String GetResourceName() {


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
    public Optional<SimpleResourceDto> getAll() {

        return getAll(0, 100, QueryProjection.def);

    }

    public Optional<SimpleResourceDto> getAll(long page, long size, final QueryProjection queryProjection) {
        LOGGER.info(String.format("START | Get ALL | Used client %s", GetBaseClient().getClass().getName()));

        final PagedResources<TResult> resultsFromDB = GetBaseClient().getAll(page, size, queryProjection);

        if (resultsFromDB != null && resultsFromDB.getContent().size() > 0) {
            LOGGER.info(String.format("Found %d entries", resultsFromDB.getContent().size()));
            //int size, int totalElements, int totalPages, int number
            final SimpleResourceDto resourceDto = new SimpleResourceDto(resultsFromDB);
            return Optional.of(resourceDto);
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
        Resource response = GetBaseClient().findById(uuid, queryProjection);

        if (response == null) {

            LOGGER.info(String.format("Nothing found | uuid: %s!", uuid));
            return Optional.empty();
        }
        LOGGER.info("Found entry: %s", response.toString());
        LOGGER.info(String.format("FINISH | Find By Id | uuid : %s", uuid));

        return (Optional<TResult>) Optional.of(response.getContent());
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

        Resource<?> result = getBindedClient(object).create(object, projection);
        // TResult result = (TResult) getBindedClient(object).create(object, projection).getContent();
        //    TResult result = (TResult) getDefaultClient().create(object, projection).getContent();
//
        if (result == null) {
            LOGGER.info(String.format("Could not create | payload: %s!", object.toString()));
            throw new Exception("Internal error");
        }
        return (Optional<TResult>) Optional.of(result.getContent());

    }

    @Override
    public Optional<TResult> updatePatch(TInput object) {
        return updatePatch(object, QueryProjection.def);
    }

    @Override
    public Optional<TResult> updatePut(TInput object) {
        return updatePut(object, QueryProjection.def);
    }


    public Optional<TResult> updatePut(TInput object, QueryProjection projection) {
        LOGGER.info(String.format("START | Updating entity in db | Payload: %s", object.toString()));
        if (!validateUpdateParameter(object))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", object.toString()));
        TResult result = (TResult) getBindedClient(object).updatePut(object.getId(), object, projection).getContent();
        if (result == null) {
            LOGGER.info(String.format("Could not updatePatch % entity", object.toString()));
            return Optional.empty();
        }
        LOGGER.info(String.format("FINISH | Updating entity | Payload %s", object.toString()));
        return Optional.of(result);
    }


    public Optional<TResult> updatePatch(TInput object, QueryProjection projection) {
        LOGGER.info(String.format("START | Updating entity in db | Payload: %s", object.toString()));
        if (!validateUpdateParameter(object))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", object.toString()));
        TResult result = (TResult) getBindedClient(object).updatePatch(object.getId(), object, projection).getContent();
        if (result == null) {
            LOGGER.info(String.format("Could not updatePatch % entity", object.toString()));
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


    public Optional<TResult> createAssociation(String uuid, List<AbstractDto> children, QueryProjection projection) throws Exception {

        return createAssociation(uuid, children, children.get(0).ResourceCollectionName(), projection);

    }

    public Optional<TResult> createAssociation(String uuid, List<AbstractDto> children, String collectionName, QueryProjection projection) {
        Resource<TResult> resultEntity = null;
        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid, children.getClass().getName()));
        if (!validateDeleteParameter(uuid))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", uuid));

        Resource<AbstractDto> parent = GetBaseClient().findById(uuid, QueryProjection.max);


        StringBuilder builder = new StringBuilder();


        for (AbstractDto child :
                children) {

            Resource<AbstractDto> childObject = (Resource<AbstractDto>) getBindedClient(child).findById(child.getId(), QueryProjection.min);
            if (childObject != null) builder.append(childObject.getLink(Link.REL_SELF).getHref()).append("\n");

        }

        String listOfUris = builder.toString();

        //   ResponseEntity<?> responseEntity= GetBaseClient().createAssocationsPut(uuid,collectionName,listOfUris,projection);
        ResponseEntity<?> responseEntity = getBindedClient(parent.getContent()).createAssocationsPut(uuid, collectionName, listOfUris, projection);

        LOGGER.info("" + responseEntity.getStatusCode());


        resultEntity = GetBaseClient().findById(uuid, projection);

        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid, children.getClass().getName()));

        return Optional.of(resultEntity.getContent());
    }


    public Optional<?> addChildrenToParent(TInput parent, List<AbstractDto> children, QueryProjection projection) throws Exception {
        return createAssociation(parent.getId(), children, projection);
    }

    public Optional<TResult> createAssociation(String uuid, AbstractDto child, String resourceName, QueryProjection projection) {

        Resource<TResult> resultResource = null;
        ResponseEntity resultEntity = null;
        LOGGER.info(String.format("START | Creating assocation | Payload: %s | Child Type: %s", uuid, child.getClass().getName()));
        if (!validateDeleteParameter(uuid))
            throw new IllegalArgumentException(String.format("Payload %s is not valid", uuid));

        Resource<TResult> parent = GetBaseClient().findById(uuid, QueryProjection.max);
        Resource<AbstractDto> childObject = (Resource<AbstractDto>) getBindedClient(child).findById(child.getId(), QueryProjection.min);
        if (childObject != null) {
            String childLink = childObject.getLink(Link.REL_SELF).getHref().toString();

            resultEntity = GetBaseClient().createAssocationsPut(uuid, resourceName, childLink, projection);

            resultResource = GetBaseClient().findById(uuid, QueryProjection.max);

            return Optional.of(resultResource.getContent());
        }
        LOGGER.info(String.format("FINISH | Creating assocation | Payload: %s | Child Type: %s", uuid, child.getClass().getName()));
        return Optional.empty();
    }


    public Optional<?> createChildrenAndAddToParent(TInput parent, List<AbstractDto> children, QueryProjection projection) throws Exception {
        return createAssociation((parent).getId(), createChildren(children, QueryProjection.def).get(), projection);
    }


    public Optional<List<AbstractDto>> createChildren(List<AbstractDto> children, QueryProjection projection) throws Exception {
        List<AbstractDto> createdChildren = new ArrayList<>(children.size());
        DBRestServiceBaseInterface client = getBindedClient(children.get(0));
        for (AbstractDto child :
                children) {
            Resource<AbstractDto> dto = client.create(child, QueryProjection.def);

            if (dto == null || dto.getContent().getId() == null || dto.getContent().getId().isEmpty())
                throw new Exception("ERROR COULD NOT CREATE CHILD NODE!");

            createdChildren.add(dto.getContent());


        }
        return Optional.of(createdChildren);
    }

    public Optional<?> createEntityAndCreateChildren(TInput parent, List<AbstractDto> children, QueryProjection projection) throws Exception {
        Optional<TResult> parentResult = create(parent);
        if (!parentResult.isPresent()) throw new Exception("Could not create parent node!");
        return createChildrenAndAddToParent((TInput) parentResult.get(), children, projection);
    }


    public Optional<?> getChildrenEntites(String uuid, String resource, QueryProjection queryProjection) {

        return getChildren(uuid, resource, queryProjection);
    }

    public Optional<?> getChildren(String uuid, String resource, QueryProjection projection) {
        Resources<?> results = null;
        LOGGER.info(String.format("START | Try to find all children | Parent: %s | Child Resource Type: %s", uuid, resource));
        if (!validateUuid(uuid) && resource == null && resource.isEmpty())
            throw new IllegalArgumentException("Uuid or resource type is null!");

        results = getDefaultClient().getChildrenEntities(uuid, resource, projection);


        LOGGER.info("Found entries: " + results.getContent().size());

        LOGGER.info(String.format("START | Try to find all children | Parent: %s | Child Resource Type: %s", uuid, resource));
        return Optional.of(results.getContent());
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

    public boolean existsById(String uuid, QueryProjection projection) {

        LOGGER.info(String.format("START | Exists by id| uuid: %s", uuid));
        if (!validateUuid(uuid))
            throw new IllegalArgumentException("Uuid or resource type is null!");

        //Resource<Boolean> resource = getDefaultClient().existsById(uuid,projection);

        Resource<TResult> resource = getDefaultClient().findById(uuid, projection.min);

        if (resource != null && resource.getContent() != null) return true;

        //   LOGGER.debug("Resulit "+resource.getContent().toString());
        LOGGER.info(String.format("STOP | Exists by id| uuid: %s", uuid));
        //    return resource.getContent();
        return false;
    }

    public boolean existsById(String uuid) {
        return existsById(uuid, QueryProjection.def);
    }

    protected DBRestServiceBaseInterface<TResult, TInput> getBindedClient(AbstractDto object) {
        return getBindedClient(object.getClass().getName());
    }

    protected DBRestServiceBaseInterface<TResult, TInput> getBindedClient(String objectClassName) {
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
