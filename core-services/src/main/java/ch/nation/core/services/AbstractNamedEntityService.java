package ch.nation.core.services;


import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.dtoWrapper.SimpleResourceDto;
import ch.nation.core.model.interf.services.GenericFindByNameService;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;


import java.util.*;

public abstract class AbstractNamedEntityService<TResult, TInput extends NamedObjectAbstractDto> extends AbstractEntityService<TResult, TInput> implements GenericFindByNameService<TResult> {


    public AbstractNamedEntityService(Class<?> resourceClass, DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(resourceClass, factory, massRestClientFactory);

    }

    public Optional<TResult> findByName(String name, QueryProjection projection) {
        LOGGER.info(String.format("START | Find By Name | name : %s", name));
        if (name == null || name.isBlank())
            throw new IllegalArgumentException(String.format("Provided parameter %s is not valid!", name));
        TResult response = (TResult) GetBaseClient().findByName(name, projection).getContent();

        if (response == null) {

            LOGGER.info(String.format("Nothing found | name: %s!", name));
            return Optional.empty();
        }


        LOGGER.info("Found entry: %s", response.toString());
        LOGGER.info(String.format("STOP | Find By Name | name : %s", name));
        return Optional.of(response);
    }

    @Override
    public Optional<TResult> findByName(String name) {
        return findByName(name, QueryProjection.def);
    }

    public Optional<Boolean> existsByName(String name) {
        LOGGER.info(String.format("START | Exists By Name | name : %s", name));
        if (name == null || name.isBlank())
            return Optional.of(false);
        boolean response = (boolean) GetBaseClient().existsByName(name);
        LOGGER.info("Entity exists: ", Boolean.valueOf(response));
        LOGGER.info(String.format("STOP | Exists By Name | name : %s", name));
        return Optional.of(response);
    }


    public Optional<TResult> findByIdentifier(final String identifier, final QueryProjection queryProjection) {
        LOGGER.info(String.format("START | Find by Identifier | Used client %s", GetBaseClient().getClass().getName()));
        if (identifier == null || identifier.isBlank())
            throw new IllegalArgumentException(String.format("Provided parameter %s is not valid!", identifier));
        TResult response = (TResult) GetBaseClient().findByIdentifier(identifier, queryProjection).getContent();

        if (response == null) {

            LOGGER.info(String.format("Nothing found | name: %s!", identifier));
            return Optional.empty();
        }


        LOGGER.info("Found entry: %s", response.toString());
        LOGGER.info(String.format("STOP | Find by Identifier | Used client %s", GetBaseClient().getClass().getName()));

        return Optional.of(response);


    }


}
