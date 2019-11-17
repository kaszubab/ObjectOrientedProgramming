package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMap;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        mapVis = new MapVisualizer(this);
    }

    private boolean inMap(Vector2d position) {
        return position.precedes(new Vector2d(width,height)) &&
                position.follows(new Vector2d(0,0));
    }



    @Override
    public boolean canMoveTo(Vector2d position) {
        if (inMap(position)) return super.canMoveTo(position);
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if ( inMap(animal.getPosition())) return super.place(animal);
        return false;
    }

    @Override
    protected Vector2d minPoint() {
        return new Vector2d(0,0);
    }

    @Override
    protected Vector2d maxPoint() {
        return new Vector2d(this.width, this.height);
    }

}
