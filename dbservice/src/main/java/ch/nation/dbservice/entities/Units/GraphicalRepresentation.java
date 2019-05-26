package ch.nation.dbservice.entities.Units;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;

@Embeddable
public class GraphicalRepresentation {


    @JsonProperty("Beard")
    private String beard;

    @JsonProperty("Shield")
    private String shield;

    @JsonProperty("Expression.Default.Mouth")
    private String expressionDefaultMouth;

    @JsonProperty("Expression.Default.Eyebrows")
    private String expressionDefaultEyebrows;

    @JsonProperty("Expression.Dead.Eyes")
    private String expressionDeadEyes;

    @JsonProperty("Expression.Default.Eyes")
    private String expressionDefaultEyes;

    @JsonProperty("Helmet")
    private String helmet;

    @JsonProperty("Armor")
    private String armor;

    @JsonProperty("Back")
    private String back;

    @JsonProperty("Expression.Angry.Eyebrows")
    private String expressionAngryEyebrows;

    @JsonProperty("Body")
    private String body;

    @JsonProperty("Ears")
    private String ears;

    @JsonProperty("Hair")
    private String hair;

    @JsonProperty("FirearmParams")
    private String firearmParams;

    @JsonProperty("Head")
    private String head;

    @JsonProperty("Expression.Angry.Mouth")
    private String expressionAngryMouth;

    @JsonProperty("Mask")
    private String mask;

    @JsonProperty("Bow")
    private String bow;

    @JsonProperty("Firearms")
    private String firearms;

    @JsonProperty("Cape")
    private String cape;

    @JsonProperty("Expression.Dead.Mouth")
    private String expressionDeadMouth;

    @JsonProperty("Expression")
    private String expression;

    @JsonProperty("WeaponType")
    private String weaponType;

    @JsonProperty("Glasses")
    private String glasses;

    @JsonProperty("PrimaryMeleeWeapon")
    private String primaryMeleeWeapon;


    @JsonProperty("SecondaryMeleeWeapon")
    private String secondaryMeleeWeapon;

    @JsonProperty("Expression.Angry.Eyes")
    private String expressionAngryEyes;

    @JsonProperty("Expression.Dead.Eyebrows")
    private String expressionDeadEyebrows;


    public void setBeard(String beard){
        this.beard = beard;
    }

    public String getBeard(){
        return beard;
    }

    public void setShield(String shield){
        this.shield = shield;
    }

    public String getShield(){
        return shield;
    }

    public void setExpressionDefaultMouth(String expressionDefaultMouth){
        this.expressionDefaultMouth = expressionDefaultMouth;
    }

    public String getExpressionDefaultMouth(){
        return expressionDefaultMouth;
    }

    public void setExpressionDefaultEyebrows(String expressionDefaultEyebrows){
        this.expressionDefaultEyebrows = expressionDefaultEyebrows;
    }

    public String getExpressionDefaultEyebrows(){
        return expressionDefaultEyebrows;
    }

    public void setExpressionDeadEyes(String expressionDeadEyes){
        this.expressionDeadEyes = expressionDeadEyes;
    }

    public String getExpressionDeadEyes(){
        return expressionDeadEyes;
    }

    public void setExpressionDefaultEyes(String expressionDefaultEyes){
        this.expressionDefaultEyes = expressionDefaultEyes;
    }

    public String getExpressionDefaultEyes(){
        return expressionDefaultEyes;
    }

    public void setHelmet(String helmet){
        this.helmet = helmet;
    }

    public String getHelmet(){
        return helmet;
    }

    public void setArmor(String armor){
        this.armor = armor;
    }

    public String getArmor(){
        return armor;
    }

    public void setBack(String back){
        this.back = back;
    }

    public String getBack(){
        return back;
    }

    public void setExpressionAngryEyebrows(String expressionAngryEyebrows){
        this.expressionAngryEyebrows = expressionAngryEyebrows;
    }

