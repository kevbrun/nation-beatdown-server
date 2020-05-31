package ch.nation.core.model.dto.characteristics;

import ch.nation.core.model.Bonus.FloatBonus;
import ch.nation.core.model.Bonus.IntegerBonus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatBonusDeltaDto {


    public StatBonusDeltaDto() {
    }


    @JsonProperty("hpBonus")
    private IntegerBonus hpBonus;


    @JsonProperty("apBonus")
    private IntegerBonus apBonus;


    @JsonProperty("strBonus")
    private IntegerBonus strBonus;


    @JsonProperty("vitBonus")
    private IntegerBonus vitBonus;


    @JsonProperty("agiBonus")
    private IntegerBonus agiBonus;


    @JsonProperty("dexBonus")
    private IntegerBonus dexBonus;


    @JsonProperty("intBonus")
    private IntegerBonus intBonus;


    //Percantage Bonus


    @JsonProperty("hpBonusPerc")
    private FloatBonus hpPercentageBonus;


    @JsonProperty("apBonusPerc")
    private FloatBonus apPercentageBonus;


    @JsonProperty("strBonusPerc")
    private FloatBonus strPercentageBonus;


    @JsonProperty("vitBonusPerc")
    private FloatBonus vitPercentageBonus;


    @JsonProperty("agiBonusPerc")
    private FloatBonus agiPercentageBonus;


    @JsonProperty("dexBonusPerc")
    private FloatBonus dexPercentageBonus;


    @JsonProperty("intBonusPerc")
    private FloatBonus intPercentageBonus;


    @Override
    public String toString() {
        return "StatBonusDelta{" +
                "hpBonus=" + hpBonus +
                ", apBonus=" + apBonus +
                ", strBonus=" + strBonus +
                ", vitBonus=" + vitBonus +
                ", agiBonus=" + agiBonus +
                ", dexBonus=" + dexBonus +
                ", intBonus=" + intBonus +
                ", hpPercentageBonus=" + hpPercentageBonus +
                ", apPercentageBonus=" + apPercentageBonus +
                ", strPercentageBonus=" + strPercentageBonus +
                ", vitPercentageBonus=" + vitPercentageBonus +
                ", agiPercentageBonus=" + agiPercentageBonus +
                ", dexPercentageBonus=" + dexPercentageBonus +
                ", intPercentageBonus=" + intPercentageBonus +
                '}';
    }

}
