package ch.nation.rest.services.impl.prejudices;

import ch.nation.core.model.dto.prejudices.AbstractPrejudiceDto;
import ch.nation.core.model.dto.prejudices.StatPrejudiceDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.prejudices.DBPrejudiceRestClient;
import ch.nation.rest.clients.prejudices.DBStatPrejdudiceRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrejudiceServiceImpl extends AbstractGenericEntityService<AbstractPrejudiceDto,AbstractPrejudiceDto> implements PrejudiceService {


    @Autowired
    public PrejudiceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(AbstractPrejudiceDto.class,factory, massRestClientFactory);
    }


}
