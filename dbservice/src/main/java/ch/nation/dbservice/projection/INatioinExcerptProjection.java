package ch.nation.dbservice.projection;

import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.projection.components.IDescriptionProjection;
import ch.nation.dbservice.projection.components.INameProjection;
import ch.nation.dbservice.projection.components.IUuidProjection;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nation_default", types = {Nation.class})
public interface INatioinExcerptProjection extends IUuidProjection,INameProjection,IDescriptionProjection {
}
