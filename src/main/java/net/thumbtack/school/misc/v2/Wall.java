package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;
import net.thumbtack.school.iface.v2.HasMetrics;

import java.util.Objects;

public class Wall implements Colored, HasMetrics {

    private int color;
    private double length;
    private double height;

    public Wall(int color, double length, double height) {
        this.color = color;
        this.length = length;
        this.height = height;
    }

    public Wall(int color, double length) {
        this(color, length, 3);
    }

    public Wall(int color) {
        this(color, 5);
    }

    public Wall() {
        this(1);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
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
