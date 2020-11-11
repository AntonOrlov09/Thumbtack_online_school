package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;
import net.thumbtack.school.colors.v3.Color;

import static org.junit.jupiter.api.Assertions.*;

public class TestBus {

    @Test
    public void testBus1() throws ColorException {
        Bus bus = new Bus(Color.RED, 58, 25);
        assertAll(
                () -> assertEquals(Color.RED, bus.getColor()),
                () -> assertEquals(58, bus.getBusNumber()),
                () -> assertEquals(25, bus.getNumberOfPassengers())
        );
    }


    @Test
    public void testBus2() throws ColorException {
        Bus bus = new Bus(Color.GREEN, 33);
        assertAll(
                () -> assertEquals(Color.GREEN, bus.getColor()),
                () -> assertEquals(33, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus3() throws ColorException {
        Bus bus = new Bus(Color.RED);
        assertAll(
                () -> assertEquals(Color.RED, bus.getColor()),
                () -> assertEquals(323, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus4() throws ColorException {
        Bus bus = new Bus();
        assertAll(
                () -> assertEquals(Color.RED, bus.getColor()),
                () -> assertEquals(323, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus5() throws ColorException {
        Bus bus = new Bus("RED", 58, 25);
        assertAll(
                () -> assertEquals(Color.RED, bus.getColor()),
                () -> assertEquals(58, bus.getBusNumber()),
                () -> assertEquals(25, bus.getNumberOfPassengers())
        );
    }


    @Test
    public void testBus6() throws ColorException {
        Bus bus = new Bus("GREEN", 33);
        assertAll(
                () -> assertEquals(Color.GREEN, bus.getColor()),
                () -> assertEquals(33, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testBus7() throws ColorException {
        Bus bus = new Bus("RED");
        assertAll(
                () -> assertEquals(Color.RED, bus.getColor()),
                () -> assertEquals(323, bus.getBusNumber()),
                () -> assertEquals(30, bus.getNumberOfPassengers())
        );
    }

    @Test
    public void testSetColor1() throws ColorException {
        Bus bus = new Bus(Color.RED);
        bus.setColor(Color.BLUE);
        assertEquals(Color.BLUE, bus.getColor());
    }

    @Test
    public void testSetBusNumber1() throws ColorException {
        Bus bus = new Bus(Color.RED);
        bus.setBusNumber(123);
        assertEquals(123, bus.getBusNumber());
    }

    @Test
    public void testSetNumberOfPassengers1() throws ColorException {
        Bus bus = new Bus(Color.BLUE);
        bus.setNumberOfPassengers(35);
        assertEquals(35, bus.getNumberOfPassengers());
    }

    @Test
    public void testSetColor2() throws ColorException {
        Bus bus = new Bus("RED");
        bus.setColor(Color.BLUE);
        assertEquals(Color.BLUE, bus.getColor());
    }

    @Test
    public void testSetBusNumber2() throws ColorException {
        Bus bus = new Bus("RED");
        bus.setBusNumber(123);
        assertEquals(123, bus.getBusNumber());
    }

    @Test
    public void testSetNumberOfPassengers2() throws ColorException {
        Bus bus = new Bus("BLUE");
        bus.setNumberOfPassengers(35);
        assertEquals(35, bus.getNumberOfPassengers());
    }

    @Test
    public void testEqualsBus() throws ColorException {
        Bus bus1 = new Bus(Color.RED, 23, 30);
        Bus bus2 = new Bus("RED", 23, 30);
        Bus bus3 = new Bus(Color.BLUE, 78, 15);
        assertEquals(bus1, bus2);
        assertNotEquals(bus1, bus3);
    }

}
