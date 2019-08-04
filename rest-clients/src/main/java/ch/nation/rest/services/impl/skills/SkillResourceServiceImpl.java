package ch.nation.rest.services.impl.skills;

import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class SkillResourceServiceImpl extends AbstractNamedEntityService implements SkillResourceService {

    public SkillResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillDto.class, factory, massRestClientFactory);
    }
}
