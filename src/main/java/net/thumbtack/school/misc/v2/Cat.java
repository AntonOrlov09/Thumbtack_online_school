package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class Cat implements Colored {

    private int color;
    private String name;

    public Cat(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public Cat(int color) {
        this("Vasya", color);
    }

    public Cat() {
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
