package ch.nation.rest.services.impl;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.interf.services.GenericMassCrudDao;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.DBRestMassServiceBaseInterface;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.users.DBMassUserRestClient;
import ch.nation.rest.utils.MessageUtils;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AbstractMassGenericEntityService<TResult,TInput extends AbstractDto>
        extends AbstractGenericEntityService<TResult,TInput> implements  GenericMassCrudDao<TResult,TInput> {


    public AbstractMassGenericEntityService(Class<?> resourceClass, DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(resourceClass, factory, massRestClientFactory);
    }

    @Override
    public Optional<Collection<TResult>> batchUpdate(Collection<TInput> object) {

        ArrayList results = new ArrayList(object.size());
        LOGGER.info(String.format("START | Batch Update | Used client %s", GetMassClient().getClass().getName()));

        if(object.size()>0){


      Resources<TResult>   response =   GetMassClient().updateBatch(object);

        LOGGER.info("Items received: "+response.getContent().size());
        results.add(response.getContent());



        }
        LOGGER.info(String.format("STOP | Batch Update | Used client %s", GetMassClient().getClass().getName()));

        return Optional.of(results);
    }

    @Override
    public Optional<Resource<Boolean>> batchDeletion(Collection<TInput> object) {
        LOGGER.info(String.format("START | Batch Update | Used client %s", GetMassClient().getClass().getName()));
        Boolean deletionStatus = false;
        if(object.size()>0){


            Resource<Boolean> response =   GetMassClient().deleteBatch(object);

            LOGGER.info("Bool received: "+response.getContent());
            deletionStatus = response.getContent();




        }
        LOGGER.info(String.format("STOP | Batch Update | Used client %s", GetMassClient().getClass().getName()));


        return Optional.of(new Resource<Boolean>(deletionStatus));
    }


    protected DBRestMassServiceBaseInterface GetMassClient(){
        DBRestMassServiceBaseInterface client = DBMassRestClientFactory.getService(GetResourceName());
        LOGGER.info(MessageUtils.getSelectedRestClientMessage(client));
        return client;
    }



}
