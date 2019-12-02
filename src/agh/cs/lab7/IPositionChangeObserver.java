package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.Vector;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
