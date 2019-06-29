package ch.nation.dbservice.entities.user;

import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import ch.nation.dbservice.entities.projection.users.TimestampProjection;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nation-default", types = Nation.class)
public interface NationMaxResponseProjection extends NamedClassesProjection, TimestampProjection, MinimizedEntityResponseProjection {
}
