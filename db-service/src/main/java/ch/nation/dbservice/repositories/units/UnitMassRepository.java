package ch.nation.dbservice.repositories.units;

import ch.nation.core.model.dto.unit.AbstractAssetsDto;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.repositories.IPageableDao;
import ch.nation.dbservice.repositories.core.AbstractMassRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RepositoryRestController
@RequestMapping("units")

public class UnitMassRepository extends AbstractMassRestResource<Unit> {
    public UnitMassRepository(UnitRepository repo) {
        super(repo);
    }
}
