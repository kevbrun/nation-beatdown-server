package ch.nation.dbservice.entities.prejudices.triggers.projection;

import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.prejudices.BasePrejudice;
import ch.nation.dbservice.entities.prejudices.triggers.CharacteristicPrejudiceTrigger;
import ch.nation.dbservice.entities.projection.users.MinimizedEntityResponseProjection;
import ch.nation.dbservice.entities.projection.users.NamedClassesProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


@Projection(name="max",types = {CharacteristicPrejudiceTrigger.class})
public interface MaxCharacteristicPrejudiceTriggerProjection extends MinimizedEntityResponseProjection, NamedClassesProjection {


    @JsonProperty("characteristics")
    List<BaseCharacteristic> getCharacteristics();

}
