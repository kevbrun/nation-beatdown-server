package ch.nation.dbservice.entities;

import ch.nation.dbservice.entities.enums.ActionShape;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ActionArea {

        @Column(name="sizeXAxis")
        private int sizeInXAxis;

        @Column(name="sizeYAxis")
        private int sizeInYAxis;

        @Column(name="offsetXAxis")
        private int offsetInXAxis;

        @Column(name="offsetYAxis")
        private int offsetInYAxis;

        @Enumerated(EnumType.STRING)
        private ActionShape shape;


    public ActionArea(int sizeInXAxis, int sizeInYAxis, int offsetInXAxis, int offsetInYAxis, ActionShape shape) {
        this.sizeInXAxis = sizeInXAxis;
        this.sizeInYAxis = sizeInYAxis;
        this.offsetInXAxis = offsetInXAxis;
        this.offsetInYAxis = offsetInYAxis;
        this.shape = shape;
    }

    public ActionArea() {
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
