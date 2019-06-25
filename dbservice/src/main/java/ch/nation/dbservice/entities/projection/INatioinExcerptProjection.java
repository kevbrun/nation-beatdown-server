package ch.nation.dbservice.entities.projection;

import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.projection.components.IDescriptionProjection;
import ch.nation.dbservice.entities.projection.components.INameProjection;
import ch.nation.dbservice.entities.projection.components.IUuidProjection;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nation_default", types = {Nation.class})
public interface INatioinExcerptProjection extends IUuidProjection,INameProjection,IDescriptionProjection {
}
