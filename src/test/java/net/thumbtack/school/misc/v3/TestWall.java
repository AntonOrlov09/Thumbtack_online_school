package net.thumbtack.school.misc.v3;


import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;
import net.thumbtack.school.colors.v3.Color;

import static org.junit.jupiter.api.Assertions.*;

public class TestWall {

    @Test
    public void testWall1() throws ColorException {
        Wall wall = new Wall(Color.RED, 4, 3);
        assertAll(
                () -> assertEquals(Color.RED, wall.getColor()),
                () -> assertEquals(4, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall2() throws ColorException {
        Wall wall = new Wall(Color.RED, 6);
        assertAll(
                () -> assertEquals(Color.RED, wall.getColor()),
                () -> assertEquals(6, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall3() throws ColorException {
        Wall wall = new Wall(Color.GREEN);
        assertAll(
                () -> assertEquals(Color.GREEN, wall.getColor()),
                () -> assertEquals(5, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall4() throws ColorException {
        Wall wall = new Wall();
        assertAll(
                () -> assertEquals(Color.RED, wall.getColor()),
                () -> assertEquals(5, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall5() throws ColorException {
        Wall wall = new Wall("RED", 4, 3);
        assertAll(
                () -> assertEquals(Color.RED, wall.getColor()),
                () -> assertEquals(4, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall6() throws ColorException {
        Wall wall = new Wall("RED", 6);
        assertAll(
                () -> assertEquals(Color.RED, wall.getColor()),
                () -> assertEquals(6, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }

    @Test
    public void testWall7() throws ColorException {
        Wall wall = new Wall("GREEN");
        assertAll(
                () -> assertEquals(Color.GREEN, wall.getColor()),
                () -> assertEquals(5, wall.getLength()),
                () -> assertEquals(3, wall.getHeight())
        );
    }


    @Test
    public void testSetColor1() throws ColorException {
        Wall wall = new Wall(Color.GREEN);
        wall.setColor(Color.RED);
        assertEquals(Color.RED, wall.getColor());
    }

    @Test
    public void testSetLength1() throws ColorException {
        Wall wall = new Wall(Color.RED);
        wall.setLength(6);
        assertEquals(6, wall.getLength());
    }

    @Test
    public void testSetHeight1() throws ColorException {
        Wall wall = new Wall(Color.RED);
        wall.setHeight(4);
        assertEquals(4, wall.getHeight());
    }

    @Test
    public void testAreaWall1() throws ColorException {
        Wall wall1 = new Wall(Color.RED, 4, 3);
        Wall wall2 = new Wall(Color.GREEN, 6, 4);
        assertEquals(12, wall1.getArea());
        assertEquals(24, wall2.getArea());
    }

    @Test
    public void testPerimeterWall1() throws ColorException {
        Wall wall1 = new Wall(Color.RED, 9, 6);
        Wall wall2 = new Wall(Color.GREEN, 8, 5);
        assertEquals(30, wall1.getPerimeter());
        assertEquals(26, wall2.getPerimeter());
    }

    @Test
    public void testSetColor2() throws ColorException {
        Wall wall = new Wall("GREEN");
        wall.setColor(Color.RED);
        assertEquals(Color.RED, wall.getColor());
    }

    @Test
    public void testSetLength2() throws ColorException {
        Wall wall = new Wall("RED");
        wall.setLength(6);
        assertEquals(6, wall.getLength());
    }

    @Test
    public void testSetHeight2() throws ColorException {
        Wall wall = new Wall("RED");
        wall.setHeight(4);
        assertEquals(4, wall.getHeight());
    }

    @Test
    public void testAreaWall2() throws ColorException {
        Wall wall1 = new Wall("RED", 4, 3);
        Wall wall2 = new Wall("GREEN", 6, 4);
        assertEquals(12, wall1.getArea());
        assertEquals(24, wall2.getArea());
    }

    @Test
    public void testPerimeterWall2() throws ColorException {
        Wall wall1 = new Wall("RED", 9, 6);
        Wall wall2 = new Wall("GREEN", 8, 5);
        assertEquals(30, wall1.getPerimeter());
        assertEquals(26, wall2.getPerimeter());
    }

    @Test
    public void testEqualsWall() throws ColorException {
        Wall wall1 = new Wall("RED", 8, 4);
        Wall wall2 = new Wall(Color.RED, 8, 4);
        Wall wall3 = new Wall(Color.GREEN, 10, 5);
        assertEquals(wall1, wall2);
        assertNotEquals(wall1, wall3);
    }

}
