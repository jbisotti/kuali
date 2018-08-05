package org.jbisotti.elesim;

/**
 * Representation of the elevator, making the trips up and down floors.
 */
public class Elevator {

    private int currentFloor;
    private DoorsState doorsState;

    public Elevator() {
        this.currentFloor = 1;
        this.doorsState = DoorsState.OPEN;
    }

    public void moveUp() {
        System.out.format("Moving from %d to %d%n", this.currentFloor, ++this.currentFloor);
    }

    public void moveDown() {
        System.out.format("Moving from %d to %d%n", this.currentFloor, --this.currentFloor);
    }

    public void openDoors() {
        System.out.format("Opening the doors%n");
        this.doorsState = DoorsState.OPEN;
    }

    public void closeDoors() {
        System.out.format("Closing the doors%n");
        this.doorsState = DoorsState.CLOSED;
    }

}
