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
                elementMap.put(newGrass.getPosition(), newGrass);
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
    public Object objectAt(Vector2d position) {
        for (IMapElement x : animalList) {
            if (x.getPosition().equals(position) && (x instanceof Animal)) return x;
        }
        return super.objectAt(position);
    }

    @Override
    protected Vector2d minPoint() {
        Vector2d minVector = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for (Vector2d x : elementMap.keySet()) {
            minVector = minVector.lowerLeft(x);
        }
        return minVector;
    }

    @Override
    protected Vector2d maxPoint() {
        Vector2d minVector = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for (Vector2d x : elementMap.keySet()) {
            minVector = minVector.upperRight(x);
        }
        return minVector;
    }

}
