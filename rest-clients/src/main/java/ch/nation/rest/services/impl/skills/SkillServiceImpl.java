package ch.nation.rest.services.impl.skills;

import ch.nation.core.model.dto.characteristics.AbstractCharacteristicsDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.prejudices.DBPrejudiceRestClient;
import ch.nation.rest.clients.skills.DBSkillRestClient;
import ch.nation.rest.services.impl.AbstractGenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl extends AbstractGenericEntityService implements SkillService {


    @Autowired
    public SkillServiceImpl(DBSkillRestClient baseClient) {
        super(baseClient);
    }



}
