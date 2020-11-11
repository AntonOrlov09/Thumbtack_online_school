package net.thumbtack.school.figures.v1;

import java.util.Arrays;

public class PolyLine {

    private Point[] points;

    //Создает PolyLine по координатам точек.
    public PolyLine(Point[] points) {
        this.points = Arrays.copyOf(points,points.length);
    }
    //Возвращает координаты точек  PolyLine.
    public Point[] getPoints() {
        return points;
    }
    //Устанавливает точки PolyLine.
    public void setPoints(Point[] points) {
        this.points = Arrays.copyOf(points,points.length);
    }
    //Возвращает длину PolyLine (сумму длин отрезков).
    public double getLength() {
        double sum = 0;
        for (int i = 0; i< points.length - 1; i++) {
            Line line = new Line(points[i],points[i+1]);
            sum+=line.getLength();
        }
        return sum;
    }
    //Конгруэнтно передвигает PolyLine так, чтобы начальная точка оказалась в точке (x, y).
    public void moveTo(int x, int y) {
        int dX = x - points[0].getX();
        int dY = y - points[0].getY();
        for (Point point : points) {
            point.moveRel(dX, dY);
        }
    }
    //Конгруэнтно передвигает PolyLine так, чтобы начальная точка оказалась в точке point
    public void moveTo(Point point) {
        int dX = point.getX() - points[0].getX();
        int dY = point.getY() - points[0].getY();
        for (Point p : points) {
            p.moveRel(dX, dY);
        }
    }
    //Конгруэнтно передвигает PolyLine на (dx, dy).
    public void moveRel(int dx, int dy) {
        for (Point point : points) {
            point.moveRel(dx,dy);
        }
    }

    //Возвращает прямоугольник минимального размера, внутри которого PolyLine полностью помещается.
    public Rectangle getBoundingRectangle() {
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Point point : points) {
            if (point.getX() > maxX) {
                maxX = point.getX();
            }
            if(point.getX() < minX) {
                minX = point.getX();
            }
            if (point.getY() > maxY) {
                maxY = point.getY();
            }
            if(point.getY() < minY) {
                minY = point.getY();
            }
        }
        return new Rectangle(minX,minY,maxX,maxY);
    }

    //методы equals и hashCode.
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
