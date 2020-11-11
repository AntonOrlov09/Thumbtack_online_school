package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class Bus implements Colored {

    private Color color;
    private int busNumber;
    private int numberOfPassengers;

    public Bus(Color color, int busNumber, int numberOfPassengers) throws ColorException {
        setColor(color);
        this.busNumber = busNumber;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Bus(String color, int busNumber, int numberOfPassengers) throws ColorException {
        setColor(color);
        this.busNumber = busNumber;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Bus(Color color, int busNumber) throws ColorException {
        this(color, busNumber, 30);
    }

    public Bus(String color, int busNumber) throws ColorException {
        this(color, busNumber, 30);
    }

    public Bus(Color color) throws ColorException {
        this(color, 323);
    }

    public Bus(String color) throws ColorException {
        this(color, 323);
    }

    public Bus() throws ColorException {
        this(Color.RED);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return getColor() == bus.getColor() &&
                getBusNumber() == bus.getBusNumber() &&
                getNumberOfPassengers() == bus.getNumberOfPassengers();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getBusNumber(), getNumberOfPassengers());
    }
}
