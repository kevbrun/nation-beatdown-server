package ch.nation.dbservice.entities.characteristics.projection;

import ch.nation.dbservice.entities.bonus.StatBonusDelta;
import ch.nation.dbservice.entities.characteristics.StatCharacteristic;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = StatCharacteristic.class,name="default")
public interface StatCharacteristicDefaultProjection extends BaseCharacteristicProjecton {


    @JsonProperty("delta")
    StatBonusDelta getDelta();
}
