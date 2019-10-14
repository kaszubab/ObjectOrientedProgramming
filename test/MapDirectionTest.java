import main.Vector2D;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {

    @Test
    public void testToString() {
        main.Vector2D vector1  = new Vector2D(1,1);
        Assert.assertEquals(vector1.toString(), "(1,1)");
    }

    @Test
    public void precedes() {
        main.Vector2D vector1  = new Vector2D(1,1);
        main.Vector2D vector2  = new Vector2D(0,0);
        Assert.assertTrue(vector2.precedes(vector1));
        Assert.assertTrue(vector2.precedes(vector2));
    }

    @Test
    public void follows() {
        main.Vector2D vector1  = new Vector2D(1,1);
        main.Vector2D vector2  = new Vector2D(0,0);
        Assert.assertTrue(vector1.follows(vector2));
        Assert.assertTrue(vector1.follows(vector1));
    }

    @Test
    public void upperRight() {
        main.Vector2D vector1  = new Vector2D(1,0);
        main.Vector2D vector2  = new Vector2D(0,1);
        Assert.assertEquals(vector1.upperRight(vector2),new Vector2D(1,1));
        Assert.assertEquals(vector2.upperRight(vector1),new Vector2D(1,1));
    }

    @Test
    public void lowerLeft() {
        main.Vector2D vector1  = new Vector2D(1,0);
        main.Vector2D vector2  = new Vector2D(0,1);
        Assert.assertEquals(vector1.lowerLeft(vector2),new Vector2D(0,0));
        Assert.assertEquals(vector2.lowerLeft(vector1),new Vector2D(0,0));
    }

    @Test
    public void add() {
        main.Vector2D vector1  = new Vector2D(1,1);
        main.Vector2D vector2  = new Vector2D(0,2);
        Assert.assertEquals(vector1.add(vector2),new Vector2D(1,3));
    }

    @Test
    public void subtract() {
        main.Vector2D vector1  = new Vector2D(1,1);
        main.Vector2D vector2  = new Vector2D(0,2);
        Assert.assertEquals(vector1.subtract(vector2),new Vector2D(1,-1));
        Assert.assertEquals(vector2.subtract(vector1),new Vector2D(-1,1));
    }

    @Test
    public void opposite() {
        main.Vector2D vector1  = new Vector2D(1,1);
        Assert.assertEquals(vector1.opposite(),new Vector2D(-1,-1));
    }

    @Test
    public void testEquals() {
        main.Vector2D vector1  = new Vector2D(1,1);
        main.Vector2D vector2  = new Vector2D(1,1);
        Assert.assertTrue(vector1.equals(vector2));
        Assert.assertTrue(vector1.equals(vector1));
        Assert.assertFalse(vector1.equals(vector2.opposite()));
    }
}
