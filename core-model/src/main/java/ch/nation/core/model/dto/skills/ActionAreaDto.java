package ch.nation.core.model.dto.skills;

import ch.nation.core.model.Enums.ActionShape;
import ch.nation.core.model.Enums.AreaTileStyle;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ActionAreaDto {


    @JsonProperty("sizeXAxis")
    private int sizeInXAxis;


    @JsonProperty("sizeYAxis")
    private int sizeInYAxis;


    @JsonProperty("offsetXAxis")
    private int offsetInXAxis;


    @JsonProperty("offsetYAxis")
    private int offsetInYAxis;


    @JsonProperty("shape")
    private ActionShape shape;


    @JsonProperty("tile")
    private AreaTileStyle tileStyle;


    @JsonProperty("consBlockedTiles")
    private boolean considerBlockedTiles;

    public ActionAreaDto(int sizeInXAxis, int sizeInYAxis, int offsetInXAxis, int offsetInYAxis,boolean considerBlockedTiles, ActionShape shape) {
        this.sizeInXAxis = sizeInXAxis;
        this.sizeInYAxis = sizeInYAxis;
        this.offsetInXAxis = offsetInXAxis;
        this.offsetInYAxis = offsetInYAxis;
        this.shape = shape;
        this.considerBlockedTiles = considerBlockedTiles;
    }

    public ActionAreaDto() {
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
                '}';
    }
}
