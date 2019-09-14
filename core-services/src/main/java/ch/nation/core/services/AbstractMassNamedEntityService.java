package ch.nation.core.services;

import ch.nation.core.clients.db.DBRestMassServiceBaseInterface;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.NamedObjectAbstractDto;
import ch.nation.core.model.interf.services.GenericMassCrudDao;

import ch.nation.core.clients.db.utils.MessageUtils;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.Collection;
import java.util.Optional;

public class AbstractMassNamedEntityService<TResult,TInput extends NamedObjectAbstractDto>
        extends AbstractNamedEntityService<TResult,TInput> implements  GenericMassCrudDao<TResult,TInput> {


    public AbstractMassNamedEntityService(Class<?> resourceClass, DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(resourceClass, factory, massRestClientFactory);
    }

    @Override
    public Optional<Resources<TResult>> batchUpdate(Collection<TInput> object) {
        return  batchUpdate(object,QueryProjection.def);
    }

    public Optional<Resources<TResult>> batchUpdate(Collection<TInput> object, QueryProjection projection){


        LOGGER.info(String.format("START | Batch Update | Used client %s", GetMassClient().getClass().getName()));
        Resources<TResult>   response =null;
        if(object.size()>0){


            response =   GetMassClient().updateBatch(object, projection);

            LOGGER.info("Items received: "+response.getContent().size());




        }
        LOGGER.info(String.format("STOP | Batch Update | Used client %s", GetMassClient().getClass().getName()));

        return Optional.of(response);
    }

    public Optional<Resource<Boolean>> batchDeletion(Collection<TInput> object, QueryProjection projection){
        LOGGER.info(String.format("START | Batch Update | Used client %s", GetMassClient().getClass().getName()));
        Boolean deletionStatus = false;
        if(object.size()>0){


            Resource<Boolean> response =   GetMassClient().deleteBatch(object, projection);

            LOGGER.info("Bool received: "+response.getContent());
            deletionStatus = response.getContent();




        }
        LOGGER.info(String.format("STOP | Batch Update | Used client %s", GetMassClient().getClass().getName()));


        return Optional.of(new Resource<Boolean>(deletionStatus));

    }

    @Override
    public Optional<Resource<Boolean>> batchDeletion(Collection<TInput> object) {
        return batchDeletion(object,QueryProjection.def);
    }


    protected DBRestMassServiceBaseInterface GetMassClient(){
        DBRestMassServiceBaseInterface client = DBMassRestClientFactory.getService(GetResourceName());
        LOGGER.info(MessageUtils.getSelectedRestClientMessage(client));
        return client;
    }



}
