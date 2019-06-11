package ch.nation.rest.services.impl.skills;

import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.skills.DBSkillRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl extends AbstractGenericEntityService implements SkillService {

    public SkillServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillDto.class, factory, massRestClientFactory);
    }
}
