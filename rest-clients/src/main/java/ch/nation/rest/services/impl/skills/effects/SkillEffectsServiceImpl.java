package ch.nation.rest.services.impl.skills.effects;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.core.model.dto.skills.effects.AbstractSkillEffectDto;
import ch.nation.core.model.dto.skills.effects.TimeReversalSkillEffectDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.clients.skills.effects.DBSkillEffectsRestClient;
import ch.nation.rest.clients.skills.effects.DBTimeReversalSkillEffectRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import ch.nation.rest.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillEffectsServiceImpl extends AbstractGenericEntityService<AbstractSkillEffectDto,AbstractSkillEffectDto> implements SkillEffectsService {

    @Autowired
    public SkillEffectsServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(AbstractSkillEffectDto.class,factory, massRestClientFactory);
    }


}
