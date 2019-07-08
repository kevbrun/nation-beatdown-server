package ch.nation.rest.services.impl;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.interf.services.GenericCRUDDao;
import ch.nation.core.model.interf.services.GenericFindByNameService;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
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




}
