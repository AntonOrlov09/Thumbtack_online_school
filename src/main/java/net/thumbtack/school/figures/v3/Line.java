package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Line extends Figure {

    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        super();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Line(Point endPoint) {
        this(new Point(0, 0), endPoint);
    }

    public Line(int x, int y) {
        this(new Point(0, 0), new Point(x, y));
    }

    public Line() {
        this(new Point(0, 0), new Point(1, 1));
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(Point point) {
        this.startPoint = point;
    }

    public void setEndPoint(Point point) {
        this.endPoint = point;
    }

    public double getLength() {
        int X = endPoint.getX() - startPoint.getX();
        int Y = endPoint.getY() - startPoint.getY();
        return Math.sqrt(X * X + Y * Y);
    }

    @Override
    public void moveTo(int x, int y) {
        int dX = x - startPoint.getX();
        int dY = y - startPoint.getY();
        endPoint.moveTo(endPoint.getX() + dX, endPoint.getY() + dY);
        startPoint.moveTo(x, y);

    }

    @Override
    public void moveRel(int dx, int dy) {
        startPoint.moveRel(dx, dy);
        endPoint.moveRel(dx, dy);
    }

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
