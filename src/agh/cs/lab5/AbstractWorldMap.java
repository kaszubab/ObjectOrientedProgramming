package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public abstract class  AbstractWorldMap implements IWorldMap {
    protected List<IMapElement> elementList = new ArrayList<>();
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
            elementList.add(animal);
            return true;
        }
        if(objectAt(animal.getPosition()) instanceof Grass) {
            elementList.add(animal);
            return true;
        }
        return false;
    }

    public void run(MoveDirection[] directions) {
        int j = 0;
        List<Animal> animalList= new ArrayList<>();
        for (IMapElement x : elementList) {
            if (x instanceof Animal) animalList.add((Animal) x);
        }
        for (int i = 0; i < directions.length; i++) {
            animalList.get(i % animalList.size()).move(directions[i]);
        }
    }

    protected abstract Vector2d minPoint();
    protected abstract Vector2d maxPoint();

    public Object objectAt(Vector2d position) {
        for (IMapElement x : elementList) {
            if (x.getPosition().equals(position)) return x;
        }
            return null;
    }

    public String toString() {

        return mapVis.draw(minPoint(), maxPoint());
    }


}
