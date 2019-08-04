package ch.nation.rest.services.impl.clazzes;

import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.rest.clients.factory.DBMassRestClientFactory;
import ch.nation.rest.clients.factory.DBRestClientFactory;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CharacterClazzResourceServiceImpl extends AbstractNamedEntityService<CharacterClassDto,CharacterClassDto> implements CharacterClazzResourceService {


    @Autowired
    public CharacterClazzResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory) {
        super(CharacterClassDto.class,factory, massRestClientFactory);
    }

}
