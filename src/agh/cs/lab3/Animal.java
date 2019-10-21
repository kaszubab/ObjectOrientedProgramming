package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;


public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public void move(MoveDirection direction) {

        switch (direction) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
                if (this.position.add(this.direction.toUnitVector()).precedes(new Vector2d(4,4))) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            case BACKWARD:
                if (this.position.subtract(this.direction.toUnitVector()).follows(new Vector2d(0,0))) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
                break;
        }

    }

    public String toString() {
        return "Position " + position +" direction " + direction;
    }
}
