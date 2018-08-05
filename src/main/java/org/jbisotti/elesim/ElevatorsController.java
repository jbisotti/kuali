package org.jbisotti.elesim;

import java.util.Collection;

import com.google.common.collect.ImmutableList;

/**
 * The brains of the simulator.
 */
public class ElevatorsController {

    private final Collection<Elevator> elevators;

    public ElevatorsController(final Collection<Elevator> elevators) {
        this.elevators = ImmutableList.copyOf(elevators);
    }

    public void takeTrip(final Trip trip) {
        final Elevator elevator = selectElevator(trip);
        elevator.takeTrip(trip);
    }

    private Elevator selectElevator(final Trip trip) {
        final Collection<Elevator> availableElevators = findAvailableElevators();
        final Elevator closestUnoccupiedElevator = findClosestUnoccupiedElevator(availableElevators);
        if (closestUnoccupiedElevator.getCurrentFloor() == trip.getStartFloor()) {
            return closestUnoccupiedElevator;
        }

        final Elevator occupiedElevatorInterceptor = findOccupiedElevatorWhichWillPassTheTripStartFloor();
        if (occupiedElevatorInterceptor != null) {
            return occupiedElevatorInterceptor;
        }

        return closestUnoccupiedElevator;
    }

    private Collection<Elevator> findAvailableElevators() {
        // TODO
        return ImmutableList.of();
    }

    private Elevator findClosestUnoccupiedElevator(final Collection<Elevator> availableElevators) {
        // TODO
        return null;
    }

    private Elevator findOccupiedElevatorWhichWillPassTheTripStartFloor() {
        // TODO
        return null;
    }

}

