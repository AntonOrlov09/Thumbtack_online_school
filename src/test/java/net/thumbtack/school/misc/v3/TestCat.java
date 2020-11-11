package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;
import net.thumbtack.school.colors.v3.Color;

import static org.junit.jupiter.api.Assertions.*;

public class TestCat {

    @Test
    public void testCat1() throws ColorException {
        Cat cat = new Cat("Barsik", Color.RED);
        assertAll(
                () -> assertEquals("Barsik", cat.getName()),
                () -> assertEquals(Color.RED, cat.getColor())
        );
    }

    @Test
    public void testCat2() throws ColorException {
        Cat cat = new Cat(Color.GREEN);
        assertAll(
                () -> assertEquals("Vasya", cat.getName()),
                () -> assertEquals(Color.GREEN, cat.getColor())
        );
    }

    @Test
    public void testCat3() throws ColorException {
        Cat cat = new Cat();
        assertAll(
                () -> assertEquals("Vasya", cat.getName()),
                () -> assertEquals(Color.RED, cat.getColor())
        );
    }

    @Test
    public void testCat4() throws ColorException {
        Cat cat = new Cat("Barsik", "RED");
        assertAll(
                () -> assertEquals("Barsik", cat.getName()),
                () -> assertEquals(Color.RED, cat.getColor())
        );
    }

    @Test
    public void testCat5() throws ColorException {
        Cat cat = new Cat("GREEN");
        assertAll(
                () -> assertEquals("Vasya", cat.getName()),
                () -> assertEquals(Color.GREEN, cat.getColor())
        );
    }


    @Test
    public void testSetColor1() throws ColorException {
        Cat cat = new Cat(Color.GREEN);
        cat.setColor(Color.RED);
        assertEquals(Color.RED, cat.getColor());
    }

    @Test
    public void testSetName1() throws ColorException {
        Cat cat = new Cat(Color.RED);
        cat.setName("Muska");
        assertEquals("Muska", cat.getName());
    }

    @Test
    public void testSetColor2() throws ColorException {
        Cat cat = new Cat("GREEN");
        cat.setColor(Color.RED);
        assertEquals(Color.RED, cat.getColor());
    }

    @Test
    public void testSetName2() throws ColorException {
        Cat cat = new Cat("RED");
        cat.setName("Muska");
        assertEquals("Muska", cat.getName());
    }

    @Test
    public void testEqualsCat() throws ColorException {
        Cat cat1 = new Cat("Muska", "RED");
        Cat cat2 = new Cat("Muska", Color.RED);
        Cat cat3 = new Cat("Rizhik", Color.GREEN);
        assertEquals(cat1, cat2);
        assertNotEquals(cat1, cat3);
    }

}
