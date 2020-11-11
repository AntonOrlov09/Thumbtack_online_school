package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Line {

    private Point startPoint;
    private Point endPoint;

    //Создает Line по координатам двух точек.
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    //Создает Line по координатам двух точек.
    public Line(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    //Создает Line из начала координат в точку endPoint
    public Line(Point endPoint) {
        this(new Point(0, 0), endPoint);
    }

    //Создает Line из начала координат в точку (x, y)
    public Line(int x, int y) {
        this(new Point(0, 0), new Point(x, y));
    }

    //Создает Line из начала координат в точку (1,1)
    public Line() {
        this(new Point(0, 0), new Point(1, 1));
    }

    //Возвращает точку начала Line.
    public Point getStartPoint() {
        return startPoint;
    }

    // Возвращает точку конца Line.
    public Point getEndPoint() {
        return endPoint;
    }

    //Устанавливает точку начала Line
    public void setStartPoint(Point point) {
        this.startPoint = point;
    }

    //Устанавливает точку конца Line.
    public void setEndPoint(Point point) {
        this.endPoint = point;
    }

    //Возвращает длину Line.
    public double getLength() {
        int X = endPoint.getX() - startPoint.getX();
        int Y = endPoint.getY() - startPoint.getY();
        return Math.sqrt(X * X + Y * Y);
    }

    //Конгруэнтно передвигает Line так, чтобы startPoint оказалась в точке (x, y).
    public void moveTo(int x, int y) {
        int dX = x - startPoint.getX();
        int dY = y - startPoint.getY();
        endPoint.moveTo(endPoint.getX() + dX, endPoint.getY() + dY);
        startPoint.moveTo(x, y);
    }

    //Конгруэнтно передвигает Line так, чтобы startPoint оказалась в точке point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    //Конгруэнтно передвигает Line на (dx, dy).
    public void moveRel(int dx, int dy) {
        startPoint.moveRel(dx, dy);
        endPoint.moveRel(dx, dy);
    }
    //методы equals и hashCode.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return getStartPoint().equals(line.getStartPoint()) &&
                getEndPoint().equals(line.getEndPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartPoint(), getEndPoint());
    }
}
