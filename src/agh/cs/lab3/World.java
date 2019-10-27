package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab4.Animal;


public class World {
    public static void main(String [] args) {
        Animal myAnimal = new Animal();
        System.out.println(myAnimal);
        OptionParser myParser = new OptionParser(args);
        for (MoveDirection x : myParser.getValidArgTable()) {
            myAnimal.move(x);
        }
        System.out.println(myAnimal);


    }
}
