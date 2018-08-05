package org.jbisotti.elesim;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * The driver for the Elevator Simulation.
 */
public class ElevatorSimulation {

    private final int numberOfElevators;
    private final int numberOfFloors;

    public ElevatorSimulation(final int numberOfElevators, final int numberOfFloors) {

        checkArgument(numberOfElevators > 0, "There must be at least 1 elevator");
        this.numberOfElevators = numberOfElevators;

        checkArgument(numberOfFloors > 0, "There must be at least 1 floor");
        this.numberOfFloors = numberOfFloors;
    }

}
