package ch.nation.dbservice.entities.skills;

import ch.nation.core.model.Enums.ActionShape;
import ch.nation.core.model.Enums.AreaTileStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class ActionArea {

    @Column(name = "sizeXAxis")
    @JsonProperty("sizeXAxis")
    private int sizeInXAxis;

    @Column(name = "sizeYAxis")
    @JsonProperty("sizeYAxis")
    private int sizeInYAxis;

    @Column(name = "offsetXAxis")
    @JsonProperty("offsetXAxis")
    private int offsetInXAxis;

    @Column(name = "offsetYAxis")
    @JsonProperty("offsetYAxis")
    private int offsetInYAxis;

    @Enumerated(EnumType.STRING)
    @Column(name = "shape")
    @JsonProperty("shape")
    private ActionShape shape;

    @Enumerated(EnumType.STRING)
    @Column(name = "tile")
    @JsonProperty("tile")
    private AreaTileStyle tileStyle;


    @Column(name = "consider_blocked_tiles")
    @JsonProperty("consBlockedTiles")
    private boolean considerBlockedTiles;


    public ActionArea(int sizeInXAxis, int sizeInYAxis, int offsetInXAxis, int offsetInYAxis, boolean considerBlockedTiles, ActionShape shape, AreaTileStyle tileStyle) {
        this.sizeInXAxis = sizeInXAxis;
        this.sizeInYAxis = sizeInYAxis;
        this.offsetInXAxis = offsetInXAxis;
        this.offsetInYAxis = offsetInYAxis;
        this.shape = shape;
        this.tileStyle = tileStyle;
        this.considerBlockedTiles = considerBlockedTiles;
    }

    public ActionArea() {
        tileStyle = AreaTileStyle.ATTACK_AXE;
    }


    public AreaTileStyle getTileStyle() {
        return tileStyle;
    }


    public void setTileStyle(AreaTileStyle tileStyle) {
        this.tileStyle = tileStyle;
    }

    public boolean isConsiderBlockedTiles() {
        return considerBlockedTiles;
    }

    public void setConsiderBlockedTiles(boolean considerBlockedTiles) {
        this.considerBlockedTiles = considerBlockedTiles;
    }

    public int getSizeInXAxis() {
        return sizeInXAxis;
    }

    public void setSizeInXAxis(int sizeInXAxis) {
        this.sizeInXAxis = sizeInXAxis;
    }

    public int getSizeInYAxis() {
        return sizeInYAxis;
    }

    public void setSizeInYAxis(int sizeInYAxis) {
        this.sizeInYAxis = sizeInYAxis;
    }

    public int getOffsetInXAxis() {
        return offsetInXAxis;
    }

    public void setOffsetInXAxis(int offsetInXAxis) {
        this.offsetInXAxis = offsetInXAxis;
    }

    public int getOffsetInYAxis() {
        return offsetInYAxis;
    }

    public void setOffsetInYAxis(int offsetInYAxis) {
        this.offsetInYAxis = offsetInYAxis;
    }

    public ActionShape getShape() {
        return shape;
    }

    public void setShape(ActionShape shape) {
        this.shape = shape;
    }


    @Override
    public String toString() {
        return "ActionArea{" +
                "sizeInXAxis=" + sizeInXAxis +
                ", sizeInYAxis=" + sizeInYAxis +
                ", offsetInXAxis=" + offsetInXAxis +
                ", offsetInYAxis=" + offsetInYAxis +
                ", shape=" + shape +
                ", considerBlockedTiles=" + considerBlockedTiles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionArea)) return false;
        ActionArea that = (ActionArea) o;
        return sizeInXAxis == that.sizeInXAxis &&
                sizeInYAxis == that.sizeInYAxis &&
                offsetInXAxis == that.offsetInXAxis &&
                offsetInYAxis == that.offsetInYAxis &&
                shape == that.shape;
    }

    @Override
    public int hashCode() {

        return Objects.hash(sizeInXAxis, sizeInYAxis, offsetInXAxis, offsetInYAxis, shape);
    }
}
