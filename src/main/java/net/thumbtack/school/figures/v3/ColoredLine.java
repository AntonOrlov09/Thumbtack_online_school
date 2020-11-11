package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredLine extends Line implements Colored {

    private Color color;

    public ColoredLine(Point startPoint, Point endPoint, Color color) throws ColorException {
        super(startPoint, endPoint);
        setColor(color);
    }

    public ColoredLine(Point startPoint, Point endPoint, String color) throws ColorException {
        this(startPoint, endPoint, Color.colorFromString(color));
    }

    public ColoredLine(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredLine(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredLine(Point endPoint, Color color) throws ColorException {
        this(new Point(), endPoint, color);
    }

    public ColoredLine(Point endPoint, String color) throws ColorException {
        this(new Point(), endPoint, color);
    }

    public ColoredLine(int x, int y, Color color) throws ColorException {
        this(0, 0, x, y, color);
    }

    public ColoredLine(int x, int y, String color) throws ColorException {
        this(0, 0, x, y, color);
    }

    public ColoredLine(Color color) throws ColorException {
        this(1, 1, color);
    }

    public ColoredLine(String color) throws ColorException {
        this(1, 1, color);
    }

    public ColoredLine() throws ColorException {
        this(Color.RED);
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    @Override
    public Color getColor() {
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
