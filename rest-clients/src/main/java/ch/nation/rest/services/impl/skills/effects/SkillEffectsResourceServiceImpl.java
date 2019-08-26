package ch.nation.rest.services.impl.skills.effects;

import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;

import ch.nation.core.services.AbstractNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillEffectsResourceServiceImpl extends AbstractNamedEntityService<SkillEffectDto,SkillEffectDto> implements SkillEffectsResourceService {

    @Autowired
    public SkillEffectsResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillEffectDto.class,factory, massRestClientFactory);
    }


}
