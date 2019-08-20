package ch.nation.dbservice.entities.bonus;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

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
    @Column(name="vitBonusPerc")
    @JsonProperty("vitBonusPerc")
    private EmbeddableFloatBonus vitPercentageBonus;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "agi_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "agi_perc_stat_target")),

    })
    @Column(name="agiBonusPerc")
    @JsonProperty("agiBonusPerc")
    private EmbeddableFloatBonus agiPercentageBonus;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "dex_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "dex_perc_stat_target")),

    })
    @Column(name="dexBonusPerc")
    @JsonProperty("dexBonusPerc")
    private EmbeddableFloatBonus dexPercentageBonus;




    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bonus", column = @Column(name = "int_perc_bonus")),
            @AttributeOverride(name = "statTarget", column = @Column(name = "int_perc_stat_target")),

    })
    @Column(name="intBonusPerc")
    @JsonProperty("intBonusPerc")
    private EmbeddableFloatBonus intPercentageBonus;


    public EmbeddableIntegerBonus getHpBonus() {
        if(hpBonus==null) hpBonus = new EmbeddableIntegerBonus();

        return hpBonus;
    }

    public void setHpBonus(EmbeddableIntegerBonus hpBonus) {
        this.hpBonus = hpBonus;
    }

    public EmbeddableIntegerBonus getApBonus() {
        if(apBonus ==null) apBonus = new EmbeddableIntegerBonus();


        return apBonus;
    }

    public void setApBonus(EmbeddableIntegerBonus apBonus) {
        this.apBonus = apBonus;
    }

    public EmbeddableIntegerBonus getStrBonus() {

       if(strBonus==null) strBonus =new EmbeddableIntegerBonus();

        return strBonus;
    }

    public void setStrBonus(EmbeddableIntegerBonus strBonus) {


        this.strBonus = strBonus;
    }

    public EmbeddableIntegerBonus getVitBonus() {
        if(vitBonus==null) vitBonus = new EmbeddableIntegerBonus();
        return vitBonus;
    }

    public void setVitBonus(EmbeddableIntegerBonus vitBonus) {
        this.vitBonus = vitBonus;
    }

    public EmbeddableIntegerBonus getAgiBonus() {
        if(agiBonus==null) agiBonus = new EmbeddableIntegerBonus();

        return agiBonus;
    }

    public void setAgiBonus(EmbeddableIntegerBonus agiBonus) {
        this.agiBonus = agiBonus;
    }

    public EmbeddableIntegerBonus getDexBonus() {
        if(dexBonus==null) dexBonus = new EmbeddableIntegerBonus();

        return dexBonus;
    }

    public void setDexBonus(EmbeddableIntegerBonus dexBonus) {
        this.dexBonus = dexBonus;
    }

    public EmbeddableIntegerBonus getIntBonus() {

        if(intBonus == null) intBonus = new EmbeddableIntegerBonus();

        return intBonus;
    }

    public void setIntBonus(EmbeddableIntegerBonus intBonus) {
        this.intBonus = intBonus;
    }

    public EmbeddableFloatBonus getHpPercentageBonus() {


        if(hpPercentageBonus ==null) hpPercentageBonus = new EmbeddableFloatBonus();

        return hpPercentageBonus;
    }

    public void setHpPercentageBonus(EmbeddableFloatBonus hpPercentageBonus) {
        this.hpPercentageBonus = hpPercentageBonus;
    }

    public EmbeddableFloatBonus getApPercentageBonus() {
        if(apPercentageBonus ==null) apPercentageBonus = new EmbeddableFloatBonus();


        return apPercentageBonus;
    }

    public void setApPercentageBonus(EmbeddableFloatBonus apPercentageBonus) {
        this.apPercentageBonus = apPercentageBonus;
    }

    public EmbeddableFloatBonus getStrPercentageBonus() {

        if(strPercentageBonus== null) strPercentageBonus = new EmbeddableFloatBonus();

        return strPercentageBonus;
    }

    public void setStrPercentageBonus(EmbeddableFloatBonus strPercentageBonus) {
        this.strPercentageBonus = strPercentageBonus;
    }

    public EmbeddableFloatBonus getVitPercentageBonus() {
        if(vitPercentageBonus == null) vitPercentageBonus = new EmbeddableFloatBonus();

        return vitPercentageBonus;
    }

    public void setVitPercentageBonus(EmbeddableFloatBonus vitPercentageBonus) {
        this.vitPercentageBonus = vitPercentageBonus;
    }

    public EmbeddableFloatBonus getAgiPercentageBonus() {

        if(agiPercentageBonus==null) agiPercentageBonus = new EmbeddableFloatBonus();

        return agiPercentageBonus;
    }

    public void setAgiPercentageBonus(EmbeddableFloatBonus agiPercentageBonus) {
        this.agiPercentageBonus = agiPercentageBonus;
    }

    public EmbeddableFloatBonus getDexPercentageBonus() {

        if(dexPercentageBonus==null) dexPercentageBonus = new EmbeddableFloatBonus();


        return dexPercentageBonus;
    }

    public void setDexPercentageBonus(EmbeddableFloatBonus dexPercentageBonus) {
        this.dexPercentageBonus = dexPercentageBonus;
    }

    public EmbeddableFloatBonus getIntPercentageBonus() {

        if(intPercentageBonus ==null) intPercentageBonus = new EmbeddableFloatBonus();


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatBonusDelta)) return false;
        StatBonusDelta that = (StatBonusDelta) o;
        return Objects.equals(hpBonus, that.hpBonus) &&
                Objects.equals(apBonus, that.apBonus) &&
                Objects.equals(strBonus, that.strBonus) &&
                Objects.equals(vitBonus, that.vitBonus) &&
                Objects.equals(agiBonus, that.agiBonus) &&
                Objects.equals(dexBonus, that.dexBonus) &&
                Objects.equals(intBonus, that.intBonus) &&
                Objects.equals(hpPercentageBonus, that.hpPercentageBonus) &&
                Objects.equals(apPercentageBonus, that.apPercentageBonus) &&
                Objects.equals(strPercentageBonus, that.strPercentageBonus) &&
                Objects.equals(vitPercentageBonus, that.vitPercentageBonus) &&
                Objects.equals(agiPercentageBonus, that.agiPercentageBonus) &&
                Objects.equals(dexPercentageBonus, that.dexPercentageBonus) &&
                Objects.equals(intPercentageBonus, that.intPercentageBonus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hpBonus, apBonus, strBonus, vitBonus, agiBonus, dexBonus, intBonus, hpPercentageBonus, apPercentageBonus, strPercentageBonus, vitPercentageBonus, agiPercentageBonus, dexPercentageBonus, intPercentageBonus);
    }
}
