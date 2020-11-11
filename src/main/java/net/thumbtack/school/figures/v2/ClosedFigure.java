package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.HasMetrics;
import net.thumbtack.school.iface.v2.Resizable;

abstract class ClosedFigure extends Figure implements Resizable, HasMetrics {
    public ClosedFigure() {
        super();
    }

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
}
