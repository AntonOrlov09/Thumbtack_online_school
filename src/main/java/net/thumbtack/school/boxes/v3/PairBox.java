package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;
import net.thumbtack.school.iface.v3.HasMetrics;

public class PairBox<T extends ClosedFigure, F extends ClosedFigure> implements HasMetrics {
    private static final double EPS = 1E-6;

    private T contentFirst;
    private F contentSecond;

    public PairBox(T contentFirst, F contentSecond) {
        this.contentFirst = contentFirst;
        this.contentSecond = contentSecond;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public F getContentSecond() {
        return contentSecond;
    }

    public void setContentSecond(F contentSecond) {
        this.contentSecond = contentSecond;
    }

    @Override
    public double getArea() {
        return contentFirst.getArea() + contentSecond.getArea();
    }

    @Override
    public double getPerimeter() {
        return contentFirst.getPerimeter() + contentSecond.getPerimeter();
    }

    public boolean isAreaEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure>  anotherPairBox) {
        return Math.abs(getArea() - anotherPairBox.getArea()) < EPS;
    }

    public boolean isPerimeterEqual( PairBox<? extends ClosedFigure, ? extends ClosedFigure> secondPairBox) {
        return Math.abs(getPerimeter() - secondPairBox.getPerimeter()) < EPS;
    }


    public static boolean isAreaEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure> firstPairBox, PairBox<? extends ClosedFigure, ? extends ClosedFigure> secondPairBox) {
        return Math.abs(firstPairBox.getArea() - secondPairBox.getArea()) < EPS;
    }

    public static boolean isPerimeterEqual(PairBox<? extends ClosedFigure, ? extends ClosedFigure> firstPairBox, PairBox<? extends ClosedFigure, ? extends ClosedFigure> secondPairBox) {
        return Math.abs(firstPairBox.getPerimeter() - secondPairBox.getPerimeter()) < EPS;
    }

}
