package org.jbisotti.elesim;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The driver for the Elevator Simulation.
 */
public class ElevatorSimulation {

    public static void main(final String... args) throws Exception {

        final int numberOfElevators = Integer.parseInt(args[0]);
        checkArgument(numberOfElevators > 0, "There must be at least 1 elevator");

        final int topFloor = Integer.parseInt(args[1]);
        checkArgument(topFloor > 0, "There must be at least 1 floor");

        final Collection<Elevator> elevators = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator(topFloor));

        }

        final ElevatorsController controller = new ElevatorsController(elevators, topFloor);
        controller.takeTrip(new Trip());
        controller.takeTrip(new Trip());
        controller.takeTrip(new Trip());
    }

}
