package ch.nation.skill.service;

import ch.nation.core.model.dto.skills.SkillDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class SkillResourceServiceImpl extends AbstractNamedEntityService implements SkillResourceService {

    public SkillResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillDto.class, factory, massRestClientFactory);
    }
}
