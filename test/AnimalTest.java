import agh.cs.lab2.MoveDirection;
import agh.cs.lab4.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void testNext() {
        Animal testAnimal = new Animal();
        for (int i = 0; i < 100; i++) {
            testAnimal.move(MoveDirection.FORWARD);
            testAnimal.move(MoveDirection.RIGHT);
            testAnimal.move(MoveDirection.FORWARD);
            testAnimal.move(MoveDirection.LEFT);
        }
        Assert.assertEquals(testAnimal.toString(),"Position (4,4) direction Północ");
        for (int i = 0; i < 200; i++) {
            testAnimal.move(MoveDirection.BACKWARD);
            testAnimal.move(MoveDirection.RIGHT);
            testAnimal.move(MoveDirection.BACKWARD);
            testAnimal.move(MoveDirection.LEFT);

        }
        Assert.assertEquals(testAnimal.toString(),"Position (0,0) direction Północ");
    }

}
