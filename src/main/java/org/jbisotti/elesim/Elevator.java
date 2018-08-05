package org.jbisotti.elesim;

/**
 * Representation of the elevator, making the trips up and down floors.
 */
public class Elevator {

    private static int GROUND_FLOOR = 1;
    private static int OUT_OF_SERVICE_TRIP_COUNT = 100;

    private int currentFloor;
    private DoorsState doorsState;
    private int topFloor;
    private boolean occupied;
    private int tripCount;
    private Direction direction;

    public Elevator(final int topFloor) {
        this.currentFloor = GROUND_FLOOR;
        this.doorsState = DoorsState.OPEN;
        this.topFloor = topFloor;
        this.occupied = false;
        this.tripCount = 0;
        this.direction = Direction.STATIONARY;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void moveUp() {
        if (this.currentFloor == this.topFloor) {
            System.out.format("Already on the top floor; cannot go up%n");
            return;
        }
        System.out.format("Moving from %d to %d%n", this.currentFloor, ++this.currentFloor);
    }

    public void moveDown() {
        if (this.currentFloor == GROUND_FLOOR) {
            System.out.format("Already on the ground floor; cannot go down%n");
            return;
        }
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

    private boolean doorsAreOpen() {
        return this.doorsState == DoorsState.OPEN;
    }

    public boolean takeTrip(final Trip trip) {
        if (isOutOfService()) {
            return false;
        }

        if (doorsAreOpen()) {
            closeDoors();
        }
        this.occupied = true;

        goToTripStartFloor(trip.getStartFloor());
        this.direction = Direction.STATIONARY;

        openDoors();
        closeDoors();

        goToTripDestinationFloor(trip.getDestinationFloor());
        this.direction = Direction.STATIONARY;

        openDoors();
        this.occupied = false;

        this.tripCount++;

        return true;
    }

    private void goToTripStartFloor(final int startFloor) {

        if (this.currentFloor < startFloor) {
            this.direction = Direction.UP;
            // Go up to startFloor
        } else if (this.currentFloor > startFloor) {
            this.direction = Direction.DOWN;
            // Go down to startFloor
        }
    }

    private void goToTripDestinationFloor(final int destinationFloor) {

        if (this.currentFloor < destinationFloor) {
            this.direction = Direction.UP;
            // Go up to destinationFloor
        } else if (this.currentFloor > destinationFloor) {
            this.direction = Direction.DOWN;
            // Go down to destinationFloor
        }
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public boolean isOutOfService() {
        return this.tripCount == OUT_OF_SERVICE_TRIP_COUNT;
    }

    public Direction getCurrentDirection() {
        return this.direction;
    }
}