    public String getExpressionAngryEyebrows(){
        return expressionAngryEyebrows;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getBody(){
        return body;
    }

    public void setEars(String ears){
        this.ears = ears;
    }

    public String getEars(){
        return ears;
    }

    public void setHair(String hair){
        this.hair = hair;
    }

    public String getHair(){
        return hair;
    }

    public void setFirearmParams(String firearmParams){
        this.firearmParams = firearmParams;
    }

    public String getFirearmParams(){
        return firearmParams;
    }

    public void setHead(String head){
        this.head = head;
    }

    public String getHead(){
        return head;
    }

    public void setExpressionAngryMouth(String expressionAngryMouth){
        this.expressionAngryMouth = expressionAngryMouth;
    }

    public String getExpressionAngryMouth(){
        return expressionAngryMouth;
    }

    public void setMask(String mask){
        this.mask = mask;
    }

    public String getMask(){
        return mask;
    }

    public void setBow(String bow){
        this.bow = bow;
    }

    public String getBow(){
        return bow;
    }

    public void setFirearms(String firearms){
        this.firearms = firearms;
    }

    public String getFirearms(){
        return firearms;
    }

    public void setCape(String cape){
        this.cape = cape;
    }

    public String getCape(){
        return cape;
    }

    public void setExpressionDeadMouth(String expressionDeadMouth){
        this.expressionDeadMouth = expressionDeadMouth;
    }

    public String getExpressionDeadMouth(){
        return expressionDeadMouth;
    }

    public void setExpression(String expression){
        this.expression = expression;
    }

    public String getExpression(){
        return expression;
    }

    public void setWeaponType(String weaponType){
        this.weaponType = weaponType;
    }

    public String getWeaponType(){
        return weaponType;
    }

    public void setGlasses(String glasses){
        this.glasses = glasses;
    }

    public String getGlasses(){
        return glasses;
    }

    public void setPrimaryMeleeWeapon(String primaryMeleeWeapon){
        this.primaryMeleeWeapon = primaryMeleeWeapon;
    }

    public String getPrimaryMeleeWeapon(){
        return primaryMeleeWeapon;
    }


    public void setSecondaryMeleeWeapon(String secondaryMeleeWeapon){
        this.secondaryMeleeWeapon = secondaryMeleeWeapon;
    }

    public String getSecondaryMeleeWeapon(){
        return secondaryMeleeWeapon;
    }

    public void setExpressionAngryEyes(String expressionAngryEyes){
        this.expressionAngryEyes = expressionAngryEyes;
    }

    public String getExpressionAngryEyes(){
        return expressionAngryEyes;
    }

    public void setExpressionDeadEyebrows(String expressionDeadEyebrows){
        this.expressionDeadEyebrows = expressionDeadEyebrows;
    }

    public String getExpressionDeadEyebrows(){
        return expressionDeadEyebrows;
    }


    @Override
    public String toString(){
        return
                "Equipment{" +
                        "beard = '" + beard + '\'' +
                        ",shield = '" + shield + '\'' +
                        ",expression.Default.Mouth = '" + expressionDefaultMouth + '\'' +
                        ",expression.Default.Eyebrows = '" + expressionDefaultEyebrows + '\'' +
                        ",expression.Dead.Eyes = '" + expressionDeadEyes + '\'' +
                        ",expression.Default.Eyes = '" + expressionDefaultEyes + '\'' +
                        ",helmet = '" + helmet + '\'' +
                        ",armor = '" + armor + '\'' +
                        ",back = '" + back + '\'' +
                        ",expression.Angry.Eyebrows = '" + expressionAngryEyebrows + '\'' +
                        ",body = '" + body + '\'' +
                        ",ears = '" + ears + '\'' +
                        ",hair = '" + hair + '\'' +
                        ",firearmParams = '" + firearmParams + '\'' +
                        ",head = '" + head + '\'' +
                        ",expression.Angry.Mouth = '" + expressionAngryMouth + '\'' +
                        ",mask = '" + mask + '\'' +
                        ",bow = '" + bow + '\'' +
                        ",firearms = '" + firearms + '\'' +
                        ",cape = '" + cape + '\'' +
                        ",expression.Dead.Mouth = '" + expressionDeadMouth + '\'' +
                        ",expression = '" + expression + '\'' +
                        ",weaponType = '" + weaponType + '\'' +
                        ",glasses = '" + glasses + '\'' +
                        ",primaryMeleeWeapon = '" + primaryMeleeWeapon + '\'' +
                        ",secondaryMeleeWeapon = '" + secondaryMeleeWeapon + '\'' +
                        ",expression.Angry.Eyes = '" + expressionAngryEyes + '\'' +
                        ",expression.Dead.Eyebrows = '" + expressionDeadEyebrows + '\'' +
                        "}";
    }



}
