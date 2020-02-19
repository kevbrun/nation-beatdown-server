package ch.nation.dbservice.entities.units;

import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "max", types = {Unit.class})
public interface UnitMaxResponseProjection extends MinimizedEntityResponseProjection, NamedClassesProjection, UnitBaseFields {


}
