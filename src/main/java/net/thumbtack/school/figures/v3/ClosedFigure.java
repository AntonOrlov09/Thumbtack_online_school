package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasMetrics;
import net.thumbtack.school.iface.v3.Resizable;

public abstract class ClosedFigure extends Figure implements Resizable, HasMetrics {

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
}
