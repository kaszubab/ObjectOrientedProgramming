package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private List<Animal> animalList = new ArrayList<>();

    public RectangularMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    private boolean inMap(Vector2d position) {
        return position.precedes(new Vector2d(width,height)) &&
                position.follows(new Vector2d(0,0));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal x : animalList) {
            if (x.getPosition().equals(position)) return true;
        }
        return false;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return inMap(position) &&
                !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if ( inMap(animal.getPosition()) && !isOccupied(animal.getPosition())) {
            animalList.add(animal);
            return true;
        }
        return false;
    }


    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            animalList.get(i % animalList.size()).move(directions[i]);
        }

    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal x : animalList) {
            //System.out.println(x.getPosition());
            if (x.getPosition().equals(position)) return x;
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }
}
