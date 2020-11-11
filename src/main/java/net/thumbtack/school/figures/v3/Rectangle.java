package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Rectangle extends ClosedFigure {
    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        super();
        this.rightBottom = rightBottom;
        this.leftTop = leftTop;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(new Point(0, -width), new Point(length, 0));
    }

    public Rectangle() {
        this(new Point(0, -1), new Point(1, 0));
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    @Override
    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    @Override
    public void moveTo(int x, int y) {
        rightBottom.moveTo(x + getLength(), y + getWidth());
        leftTop.moveTo(x, y);
    }

    @Override
    public void resize(int ratio) {
        rightBottom.setX(leftTop.getX() + getLength() * ratio);
        rightBottom.setY(leftTop.getY() + getWidth() * ratio);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return getLength() * 2 + getWidth() * 2;
    }

    @Override
    public boolean isInside(int x, int y) {
        return (x >= leftTop.getX()) && (y >= leftTop.getY()) && (x <= rightBottom.getX()) && (y <= rightBottom.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return leftTop.getX() <= rectangle.getBottomRight().getX() &&
                rightBottom.getX() >= rectangle.getTopLeft().getX() &&
                leftTop.getY() <= rectangle.getBottomRight().getY() &&
                rightBottom.getY() >= rectangle.getTopLeft().getY();
    }

    public boolean isInside(Rectangle rectangle) {
        return (leftTop.getX() <= rectangle.getTopLeft().getX()) &&
                (rightBottom.getX() >= rectangle.getBottomRight().getX()) &&
                (leftTop.getY() <= rectangle.getTopLeft().getY()) &&
                (rightBottom.getY() >= rectangle.getBottomRight().getY());
    }

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