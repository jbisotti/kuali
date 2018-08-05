package org.jbisotti.elesim;

import java.util.Collection;
import java.util.stream.Collectors;

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

        final Elevator closestUnoccupiedElevator = findClosest(availableElevators, trip.getStartFloor());
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
        this.elevators.stream()
                      .filter(elevator -> !elevator.isOutOfService())
                      .filter(elevator -> !elevator.isOccupied())
                      .collect(Collectors.toList());
    }

    private Elevator findClosest(final Collection<Elevator> availableElevators, final int tripStartFloor) {
        int closestDistance = Integer.MAX_VALUE;
        Elevator closesElevator = null;

        for (final Elevator elevator : availableElevators) {
            final int distance = Math.abs(elevator.getCurrentFloor() - tripStartFloor);
            if (distance < closestDistance) {
                closestDistance = distance;
                closesElevator = elevator;
            }
        }

        return closesElevator;
    }

    private Elevator findOccupiedElevatorWhichWillPassTheTripStartFloor() {
        // TODO

        // Find occupied elevators
        // Find occupied elevators going in a direction that will intercept the tripStartFloor
        return null;
    }

}

