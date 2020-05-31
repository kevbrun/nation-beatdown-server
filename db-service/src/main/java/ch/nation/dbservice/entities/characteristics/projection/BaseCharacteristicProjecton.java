package ch.nation.dbservice.entities.characteristics.projection;

import ch.nation.dbservice.entities.projection.components.IIdentityProjection;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;

public interface BaseCharacteristicProjecton extends MinimizedEntityResponseProjection, NamedClassesProjection, IIdentityProjection {
}
