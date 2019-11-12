package ch.nation.core.model.dto.unit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitAssetsDto extends AbstractAssetsDto{



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

    @JsonProperty("skin.color.r")
    private float skinColorRed;
    @JsonProperty("skin.color.g")
    private float skinColorGreen;
    @JsonProperty("skin.color.b")
    private float skinColorBlue;

    @JsonProperty("skin.color.a")
    private float skinColorAlpha;


    @JsonProperty("height")
    private float height;

    @JsonProperty("width")
    private float width;



    public UnitAssetsDto() {
    }


    public String getBeard() {
        return beard;
    }

    public void setBeard(String beard) {
        this.beard = beard;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getExpressionDefaultMouth() {
        return expressionDefaultMouth;
    }

    public void setExpressionDefaultMouth(String expressionDefaultMouth) {
        this.expressionDefaultMouth = expressionDefaultMouth;
    }

    public String getExpressionDefaultEyebrows() {
        return expressionDefaultEyebrows;
    }

    public void setExpressionDefaultEyebrows(String expressionDefaultEyebrows) {
        this.expressionDefaultEyebrows = expressionDefaultEyebrows;
    }

    public String getExpressionDeadEyes() {
        return expressionDeadEyes;
    }

    public void setExpressionDeadEyes(String expressionDeadEyes) {
        this.expressionDeadEyes = expressionDeadEyes;
    }

    public String getExpressionDefaultEyes() {
        return expressionDefaultEyes;
    }

    public void setExpressionDefaultEyes(String expressionDefaultEyes) {
        this.expressionDefaultEyes = expressionDefaultEyes;
    }

    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getExpressionAngryEyebrows() {
        return expressionAngryEyebrows;
    }

    public void setExpressionAngryEyebrows(String expressionAngryEyebrows) {
        this.expressionAngryEyebrows = expressionAngryEyebrows;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEars() {
        return ears;
    }

    public void setEars(String ears) {
        this.ears = ears;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getFirearmParams() {
        return firearmParams;
    }

    public void setFirearmParams(String firearmParams) {
        this.firearmParams = firearmParams;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getExpressionAngryMouth() {
        return expressionAngryMouth;
    }

    public void setExpressionAngryMouth(String expressionAngryMouth) {
        this.expressionAngryMouth = expressionAngryMouth;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getBow() {
        return bow;
    }

    public void setBow(String bow) {
        this.bow = bow;
    }

    public String getFirearms() {
        return firearms;
    }

    public void setFirearms(String firearms) {
        this.firearms = firearms;
    }

    public String getCape() {
        return cape;
    }

    public void setCape(String cape) {
        this.cape = cape;
    }

    public String getExpressionDeadMouth() {
        return expressionDeadMouth;
    }

    public void setExpressionDeadMouth(String expressionDeadMouth) {
        this.expressionDeadMouth = expressionDeadMouth;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public String getPrimaryMeleeWeapon() {
        return primaryMeleeWeapon;
    }

    public void setPrimaryMeleeWeapon(String primaryMeleeWeapon) {
        this.primaryMeleeWeapon = primaryMeleeWeapon;
    }

    public String getSecondaryMeleeWeapon() {
        return secondaryMeleeWeapon;
    }

    public void setSecondaryMeleeWeapon(String secondaryMeleeWeapon) {
        this.secondaryMeleeWeapon = secondaryMeleeWeapon;
    }

    public String getExpressionAngryEyes() {
        return expressionAngryEyes;
    }

    public void setExpressionAngryEyes(String expressionAngryEyes) {
        this.expressionAngryEyes = expressionAngryEyes;
    }

    public String getExpressionDeadEyebrows() {
        return expressionDeadEyebrows;
    }

    public void setExpressionDeadEyebrows(String expressionDeadEyebrows) {
        this.expressionDeadEyebrows = expressionDeadEyebrows;
    }

    public float getSkinColorRed() {
        return skinColorRed;
    }

    public void setSkinColorRed(float skinColorRed) {
        this.skinColorRed = skinColorRed;
    }

    public float getSkinColorGreen() {
        return skinColorGreen;
    }

    public void setSkinColorGreen(float skinColorGreen) {
        this.skinColorGreen = skinColorGreen;
    }

    public float getSkinColorBlue() {
        return skinColorBlue;
    }

    public void setSkinColorBlue(float skinColorBlue) {
        this.skinColorBlue = skinColorBlue;
    }

    public float getSkinColorAlpha() {
        return skinColorAlpha;
    }

    public void setSkinColorAlpha(float skinColorAlpha) {
        this.skinColorAlpha = skinColorAlpha;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "UnitAssetsDto{" +
                "beard='" + beard + '\'' +
                ", shield='" + shield + '\'' +
                ", expressionDefaultMouth='" + expressionDefaultMouth + '\'' +
                ", expressionDefaultEyebrows='" + expressionDefaultEyebrows + '\'' +
                ", expressionDeadEyes='" + expressionDeadEyes + '\'' +
                ", expressionDefaultEyes='" + expressionDefaultEyes + '\'' +
                ", helmet='" + helmet + '\'' +
                ", armor='" + armor + '\'' +
                ", back='" + back + '\'' +
                ", expressionAngryEyebrows='" + expressionAngryEyebrows + '\'' +
                ", body='" + body + '\'' +
                ", ears='" + ears + '\'' +
                ", hair='" + hair + '\'' +
                ", firearmParams='" + firearmParams + '\'' +
                ", head='" + head + '\'' +
                ", expressionAngryMouth='" + expressionAngryMouth + '\'' +
                ", mask='" + mask + '\'' +
                ", bow='" + bow + '\'' +
                ", firearms='" + firearms + '\'' +
                ", cape='" + cape + '\'' +
                ", expressionDeadMouth='" + expressionDeadMouth + '\'' +
                ", expression='" + expression + '\'' +
                ", weaponType='" + weaponType + '\'' +
                ", glasses='" + glasses + '\'' +
                ", primaryMeleeWeapon='" + primaryMeleeWeapon + '\'' +
                ", secondaryMeleeWeapon='" + secondaryMeleeWeapon + '\'' +
                ", expressionAngryEyes='" + expressionAngryEyes + '\'' +
                ", expressionDeadEyebrows='" + expressionDeadEyebrows + '\'' +
                "} " + super.toString();
    }
}
