package ch.nation.dbservice.entities.Bonus;

import ch.nation.dbservice.entities.Characteristics.StatCharacteristics;
import ch.nation.dbservice.entities.NationEntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Embeddable
public class StatBonusDelta  {


    public StatBonusDelta() {
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "hp_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "hp_stat_target")),

    })
    @Column(name="hpBonus")
    @JsonProperty("hpBonus")
    private EmbeddableIntegerBonus hpBonus;




    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "ap_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "ap_stat_target")),

    })
    @Column(name="apBonus")
    @JsonProperty("apBonus")
    private EmbeddableIntegerBonus apBonus;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "str_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "str_stat_target")),

    })
    @Column(name="strBonus")
    @JsonProperty("strBonus")
    private EmbeddableIntegerBonus strBonus;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "vit_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "vit_stat_target")),

    })
    @Column(name="vitBonus")
    @JsonProperty("vitBonus")
    private EmbeddableIntegerBonus vitBonus;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "agi_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "agi_stat_target")),

    })
    @Column(name="agiBonus")
    @JsonProperty("agiBonus")
    private EmbeddableIntegerBonus agiBonus;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "dex_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "dex_stat_target")),

    })
    @Column(name="dexBonus")
    @JsonProperty("dexBonus")
    private EmbeddableIntegerBonus dexBonus;




    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "int_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "int_stat_target")),

    })
    @Column(name="intBonus")
    @JsonProperty("intBonus")
    private EmbeddableIntegerBonus intBonus;




    //Percantage Bonus



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "hp_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "hp_perc_stat_target")),

    })
    @Column(name="hpBonusPerc")
    @JsonProperty("hpBonusPerc")
    private EmbeddableFloatBonus hpPercentageBonus;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "ap_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "ap_perc_stat_target")),

    })
    @Column(name="apBonusPerc")
    @JsonProperty("apBonusPerc")
    private EmbeddableFloatBonus apPercentageBonus;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "str_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "str_perc_stat_target")),

    })
    @Column(name="strBonusPerc")
    @JsonProperty("strBonusPerc")
    private EmbeddableFloatBonus strPercentageBonus;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "vit_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "vit_perc_stat_target")),

    })
    @Column(name="strBonusPerc")
    @JsonProperty("strBonusPerc")
    private EmbeddableFloatBonus vitPercentageBonus;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "agi_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "agi_perc_stat_target")),

    })
    @Column(name="strBonusPerc")
    @JsonProperty("strBonusPerc")
    private EmbeddableFloatBonus agiPercentageBonus;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "dex_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "dex_perc_stat_target")),

    })
    @Column(name="strBonusPerc")
    @JsonProperty("strBonusPerc")
    private EmbeddableFloatBonus dexPercentageBonus;




    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "int_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "int_perc_stat_target")),

    })
    @Column(name="strBonusPerc")
    @JsonProperty("strBonusPerc")
    private EmbeddableFloatBonus intPercentageBonus;

    public EmbeddableIntegerBonus getHpBonus() {
        return hpBonus;
    }

    public void setHpBonus(EmbeddableIntegerBonus hpBonus) {
        this.hpBonus = hpBonus;
    }

    public EmbeddableIntegerBonus getApBonus() {
        return apBonus;
    }

    public void setApBonus(EmbeddableIntegerBonus apBonus) {
        this.apBonus = apBonus;
    }

    public EmbeddableIntegerBonus getStrBonus() {
        return strBonus;
    }

    public void setStrBonus(EmbeddableIntegerBonus strBonus) {
        this.strBonus = strBonus;
    }

    public EmbeddableIntegerBonus getVitBonus() {
        return vitBonus;
    }

    public void setVitBonus(EmbeddableIntegerBonus vitBonus) {
        this.vitBonus = vitBonus;
    }

    public EmbeddableIntegerBonus getAgiBonus() {
        return agiBonus;
    }

    public void setAgiBonus(EmbeddableIntegerBonus agiBonus) {
        this.agiBonus = agiBonus;
    }

    public EmbeddableIntegerBonus getDexBonus() {
        return dexBonus;
    }

    public void setDexBonus(EmbeddableIntegerBonus dexBonus) {
        this.dexBonus = dexBonus;
    }

    public EmbeddableIntegerBonus getIntBonus() {
        return intBonus;
    }

    public void setIntBonus(EmbeddableIntegerBonus intBonus) {
        this.intBonus = intBonus;
    }

    public EmbeddableFloatBonus getHpPercentageBonus() {
        return hpPercentageBonus;
    }

    public void setHpPercentageBonus(EmbeddableFloatBonus hpPercentageBonus) {
        this.hpPercentageBonus = hpPercentageBonus;
    }

    public EmbeddableFloatBonus getApPercentageBonus() {
        return apPercentageBonus;
    }

    public void setApPercentageBonus(EmbeddableFloatBonus apPercentageBonus) {
        this.apPercentageBonus = apPercentageBonus;
    }

    public EmbeddableFloatBonus getStrPercentageBonus() {
        return strPercentageBonus;
    }

    public void setStrPercentageBonus(EmbeddableFloatBonus strPercentageBonus) {
        this.strPercentageBonus = strPercentageBonus;
    }

    public EmbeddableFloatBonus getVitPercentageBonus() {
        return vitPercentageBonus;
    }

    public void setVitPercentageBonus(EmbeddableFloatBonus vitPercentageBonus) {
        this.vitPercentageBonus = vitPercentageBonus;
    }

    public EmbeddableFloatBonus getAgiPercentageBonus() {
        return agiPercentageBonus;
    }

    public void setAgiPercentageBonus(EmbeddableFloatBonus agiPercentageBonus) {
        this.agiPercentageBonus = agiPercentageBonus;
    }

    public EmbeddableFloatBonus getDexPercentageBonus() {
        return dexPercentageBonus;
    }

    public void setDexPercentageBonus(EmbeddableFloatBonus dexPercentageBonus) {
        this.dexPercentageBonus = dexPercentageBonus;
    }

    public EmbeddableFloatBonus getIntPercentageBonus() {
        return intPercentageBonus;
    }

    public void setIntPercentageBonus(EmbeddableFloatBonus intPercentageBonus) {
        this.intPercentageBonus = intPercentageBonus;
    }

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
