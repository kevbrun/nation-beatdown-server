package ch.nation.rest.services.impl.skills.effects;

import ch.nation.core.model.dto.skills.effects.AbstractSkillEffectDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillEffectsResourceServiceImpl extends AbstractNamedEntityService<AbstractSkillEffectDto,AbstractSkillEffectDto> implements SkillEffectsResourceService {

    @Autowired
    public SkillEffectsResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(AbstractSkillEffectDto.class,factory, massRestClientFactory);
    }


}
