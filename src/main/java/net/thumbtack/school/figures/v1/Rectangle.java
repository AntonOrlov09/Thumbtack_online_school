package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point leftTop;
    private Point rightBottom;

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(Point leftTop, Point rightBottom) {
        this.rightBottom = rightBottom;
        this.leftTop = leftTop;
    }

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    //Создает Rectangle, левый нижний угол которого находится в начале координат, а  длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width) {
        this(new Point(0, -width), new Point(length, 0));
    }

    //Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle() {
        this(new Point(0, -1), new Point(1, 0));
    }

    //Возвращает левую верхнюю точку Rectangle.
    public Point getTopLeft() {
        return leftTop;
    }

    //Возвращает правую нижнюю точку Rectangle.
    public Point getBottomRight() {
        return rightBottom;
    }

    //Устанавливает левую верхнюю точку Rectangle.
    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    //Устанавливает правую нижнюю точку Rectangle.
    public void setBottomRight(Point bottomRight) {
        this.rightBottom = bottomRight;
    }

    //Возвращает длину прямоугольника
    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    //Возвращает ширину прямоугольника.
    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    //Передвигает Rectangle на (dx, dy).
    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    //Передвигает Rectangle в точку (x, y)
    public void moveTo(int x, int y) {
        rightBottom.moveTo(x + getLength(), y + getWidth());
        leftTop.moveTo(x, y);
    }

    //Передвигает Rectangle в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    //Увеличивает стороны Rectangle в ratio раз при сохранении координат левой верхней вершины
    public void resize(int ratio) {
        rightBottom.setX(leftTop.getX() + getLength() * ratio);
        rightBottom.setY(leftTop.getY() + getWidth() * ratio);
    }

    //Возвращает площадь прямоугольника.
    public double getArea() {
        return getLength() * getWidth();
    }

    //Возвращает периметр прямоугольника.
    public double getPerimeter() {
        return getLength() * 2 + getWidth() * 2;
    }

    //Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return (x >= leftTop.getX()) && (y >= leftTop.getY()) && (x <= rightBottom.getX()) && (y <= rightBottom.getY());
    }

    public boolean isInside(Point point) {
        return (point.getX() >= leftTop.getX()) && (point.getY() >= leftTop.getY()) && (point.getX() <= rightBottom.getX()) && (point.getY() <= rightBottom.getY());
    }

    //Определяет, пересекается  ли Rectangle с другим Rectangle. Считается, что прямоугольники пересекаются, если у них есть хоть одна общая точка.
    public boolean isIntersects(Rectangle rectangle) {
        return leftTop.getX() <= rectangle.getBottomRight().getX() &&
                rightBottom.getX() >= rectangle.getTopLeft().getX() &&
                leftTop.getY() <= rectangle.getBottomRight().getY() &&
                rightBottom.getY() >= rectangle.getTopLeft().getY();
    }

    //Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle) {
        return (leftTop.getX() <= rectangle.getTopLeft().getX()) &&
                (rightBottom.getX() >= rectangle.getBottomRight().getX()) &&
                (leftTop.getY() <= rectangle.getTopLeft().getY()) &&
                (rightBottom.getY() >= rectangle.getBottomRight().getY());
    }

    //методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return leftTop.equals(rectangle.leftTop) &&
                rightBottom.equals(rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, rightBottom);
    }
}