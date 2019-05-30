package ch.nation.rest.services.impl.prejudices;

import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.prejudices.DBPrejudiceRestClient;
import ch.nation.rest.clients.prejudices.DBStatPrejdudiceRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrejudiceServiceImpl extends AbstractGenericEntityService<AbstractPrejudiceDto,AbstractPrejudiceDto> implements PrejudiceService {

    private final DBRestServiceBaseInterface statPrejudiceClient;


    @Autowired
    public PrejudiceServiceImpl(DBPrejudiceRestClient client, DBStatPrejdudiceRestClient statPrejudiceClient) {
        super(client);
        this.statPrejudiceClient = statPrejudiceClient;
    }


    @Override
    protected DBRestServiceBaseInterface<AbstractPrejudiceDto, AbstractPrejudiceDto> getBindedClient(AbstractPrejudiceDto object) {

        if(object instanceof StatPrejudiceDto){
            LOGGER.info("Got Client: "+statPrejudiceClient.getClass().getName());
            return statPrejudiceClient;
        }


        return getDefaultClient();
    }
}
