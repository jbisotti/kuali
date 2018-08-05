package org.jbisotti.elesim

import spock.lang.Specification

class ElevatorSpec extends Specification {

  def "Given a valid elevator, moveUp() should increment its currentFloor"() {
      given:
      final Elevator elevator = new Elevator()

      when:
      elevator.moveUp()

      then:
      final int expectedCurrentFloor = 2
      expectedCurrentFloor == elevator.currentFloor
  }

  def "Given a valid elevator, moveDown() should decrement its currentFloor"() {
      given:
      final Elevator elevator = new Elevator()

      when:
      elevator.moveDown()

      then:
      final int expectedCurrentFloor = 0
      expectedCurrentFloor == elevator.currentFloor
  }

  def "Given a valid elevator, openDoors() will set the doorState to OPEN"() {
      given:
      final Elevator elevator = new Elevator()

      when:
      elevator.openDoors()

      then:
      DoorsState.OPEN == elevator.doorsState
  }

    def "Given a valid elevator, closeDoors() will set the doorState to CLOSE"() {
        given:
        final Elevator elevator = new Elevator()

        when:
        elevator.closeDoors()

        then:
        DoorsState.CLOSED == elevator.doorsState
    }

}
