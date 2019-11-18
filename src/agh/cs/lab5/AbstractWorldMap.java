package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class  AbstractWorldMap implements IWorldMap {
    protected List<IMapElement> animalList = new ArrayList<>();
    protected HashMap<Vector2d,IMapElement> elementMap = new HashMap<>();
    protected MapVisualizer mapVis;

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animalList.add(animal);
            elementMap.put(animal.getPosition(),animal);
            return true;
        }
        if (!(objectAt(animal.getPosition()) instanceof Animal)) {
            animalList.add(animal);
            elementMap.put(animal.getPosition(),animal);
            return true;
        }
        throw new IllegalArgumentException(" Position " + animal.getPosition() + " is already occupied");
    }

    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            Animal animal = (Animal) animalList.get(i % animalList.size());
            elementMap.remove(animal.getPosition());
            animal.move(directions[i]);
            elementMap.put(animal.getPosition(), animal);
        }
    }

    protected abstract Vector2d minPoint();
    protected abstract Vector2d maxPoint();

    public Object objectAt(Vector2d position) {
        return elementMap.get(position);
    }

    public String toString() {
        return mapVis.draw(minPoint(), maxPoint());
    }


}
