package agh.cs.lab4;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;


public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public Vector2d getPosition() {
        return new Vector2d(0,0).add(this.position);
    }

    public void move(MoveDirection direction) {

        switch (direction) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
                if (this.map.canMoveTo(this.position.add(this.direction.toUnitVector()))) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            case BACKWARD:
                if (this.map.canMoveTo(this.position.subtract(this.direction.toUnitVector()))) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
                break;
        }

    }

    public String toString() {
        // lab 3 return "Position " + position +" direction " + direction;
        switch (this.direction) {
            case SOUTH:
                return "S";
            case NORTH:
                return "N";
            case WEST:
                return "W";
            case EAST:
                return "E";
        }
        return null;
    }
}
