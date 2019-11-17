package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField  extends AbstractWorldMap{

    public GrassField(int grassFieldQuantity) {
        Random generator = new Random();
        generator.setSeed(2137); // uncomment to test
        int range = (int)Math.sqrt(grassFieldQuantity*10);
        for (int i = 0; i < grassFieldQuantity; ) {
            Grass newGrass = new Grass(new Vector2d(generator.nextInt(range),generator.nextInt(range)));
            if (!(objectAt(newGrass.getPosition()) instanceof Grass)) {
                elementList.add(newGrass);
                i++;
            }
        }
        mapVis = new MapVisualizer(this);

    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (IMapElement x : elementList) {
            if (x.getPosition().equals(position) && (x instanceof Animal)) return x;
        }
        return super.objectAt(position);
    }

    @Override
    protected Vector2d minPoint() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (IMapElement x : elementList) {
            Vector2d vector = x.getPosition();
            if (minX > vector.x) minX = vector.x;
            if (minY > vector.y) minY = vector.y;
        }
        return new Vector2d(minX, minY);
    }

    @Override
    protected Vector2d maxPoint() {
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (IMapElement x : elementList) {
            Vector2d vector = x.getPosition();
            if (maxX < vector.x) maxX = vector.x;
            if (maxY < vector.y) maxY = vector.y;
        }
        return new Vector2d(maxX, maxY);
    }

}
