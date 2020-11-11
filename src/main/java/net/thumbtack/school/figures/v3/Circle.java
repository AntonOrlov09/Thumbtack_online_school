package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Circle extends ClosedFigure {
    private Point center;
    private int radius;


    public Circle(Point center, int radius) {
        super();
        this.center = center;
        this.radius = radius;
    }


    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
    }


    public Circle(int radius) {
        this(new Point(0, 0), radius);
    }


    public Circle() {
        this(new Point(0, 0), 1);
    }


    public Point getCenter() {
        return center;
    }


    public int getRadius() {
        return radius;
    }


    public void setCenter(Point center) {
        this.center = center;
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }


    @Override
    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }


    @Override
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }


    @Override
    public void resize(int ratio) {
        radius = radius * ratio;
    }


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }


    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }


    @Override
    public boolean isInside(int x, int y) {
        return (x - center.getX()) * (x - center.getX()) + (y - center.getY()) * (y - center.getY()) <= radius * radius;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius() &&
                getCenter().equals(circle.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter(), getRadius());
    }
}
