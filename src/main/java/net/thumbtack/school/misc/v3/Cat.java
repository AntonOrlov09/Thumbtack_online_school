package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class Cat implements Colored {

    private Color color;
    private String name;

    public Cat(String name, Color color) throws ColorException {
        this.name = name;
        setColor(color);
    }

    public Cat(String name, String color) throws ColorException {
        this.name = name;
        setColor(color);
    }

    public Cat(Color color) throws ColorException {
        this("Vasya", color);
    }

    public Cat(String color) throws ColorException {
        this("Vasya", color);
    }

    public Cat() throws ColorException {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return getColor() == cat.getColor() &&
                getName().equals(cat.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getName());
    }
}
