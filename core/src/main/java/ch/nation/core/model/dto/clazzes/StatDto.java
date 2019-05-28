package ch.nation.core.model.dto.clazzes;

import ch.nation.core.model.Enums.StatGrowthType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatDto {


    @JsonProperty("base")
    private float baseValue;


    @JsonProperty("min")
    private float minValue;

    @JsonProperty("max")
    private float maxValue;

    @JsonProperty("growthType")
    private StatGrowthType growthType;



}
