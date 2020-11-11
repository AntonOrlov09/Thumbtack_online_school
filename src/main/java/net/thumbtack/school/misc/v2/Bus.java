package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class Bus implements Colored {

    private int color;
    private int busNumber;
    private int numberOfPassengers;

    public Bus(int color, int busNumber, int numberOfPassengers) {
        this.color = color;
        this.busNumber = busNumber;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Bus(int color, int busNumber) {
        this(color, busNumber, 30);
    }

    public Bus(int color) {
        this(color, 323);
    }

    public Bus() {
        this(1);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
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
