package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;
import net.thumbtack.school.iface.v3.HasMetrics;

public class Box<T extends ClosedFigure> implements HasMetrics {
    private static final double EPS = 1E-6;
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public double getArea() {
        return content.getArea();
    }

    @Override
    public double getPerimeter() {
        return content.getPerimeter();
    }

    public boolean isAreaEqual(Box<? extends ClosedFigure> anotherBox) {
        return Math.abs(getArea() - anotherBox.getArea()) < EPS;
    }

    public static boolean isAreaEqual(Box<? extends ClosedFigure> firstBox, Box<? extends ClosedFigure> secondBox) {
        return Math.abs(firstBox.getArea() - secondBox.getArea()) < EPS;
    }

    public boolean isPerimeterEqual(Box<? extends ClosedFigure> anotherBox) {
        return Math.abs(getPerimeter() - anotherBox.getPerimeter()) < EPS;
    }

    public boolean isPerimeterEqual(Box<? extends ClosedFigure> firstBox, Box<? extends ClosedFigure> secondBox) {
        return Math.abs(firstBox.getPerimeter() - secondBox.getPerimeter()) < EPS;
    }
}
