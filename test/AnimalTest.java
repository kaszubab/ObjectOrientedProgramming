import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void testNext() {
        IWorldMap map = new RectangularMap(4,4);
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
        Assert.assertEquals(myAnimal.toString(),"N");
        Assert.assertEquals(myAnimal.getPosition(),new Vector2d(4,4));

        moves = new String[40];
        for (int i = 0; i < 40; i+=4) {
            moves[i] =  "b";
            moves[i+1] =  "r";
            moves[i+2] =  "b";
            moves[i+3] =  "l";
        }
        map = new RectangularMap(4,4);
        myAnimal = new Animal(map);
        map.place(myAnimal);
        map.run(new OptionParser(moves).getValidArgTable());
        Assert.assertEquals(myAnimal.toString(),"N");
        Assert.assertEquals(myAnimal.getPosition(),new Vector2d(0,0));

    }


}
