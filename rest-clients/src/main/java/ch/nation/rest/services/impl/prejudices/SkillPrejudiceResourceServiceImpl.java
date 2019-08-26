package ch.nation.rest.services.impl.prejudices;

import ch.nation.core.model.dto.move.SkillPlayerMoveDto;
import ch.nation.core.model.dto.prejudices.SkillPrejudiceDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class SkillPrejudiceResourceServiceImpl extends AbstractNamedEntityService<SkillPrejudiceDto, SkillPrejudiceDto> {


    public SkillPrejudiceResourceServiceImpl( DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillPrejudiceDto.class, factory, massRestClientFactory);
    }
}
