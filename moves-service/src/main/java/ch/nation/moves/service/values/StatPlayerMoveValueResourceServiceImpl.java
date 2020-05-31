package ch.nation.moves.service.values;

import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.model.dto.move.values.StatSkillPlayerMoveSkillValueDto;
import ch.nation.core.services.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class StatPlayerMoveValueResourceServiceImpl extends AbstractEntityService<StatSkillPlayerMoveSkillValueDto, StatSkillPlayerMoveSkillValueDto> {


    public StatPlayerMoveValueResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(StatSkillPlayerMoveSkillValueDto.class, factory, massRestClientFactory);
    }
}
