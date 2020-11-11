package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredPolyLine extends PolyLine implements Colored {

    private Color color;

    public ColoredPolyLine(Point[] points, Color color) throws ColorException {
        super(points);
        setColor(color);
    }

    public ColoredPolyLine(Point[] points, String color) throws ColorException {
        this(points, Color.colorFromString(color));
    }

    @Override
    public Color getColor() {
        return color;
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
