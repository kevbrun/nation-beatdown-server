package ch.nation.rest.services.impl.clazzes;

import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.rest.clients.clazzes.DBCharacterClazzRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CharacterClazzServiceImpl extends AbstractGenericEntityService<CharacterClassDto,CharacterClassDto> implements CharacterClazzService {

    @Autowired
    public CharacterClazzServiceImpl(DBCharacterClazzRestClient client) {
        super(client);

    }


}
