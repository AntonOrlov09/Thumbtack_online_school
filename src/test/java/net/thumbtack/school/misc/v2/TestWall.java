package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWall {

    @Test
    public void testWall1() {
        Wall wall = new Wall(2, 4, 3);
        assertAll(
                () -> assertEquals(2, wall.getColor()),
                () -> assertEquals(4, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall2() {
        Wall wall = new Wall(3, 6);
        assertAll(
                () -> assertEquals(3, wall.getColor()),
                () -> assertEquals(6, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall3() {
        Wall wall = new Wall(9);
        assertAll(
                () -> assertEquals(9, wall.getColor()),
                () -> assertEquals(5, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall4() {
        Wall wall = new Wall();
        assertAll(
                () -> assertEquals(1, wall.getColor()),
                () -> assertEquals(5, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testSetColor() {
        Wall wall = new Wall(12);
        wall.setColor(13);
        assertEquals(13, wall.getColor());
    }

    @Test
    public void testSetLength() {
        Wall wall = new Wall(7);
        wall.setLength(6);
        assertEquals(6, wall.getLength());
    }

    @Test
    public void testSetHeight() {
        Wall wall = new Wall(3);
        wall.setHeight(4);
        assertEquals(4, wall.getHeight());
    }

    @Test
    public void testAreaWall() {
        Wall wall1 = new Wall(1, 4, 3);
        Wall wall2 = new Wall(3, 6, 4);
        assertEquals(12, wall1.getArea());
        assertEquals(24, wall2.getArea());
    }

    @Test
    public void testPerimeterWall() {
        Wall wall1 = new Wall(3, 9, 6);
        Wall wall2 = new Wall(7, 8, 5);
        assertEquals(30, wall1.getPerimeter());
        assertEquals(26, wall2.getPerimeter());
    }

    @Test
    public void testEqualsWall() {
        Wall wall1 = new Wall(7, 8, 4);
        Wall wall2 = new Wall(7, 8, 4);
        Wall wall3 = new Wall(9, 10, 5);
        assertEquals(wall1, wall2);
        assertNotEquals(wall1, wall3);
    }

}
