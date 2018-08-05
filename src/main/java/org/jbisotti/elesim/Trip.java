package org.jbisotti.elesim;

/**
 * Represents an elevator trip.
 */
public class Trip {

    private final int startFloor;
    private final int destinationFloor;

    public Trip(final int startFloor, final int destinationFloor) {
        this.startFloor = startFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getStartFloor() {
        return this.startFloor;
    }

    public int getDestinationFloor() {
        return this.destinationFloor;
    }

}
