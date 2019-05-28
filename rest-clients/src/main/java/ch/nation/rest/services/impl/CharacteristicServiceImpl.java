package ch.nation.rest.services.impl;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.core.model.dto.characteristics.StatCharacteristicsDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.characteristics.DBBaseCharacteristicRestClient;
import ch.nation.rest.clients.characteristics.DBSkillCharacteristicRestClient;
import ch.nation.rest.clients.characteristics.DBStatCharacteristicRestClient;
import ch.nation.rest.services.interf.CharacteristicService;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicServiceImpl extends AbstractGenericEntityService<AbstractCharacteristicsDto,AbstractCharacteristicsDto> implements CharacteristicService {

    private final DBRestServiceBaseInterface client;
    private final DBSkillCharacteristicRestClient skillCharacteristicRestClient;
    private final DBStatCharacteristicRestClient statCharacteristicRestClient;
    private final DBBaseCharacteristicRestClient baseCharacteristicRestClient;


    public CharacteristicServiceImpl(DBStatCharacteristicRestClient statCharacteristicRestClient, DBSkillCharacteristicRestClient skillCharacteristicRestClient, DBBaseCharacteristicRestClient baseCharacteristicRestClient) {
        super(baseCharacteristicRestClient);
        this.statCharacteristicRestClient = statCharacteristicRestClient;
        this.skillCharacteristicRestClient = skillCharacteristicRestClient;
        this.client = baseCharacteristicRestClient;
        this.baseCharacteristicRestClient = baseCharacteristicRestClient;
    }

    @Override
    protected DBRestServiceBaseInterface GetClient(AbstractCharacteristicsDto object) {

        if(object instanceof StatCharacteristicsDto){
            return statCharacteristicRestClient;
        }else if(object instanceof DBStatCharacteristicRestClient){
            return baseCharacteristicRestClient;
        }




        return getDefaultClient();
    }
}
