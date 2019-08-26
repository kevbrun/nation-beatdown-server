package ch.nation.rest.services.impl.prejudices;

import ch.nation.core.model.dto.prejudices.SkillPrejudiceDto;
import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.services.AbstractNamedEntityService;
import org.springframework.stereotype.Service;

@Service
public class SkillPrejudiceResourceServiceImpl extends AbstractNamedEntityService<SkillPrejudiceDto, SkillPrejudiceDto> {


    public SkillPrejudiceResourceServiceImpl( DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(SkillPrejudiceDto.class, factory, massRestClientFactory);
    }
}
