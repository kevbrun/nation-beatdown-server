package ch.nation.dbservice.entities.prejudices.projections;

import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.prejudices.StatPrejudice;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="max",types = StatPrejudice.class)
public interface MaxStatPrejudiceProjection extends MaxBasePrejudiceProjection {


    @JsonProperty("delta")
    StatBonusDelta getDelta();
}
