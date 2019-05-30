package ch.nation.rest.services.impl.skills;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.prejudices.DBPrejudiceRestClient;
import ch.nation.rest.clients.skills.DBSkillRestClient;

public class SkillServiceImpl extends AbstractCharacteristicsDto implements SkillService {

    private final DBRestServiceBaseInterface baseClient;


    public SkillServiceImpl(DBSkillRestClient baseClient) {
        this.baseClient = baseClient;
    }



}
