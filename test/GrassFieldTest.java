import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.GrassField;
import org.junit.Assert;
import org.junit.Test;

public class GrassFieldTest {
    @Test
    public void testMap() {
        IWorldMap map = new GrassField(10);
        String [] moves = new String[20];
        for (int i = 0; i < 20; i+=4) {
            moves[i] =  "f";
            moves[i+1] =  "r";
            moves[i+2] =  "f";
            moves[i+3] =  "l";
        }
        Animal myAnimal = new Animal(map);
        map.place(myAnimal);
        map.run(new OptionParser(moves).getValidArgTable());
        Assert.assertEquals(map.objectAt(new Vector2d(9,7)).toString(),"*");
        Assert.assertEquals(myAnimal.toString(),"N");
        Assert.assertEquals(myAnimal.getPosition(),new Vector2d(7,7));

        moves = new String[40];
        for (int i = 0; i < 40; i+=4) {
            moves[i] =  "b";
            moves[i+1] =  "r";
            moves[i+2] =  "b";
            moves[i+3] =  "l";
        }
        map = new GrassField(10);
        myAnimal = new Animal(map);
        map.place(myAnimal);
        map.run(new OptionParser(moves).getValidArgTable());
        Assert.assertEquals(map.objectAt(new Vector2d(9,7)).toString(),"*");
        Assert.assertEquals(myAnimal.toString(),"N");
        Assert.assertEquals(myAnimal.getPosition(),new Vector2d(-8,-8));

        moves = new String[14];
        for (int i = 0; i < 5; i++) {
            moves[i] =  "f";
        }
        moves[5]= "r";
        for (int i = 6; i < 13; i++) {
            moves[i] =  "f";
        }
        moves[13]= "l";
        map = new GrassField(10);
        myAnimal = new Animal(map);
        map.place(myAnimal);
        map.run(new OptionParser(moves).getValidArgTable());
        Assert.assertEquals(map.objectAt(new Vector2d(9,7)).toString(),"N");
        Assert.assertEquals(myAnimal.getPosition(),new Vector2d(9,7));

    }
}
