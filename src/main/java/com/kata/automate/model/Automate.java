package com.kata.automate.model;

import static com.kata.automate.model.Orientation.*;
import static com.kata.automate.model.PivoteDirection.DROITE;
import static com.kata.automate.model.PivoteDirection.GAUCHE;

public class Automate {

    private Coordinate coordinate;
    private Orientation orientation;
    private Grid grid;

    public Automate(Coordinate coordinate, Orientation orientation,Grid grid) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.grid =grid;
    }

    public void move() {
        if (isMovePossible()) {
            if (orientation == NORTH) coordinate.setY(coordinate.getY() + 1);
            if (orientation == SOUTH) coordinate.setY(coordinate.getY() - 1);
            if (orientation == WEST) coordinate.setX(coordinate.getX() - 1);
            if (orientation == EAST) coordinate.setX(coordinate.getX() + 1);
        }
    }

    public Coordinate getAutomatePosition() {
        return this.coordinate;
    }

    public Orientation getAutomateOrientation() {
        return this.orientation;
    }

    boolean isMovePossible() {
        boolean canMove = true;
        switch (this.orientation) {

            case NORTH:
                if (coordinate.getY() + 1 > grid.getNumRows()) canMove = false;
                break;
            case SOUTH:
                if (coordinate.getY() - 1 < 0) canMove = false;
                break;
            case WEST:
                if (coordinate.getX() - 1 < 0) canMove = false;
                break;
            case EAST:
                if (coordinate.getX() + 1 > grid.getNumColumns()) canMove = false;
                break;
        }
        return canMove;

    }

    public void pivoter(PivoteDirection pivoteDirection) {
        switch (this.orientation) {

            case NORTH:
                if (GAUCHE == pivoteDirection) orientation = WEST;
                if (DROITE == pivoteDirection) orientation = EAST;
                break;
            case SOUTH:
                if (GAUCHE == pivoteDirection) orientation = EAST;
                if (DROITE == pivoteDirection) orientation = WEST;
                break;
            case WEST:
                if (GAUCHE == pivoteDirection) orientation = SOUTH;
                if (DROITE == pivoteDirection) orientation = NORTH;
                break;
            case EAST:
                if (GAUCHE == pivoteDirection) orientation = NORTH;
                if (DROITE == pivoteDirection) orientation = SOUTH;
                break;
        }
    }
}
