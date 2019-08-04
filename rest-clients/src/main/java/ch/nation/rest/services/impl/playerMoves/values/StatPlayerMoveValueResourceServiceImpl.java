package ch.nation.rest.services.impl.playerMoves.values;

import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class StatPlayerMoveValueResourceServiceImpl extends AbstractEntityService<StatSkillPlayerMoveSkillValueDto,StatSkillPlayerMoveSkillValueDto> {


    public StatPlayerMoveValueResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(StatSkillPlayerMoveSkillValueDto.class, factory, massRestClientFactory);
    }
}
