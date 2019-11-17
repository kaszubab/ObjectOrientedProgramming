package agh.cs.lab5;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Grass implements IMapElement{
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;


    public Grass(Vector2d initialPosition) {
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return new Vector2d(0,0).add(this.position);
    }


    public String toString() {
        return "*";
    }
}
