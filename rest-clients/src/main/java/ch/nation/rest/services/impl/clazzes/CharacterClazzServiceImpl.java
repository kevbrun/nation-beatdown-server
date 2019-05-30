package ch.nation.rest.services.impl.clazzes;

import ch.nation.core.model.dto.clazzes.CharacterClassDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.clazzes.DBCharacterClazzRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;

public class CharacterClazzServiceImpl extends AbstractGenericEntityService<CharacterClassDto,CharacterClassDto> implements CharacterClazzService {

    private final DBRestServiceBaseInterface client;


    public CharacterClazzServiceImpl(DBCharacterClazzRestClient client) {
        super(client);
        this.client = client;

    }


}
