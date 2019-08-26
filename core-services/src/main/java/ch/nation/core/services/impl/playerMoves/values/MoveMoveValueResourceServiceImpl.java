package ch.nation.core.services.impl.playerMoves.values;

import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class MoveMoveValueResourceServiceImpl extends AbstractEntityService<MoveSkillEffectPlayerMoveSkillValueDto,MoveSkillEffectPlayerMoveSkillValueDto> {


    public MoveMoveValueResourceServiceImpl( DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super( MoveSkillEffectPlayerMoveSkillValueDto.class,factory, massRestClientFactory);
    }
}
