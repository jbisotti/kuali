package org.jbisotti.elesim;

/**
 * Representation of the elevator, making the trips up and down floors.
 */
public class Elevator {

    private int currentFloor;

    public Elevator() {
        this.currentFloor = 1;
    }

    public void moveUp() {
        System.out.format("Moving from %d to %d", this.currentFloor, ++this.currentFloor);
    }

    public void moveDown() {
        System.out.format("Moving from %d to %d", this.currentFloor, --this.currentFloor);
    }
}
