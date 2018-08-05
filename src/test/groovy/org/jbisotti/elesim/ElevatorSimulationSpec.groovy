package org.jbisotti.elesim

import spock.lang.Specification
import spock.lang.Unroll

class ElevatorSimulationSpec extends Specification {

    @Unroll
    def "Given new ElevatorSimulation(#numberOfElevators, 3numberOfFloors), then construction should throw an Exception because: #message"() {
        when:
        new ElevatorSimulation(numberOfElevators, numberOfFloors)

        then:
        final Exception e = thrown()
        e.message == message

        where:
        numberOfElevators | numberOfFloors | message
        0                 | 1              | 'There must be at least 1 elevator'
        1                 | 0              | 'There must be at least 1 floor'
    }

    def "Given the minimum valid elevators and floors, construction should succeed"() {
        given:
        final int numberOfElevators = 1
        final int numberOfFloors = 1

        when:
        new ElevatorSimulation(numberOfElevators, numberOfFloors)

        then:
        notThrown(Exception)
    }

}
