package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class ColoredPolyLine extends PolyLine {

    private int color;

    public ColoredPolyLine(Point[] points, int color) {
        super(points);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredPolyLine)) return false;
        if (!super.equals(o)) return false;
        ColoredPolyLine that = (ColoredPolyLine) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
