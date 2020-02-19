package ch.nation.dbservice.entities.prejudices.projections;

import ch.nation.core.model.Enums.PrejudiceOperator;
import ch.nation.dbservice.entities.prejudices.BasePrejudice;
import ch.nation.dbservice.entities.prejudices.triggers.BasePrejudiceTrigger;
import ch.nation.dbservice.entities.projection.components.IIdentityProjection;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


@Projection(name = "max", types = BasePrejudice.class)
public interface MaxBasePrejudiceProjection extends MinimizedEntityResponseProjection, NamedClassesProjection, IIdentityProjection {


    @JsonProperty("triggers")
    List<BasePrejudiceTrigger> getPrejudiceTriggers();

    @JsonProperty("operation")
    PrejudiceOperator getTriggerOperation();


}
