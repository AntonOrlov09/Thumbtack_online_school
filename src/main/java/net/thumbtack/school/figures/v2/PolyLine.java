package net.thumbtack.school.figures.v2;

import java.util.Arrays;

public class PolyLine extends Figure {

    private Point[] points;

    public PolyLine(Point[] points) {
        super();
        this.points = Arrays.copyOf(points, points.length);
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = Arrays.copyOf(points, points.length);
    }

    public double getLength() {
        double sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line(points[i], points[i + 1]);
            sum += line.getLength();
        }
        return sum;
    }

    @Override
    public void moveTo(int x, int y) {
        int dX = x - points[0].getX();
        int dY = y - points[0].getY();
        for (Point point : points) {
            point.moveRel(dX, dY);
        }
    }

    @Override
    public void moveRel(int dx, int dy) {
        for (Point point : points) {
            point.moveRel(dx, dy);
        }
    }

    public Rectangle getBoundingRectangle() {
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Point point : points) {
            if (point.getX() > maxX) {
                maxX = point.getX();
            }
            if (point.getX() < minX) {
                minX = point.getX();
            }
            if (point.getY() > maxY) {
                maxY = point.getY();
            }
            if (point.getY() < minY) {
                minY = point.getY();
            }
        }
        return new Rectangle(minX, minY, maxX, maxY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolyLine)) return false;
        PolyLine polyLine = (PolyLine) o;
        return Arrays.equals(getPoints(), polyLine.getPoints());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getPoints());
    }
}
