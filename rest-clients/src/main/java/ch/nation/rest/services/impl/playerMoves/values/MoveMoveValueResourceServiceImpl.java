package ch.nation.rest.services.impl.playerMoves.values;

import ch.nation.core.model.dto.move.values.MoveSkillEffectPlayerMoveSkillValueDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class MoveMoveValueResourceServiceImpl extends AbstractEntityService<MoveSkillEffectPlayerMoveSkillValueDto,MoveSkillEffectPlayerMoveSkillValueDto> {


    public MoveMoveValueResourceServiceImpl( DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super( MoveSkillEffectPlayerMoveSkillValueDto.class,factory, massRestClientFactory);
    }
}
