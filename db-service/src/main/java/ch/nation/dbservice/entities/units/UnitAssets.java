package ch.nation.dbservice.entities.units;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class UnitAssets {


    @JsonProperty("Beard")
    @Column(length = 100)
    private String beard;

    @JsonProperty("Shield")
    @Column(length = 100)
    private String shield;

    @JsonProperty("Expression.Default.Mouth")
    @Column(length = 100)
    private String expressionDefaultMouth;

    @JsonProperty("Expression.Default.Eyebrows")
    @Column(length = 100)
    private String expressionDefaultEyebrows;

    @JsonProperty("Expression.Dead.Eyes")
    @Column(length = 100)
    private String expressionDeadEyes;

    @JsonProperty("Expression.Default.Eyes")
    @Column(length = 100)
    private String expressionDefaultEyes;

    @JsonProperty("Helmet")
    @Column(length = 100)
    private String helmet;

    @JsonProperty("Armor")
    @Column(length = 100)
    private String armor;

    @JsonProperty("Back")
    @Column(length = 100)
    private String back;

    @JsonProperty("Expression.Angry.Eyebrows")
    @Column(length = 100)
    private String expressionAngryEyebrows;

    @JsonProperty("Body")
    @Column(length = 100)
    private String body;

    @JsonProperty("Ears")
    @Column(length = 100)
    private String ears;

    @JsonProperty("Hair")
    @Column(length = 100)
    private String hair;

    @JsonProperty("FirearmParams")
    @Column(length = 100)
    private String firearmParams;

    @JsonProperty("Head")
    @Column(length = 100)
    private String head;

    @JsonProperty("Expression.Angry.Mouth")
    @Column(length = 100)
    private String expressionAngryMouth;

    @JsonProperty("Mask")
    @Column(length = 100)
    private String mask;

    @JsonProperty("Bow")
    @Column(length = 100)
    private String bow;

    @JsonProperty("Firearms")
    @Column(length = 100)
    private String firearms;

    @JsonProperty("Cape")
    @Column(length = 100)
    private String cape;

    @JsonProperty("Expression.Dead.Mouth")
    @Column(length = 100)
    private String expressionDeadMouth;

    @JsonProperty("Expression")
    @Column(length = 100)
    private String expression;

    @JsonProperty("WeaponType")
    @Column(length = 100)
    private String weaponType;

    @JsonProperty("Glasses")
    @Column(length = 100)
    private String glasses;

    @JsonProperty("PrimaryMeleeWeapon")
    @Column(length = 100)
    private String primaryMeleeWeapon;


    @JsonProperty("SecondaryMeleeWeapon")
    @Column(length = 100)
    private String secondaryMeleeWeapon;

    @JsonProperty("Expression.Angry.Eyes")
    @Column(length = 100)
    private String expressionAngryEyes;

    @JsonProperty("Expression.Dead.Eyebrows")
    @Column(length = 100)
    private String expressionDeadEyebrows;

    @JsonProperty("skin.color.r")
    @Column(name = "skin_color_red")
    private float skinColorRed;
    @JsonProperty("skin.color.g")
    @Column(name = "skin_color_green")
    private float skinColorGreen;
    @JsonProperty("skin.color.b")
    @Column(name = "skin_color_blue")
    private float skinColorBlue;

    @JsonProperty("skin.color.a")
    @Column(name = "skin_color_alpha")
    private float skinColorAlpha;


    @JsonProperty("height")
    @Column(name = "height")
    private float height;

    @JsonProperty("width")
    @Column(name = "width")
    private float width;

    @JsonProperty("rem_mouth")
    @Column(name = "remove_mouth")
    private boolean removeMouth;

    public UnitAssets() {
        removeMouth = false;
        skinColorRed = 255f;
        skinColorGreen = 190f;
        skinColorBlue = 120f;
        skinColorAlpha = 255f;
        width = 1.0f;
        height = 0.1f;
    }


    public float getSkinColorAlpha() {
        return skinColorAlpha;
    }

    public void setSkinColorAlpha(float skinColorAlpha) {
        this.skinColorAlpha = skinColorAlpha;
    }

    public boolean isRemoveMouth() {
        return removeMouth;
    }

    public void setRemoveMouth(boolean removeMouth) {
        this.removeMouth = removeMouth;
    }

    public void setBeard(String beard) {
        this.beard = beard;
    }

    public String getBeard() {
        return beard;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getShield() {
        return shield;
    }

    public void setExpressionDefaultMouth(String expressionDefaultMouth) {
        this.expressionDefaultMouth = expressionDefaultMouth;
    }

    public String getExpressionDefaultMouth() {
        return expressionDefaultMouth;
    }

    public void setExpressionDefaultEyebrows(String expressionDefaultEyebrows) {
        this.expressionDefaultEyebrows = expressionDefaultEyebrows;
    }

    public String getExpressionDefaultEyebrows() {
        return expressionDefaultEyebrows;
    }

    public void setExpressionDeadEyes(String expressionDeadEyes) {
        this.expressionDeadEyes = expressionDeadEyes;
    }

    public String getExpressionDeadEyes() {
        return expressionDeadEyes;
    }

    public void setExpressionDefaultEyes(String expressionDefaultEyes) {
        this.expressionDefaultEyes = expressionDefaultEyes;
    }

    public String getExpressionDefaultEyes() {
        return expressionDefaultEyes;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    public String getHelmet() {
        return helmet;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getArmor() {
        return armor;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getBack() {
        return back;
    }

    public void setExpressionAngryEyebrows(String expressionAngryEyebrows) {
        this.expressionAngryEyebrows = expressionAngryEyebrows;
    }

    public String getExpressionAngryEyebrows() {
        return expressionAngryEyebrows;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setEars(String ears) {
        this.ears = ears;
    }

    public String getEars() {
        return ears;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getHair() {
        return hair;
    }

    public void setFirearmParams(String firearmParams) {
        this.firearmParams = firearmParams;
    }

    public String getFirearmParams() {
        return firearmParams;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setExpressionAngryMouth(String expressionAngryMouth) {
        this.expressionAngryMouth = expressionAngryMouth;
    }

    public String getExpressionAngryMouth() {
        return expressionAngryMouth;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }

    public void setBow(String bow) {
        this.bow = bow;
    }

    public String getBow() {
        return bow;
    }

    public void setFirearms(String firearms) {
        this.firearms = firearms;
    }

    public String getFirearms() {
        return firearms;
    }

    public void setCape(String cape) {
        this.cape = cape;
    }

    public String getCape() {
        return cape;
    }

    public void setExpressionDeadMouth(String expressionDeadMouth) {
        this.expressionDeadMouth = expressionDeadMouth;
    }

    public String getExpressionDeadMouth() {
        return expressionDeadMouth;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setPrimaryMeleeWeapon(String primaryMeleeWeapon) {
        this.primaryMeleeWeapon = primaryMeleeWeapon;
    }

    public String getPrimaryMeleeWeapon() {
        return primaryMeleeWeapon;
    }


    public void setSecondaryMeleeWeapon(String secondaryMeleeWeapon) {
        this.secondaryMeleeWeapon = secondaryMeleeWeapon;
    }

    public String getSecondaryMeleeWeapon() {
        return secondaryMeleeWeapon;
    }

    public void setExpressionAngryEyes(String expressionAngryEyes) {
        this.expressionAngryEyes = expressionAngryEyes;
    }

    public String getExpressionAngryEyes() {
        return expressionAngryEyes;
    }

    public void setExpressionDeadEyebrows(String expressionDeadEyebrows) {
        this.expressionDeadEyebrows = expressionDeadEyebrows;
    }

    public String getExpressionDeadEyebrows() {
        return expressionDeadEyebrows;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnitAssets)) return false;
        UnitAssets that = (UnitAssets) o;
        return Objects.equals(beard, that.beard) &&
                Objects.equals(shield, that.shield) &&
                Objects.equals(expressionDefaultMouth, that.expressionDefaultMouth) &&
                Objects.equals(expressionDefaultEyebrows, that.expressionDefaultEyebrows) &&
                Objects.equals(expressionDeadEyes, that.expressionDeadEyes) &&
                Objects.equals(expressionDefaultEyes, that.expressionDefaultEyes) &&
                Objects.equals(helmet, that.helmet) &&
                Objects.equals(armor, that.armor) &&
                Objects.equals(back, that.back) &&
                Objects.equals(expressionAngryEyebrows, that.expressionAngryEyebrows) &&
                Objects.equals(body, that.body) &&
                Objects.equals(ears, that.ears) &&
                Objects.equals(hair, that.hair) &&
                Objects.equals(firearmParams, that.firearmParams) &&
                Objects.equals(head, that.head) &&
                Objects.equals(expressionAngryMouth, that.expressionAngryMouth) &&
                Objects.equals(mask, that.mask) &&
                Objects.equals(bow, that.bow) &&
                Objects.equals(firearms, that.firearms) &&
                Objects.equals(cape, that.cape) &&
                Objects.equals(expressionDeadMouth, that.expressionDeadMouth) &&
                Objects.equals(expression, that.expression) &&
                Objects.equals(weaponType, that.weaponType) &&
                Objects.equals(glasses, that.glasses) &&
                Objects.equals(primaryMeleeWeapon, that.primaryMeleeWeapon) &&
                Objects.equals(secondaryMeleeWeapon, that.secondaryMeleeWeapon) &&
                Objects.equals(expressionAngryEyes, that.expressionAngryEyes) &&
                Objects.equals(expressionDeadEyebrows, that.expressionDeadEyebrows);
    }

    @Override
    public int hashCode() {

        return Objects.hash(beard, shield, expressionDefaultMouth, expressionDefaultEyebrows, expressionDeadEyes, expressionDefaultEyes, helmet, armor, back, expressionAngryEyebrows, body, ears, hair, firearmParams, head, expressionAngryMouth, mask, bow, firearms, cape, expressionDeadMouth, expression, weaponType, glasses, primaryMeleeWeapon, secondaryMeleeWeapon, expressionAngryEyes, expressionDeadEyebrows);
    }
}
