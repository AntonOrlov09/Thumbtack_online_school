package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;
import net.thumbtack.school.iface.v3.HasMetrics;

import java.util.Objects;

public class Wall implements Colored, HasMetrics {

    private Color color;
    private double length;
    private double height;

    public Wall(Color color, double length, double height) throws ColorException {
        setColor(color);
        this.length = length;
        this.height = height;
    }

    public Wall(String color, double length, double height) throws ColorException {
        setColor(color);
        this.length = length;
        this.height = height;
    }

    public Wall(Color color, double length) throws ColorException {
        this(color, length, 3);
    }

    public Wall(String color, double length) throws ColorException {
        this(color, length, 3);
    }

    public Wall(Color color) throws ColorException {
        this(color, 5);
    }

    public Wall(String color) throws ColorException {
        this(color, 5);
    }

    public Wall() throws ColorException {
        this(Color.RED);
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

    public double getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return length * height;
    }

    @Override
    public double getPerimeter() {
        return length * 2 + height * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wall)) return false;
        Wall wall = (Wall) o;
        return getColor() == wall.getColor() &&
                Double.compare(wall.getLength(), getLength()) == 0 &&
                Double.compare(wall.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getLength(), getHeight());
    }
}
