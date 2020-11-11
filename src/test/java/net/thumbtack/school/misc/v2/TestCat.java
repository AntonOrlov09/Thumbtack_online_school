package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCat {

    @Test
    public void testCat1() {
        Cat cat = new Cat("Barsik", 2);
        assertAll(
                () -> assertEquals("Barsik", cat.getName()),
                () -> assertEquals(2, cat.getColor())
        );
    }

    @Test
    public void testCat2() {
        Cat cat = new Cat(5);
        assertAll(
                () -> assertEquals("Vasya", cat.getName()),
                () -> assertEquals(5, cat.getColor())
        );
    }

    @Test
    public void testCat3() {
        Cat cat = new Cat();
        assertAll(
                () -> assertEquals("Vasya", cat.getName()),
                () -> assertEquals(1, cat.getColor())
        );
    }

    @Test
    public void testSetColor() {
        Cat cat = new Cat(3);
        cat.setColor(4);
        assertEquals(4, cat.getColor());
    }

    @Test
    public void testSetName() {
        Cat cat = new Cat(6);
        cat.setName("Muska");
        assertEquals("Muska", cat.getName());
    }

    @Test
    public void testEqualsCat() {
        Cat cat1 = new Cat("Muska", 7);
        Cat cat2 = new Cat("Muska", 7);
        Cat cat3 = new Cat("Rizhik", 7);
        assertEquals(cat1, cat2);
        assertNotEquals(cat1, cat3);
    }

}
