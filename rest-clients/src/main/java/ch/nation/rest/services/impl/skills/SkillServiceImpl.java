package ch.nation.rest.services.impl.skills;

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
