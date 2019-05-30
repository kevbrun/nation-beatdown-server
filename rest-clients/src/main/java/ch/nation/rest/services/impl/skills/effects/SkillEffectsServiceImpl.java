package ch.nation.rest.services.impl.skills.effects;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.core.model.dto.skills.effects.AbstractSkillEffectDto;
import ch.nation.core.model.dto.skills.effects.SkillEffectDto;
import ch.nation.core.model.dto.skills.effects.TimeReversalSkillEffectDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.skills.effects.DBSkillEffectsRestClient;
import ch.nation.rest.clients.skills.effects.DBTimeReversalSkillEffectRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import ch.nation.rest.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillEffectsServiceImpl extends AbstractGenericEntityService<AbstractSkillEffectDto,AbstractSkillEffectDto> implements SkillEffectsService {

    private final DBRestServiceBaseInterface timeReversal;

    @Autowired
    public SkillEffectsServiceImpl(DBSkillEffectsRestClient client, DBTimeReversalSkillEffectRestClient timeReversal) {
        super(client);
        this.timeReversal = timeReversal;
    }


    @Override
    protected DBRestServiceBaseInterface<AbstractSkillEffectDto, AbstractSkillEffectDto> getBindedClient(AbstractSkillEffectDto object) {

        if(object instanceof TimeReversalSkillEffectDto){

            LOGGER.info(MessageUtils.getSelectedRestClientMessage(timeReversal));

            return timeReversal;
        }


        return getDefaultClient();
    }
}
