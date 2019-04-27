package ch.nation.rest.services.impl;

import ch.nation.core.model.NationModel;
import ch.nation.core.model.UserModel;
import ch.nation.rest.clients.DBNationRestClient;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.DBUserRestClient;
import ch.nation.rest.services.interf.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NationServiceImpl extends AbstractGenericEntityService<NationModel,NationModel> implements NationService {


    private final String REL_USER_LINK="user";
    private final DBRestServiceBaseInterface client;

    private final DBRestServiceBaseInterface userClient;

    @Autowired
    public NationServiceImpl(DBNationRestClient client, DBUserRestClient userClient) {
        super(client);
        this.client = client;
        this.userClient  = userClient;
    }

    @Override
    public Optional<UserModel> getUser(String nationUUID) {
        LOGGER.info(String.format("START | Try to get user by nation uuid | uuid: %s",nationUUID));
        if(!validateUuid(nationUUID)) throw new IllegalArgumentException("Nation uuid is not valid!");
        UserModel user =((DBNationRestClient) client).getUserAssociatedWithNation(nationUUID).getContent();
        if(user == null){
            LOGGER.info(String.format("No user for Nation uuid: %s",nationUUID));
            return Optional.empty();
        }
        LOGGER.info("Found user | ");
        LOGGER.info(String.format("FINISH | Try to get user by nation uuid | uuid: %s",nationUUID));
        return Optional.of(user);
    }

    @Override
    public Optional<NationModel> createAssociationWithUser(String nationUuid,String userUuid) throws Exception {
        LOGGER.info(String.format("START | Try adding associaton nation to user | uuid nation: %s |  uuid user: %s",nationUuid,userUuid));
        if(!validateUuid(nationUuid))throw new IllegalArgumentException("Nation uuid is invalid");

/** TODO TESTING**/

        NationModel resource = (NationModel) client.findById(nationUuid).getContent();

        if(resource==null) throw new Exception(String.format("Could not found nation with uuid %s",nationUuid));

        Resource<UserModel> userEntity = userClient.findById(userUuid);

        if(userEntity==null || userEntity.getLink("self")==null) throw new Exception("could not found uri for user "+userUuid);

        String uri = userEntity.getId().toString();

        Resource<NationModel> model = ((DBNationRestClient)client).createAssociationWithUser(nationUuid,uri);


        LOGGER.info(String.format("FINISH | Try adding associaton nation to user | uuid nation: %s |  uuid user: %s",nationUuid,userUuid));
        return Optional.of(model.getContent());
    }
}
