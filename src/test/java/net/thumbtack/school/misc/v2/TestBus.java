package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBus {

    @Test
    public void testBus1() {
        Bus bus = new Bus(2, 58, 25);
        assertAll(
                () -> assertEquals(2, bus.getColor()),
                () -> assertEquals(58, bus.getBusNumber()),
                () -> assertEquals(25, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus2() {
        Bus bus = new Bus(4, 33);
        assertAll(
                () -> assertEquals(4, bus.getColor()),
                () -> assertEquals(33, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus3() {
        Bus bus = new Bus(3);
        assertAll(
                () -> assertEquals(3, bus.getColor()),
                () -> assertEquals(323, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus4() {
        Bus bus = new Bus();
        assertAll(
                () -> assertEquals(1, bus.getColor()),
                () -> assertEquals(323, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testSetColor() {
        Bus bus = new Bus(1);
        bus.setColor(2);
        assertEquals(2, bus.getColor());
    }

    @Test
    public void testSetBusNumber() {
        Bus bus = new Bus(99);
        bus.setBusNumber(123);
        assertEquals(123, bus.getBusNumber());
    }

    @Test
    public void testSetNumberOfPassengers() {
        Bus bus = new Bus(15);
        bus.setNumberOfPassengers(35);
        assertEquals(35, bus.getNumberOfPassengers());
    }

    @Test
    public void testEqualsBus() {
        Bus bus1 = new Bus(1, 23, 30);
        Bus bus2 = new Bus(1, 23, 30);
        Bus bus3 = new Bus(2, 78, 15);
        assertEquals(bus1, bus2);
        assertNotEquals(bus1, bus3);
    }


}
