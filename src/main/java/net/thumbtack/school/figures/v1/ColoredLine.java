package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class ColoredLine extends Line {

    private int color;

    public ColoredLine(Point startPoint, Point endPoint, int color) {
        super(startPoint, endPoint);
        this.color = color;
    }

    public ColoredLine(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredLine(Point endPoint, int color) {
        this(new Point(), endPoint, color);
    }

    public ColoredLine(int x, int y, int color) {
        this(0, 0, x, y, color);
    }

    public ColoredLine(int color) {
        this(1, 1, color);
    }

    public ColoredLine() {
        this(1);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredLine)) return false;
        if (!super.equals(o)) return false;
        ColoredLine that = (ColoredLine) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
