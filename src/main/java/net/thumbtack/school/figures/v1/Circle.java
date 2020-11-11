package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {
    private Point center;
    private int radius;

    //Создает Circle по координатам центра и значению радиуса.
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    //Создает Circle по координатам центра и значению радиуса.
    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
    }

    //Создает Circle с центром в точке (0,0) указанного радиуса.
    public Circle(int radius) {
        this(new Point(0, 0), radius);
    }

    //Создает Circle с центром в точке (0,0) с радиусом 1.
    public Circle() {
        this(new Point(0, 0), 1);
    }

    //Возвращает центр Circle.
    public Point getCenter() {
        return center;
    }

    //Возвращает радиус Circle.
    public int getRadius() {
        return radius;
    }

    //Устанавливает центр Circle.
    public void setCenter(Point center) {
        this.center = center;
    }

    //Устанавливает радиус Circle.
    public void setRadius(int radius) {
        this.radius = radius;
    }

    //Передвигает Circle на (dx, dy).
    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    //Передвигает Circle в точку (x, y).
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    //Передвигает Circle в точку point.
    public void moveTo(Point point) {
        center.moveTo(point.getX(), point.getY());
    }

    //Увеличивает радиус Circle в ratio раз, не изменяя центра.
    public void resize(int ratio) {
        radius = radius * ratio;
    }

    //Возвращает площадь круга.
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //Возвращает периметр окружности (длину окружности).
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //Определяет, лежит ли точка (x, y) внутри Circle. Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return (x - center.getX()) * (x - center.getX()) + (y - center.getY()) * (y - center.getY()) <= radius * radius;
    }

    //Определяет, лежит ли точка point внутри Circle. Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    //методы equals и hashCode.
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
