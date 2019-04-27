package ch.nation.rest.services.impl;

import ch.nation.core.model.NationModel;
import ch.nation.rest.clients.DBNationRestClient;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.services.interf.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NationServiceImpl extends AbstractGenericEntityService<NationModel,NationModel> implements NationService {


    private final DBRestServiceBaseInterface client;

    @Autowired
    public NationServiceImpl(DBNationRestClient client) {
        super(client);
        this.client = client;
    }
}
