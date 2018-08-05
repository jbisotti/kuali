package org.jbisotti.elesim

import spock.lang.Specification

class ElevatorSpec extends Specification {

  def "Given a valid elevator, moveUp() should increment its currentFloor"() {
      given:
      final int topFloor = 10

      and:
      final Elevator elevator = new Elevator(topFloor)

      when:
      elevator.moveUp()

      then:
      final int expectedCurrentFloor = 2
      expectedCurrentFloor == elevator.currentFloor
  }

  def "Given the elevator is on the top floor, moveUp() should not increment its currentFloor"() {
      given:
      final int topFloor = 1

      and:
      final Elevator elevator = new Elevator(topFloor)

      when:
      elevator.moveUp()

      then:
      topFloor == elevator.currentFloor
  }

  def "Given a valid elevator, moveDown() should decrement its currentFloor"() {
      given:
      final int topFloor = 10

      and:
      final Elevator elevator = new Elevator(topFloor)

      when:
      elevator.moveUp()
      elevator.moveDown()

      then:
      Elevator.GROUND_FLOOR == elevator.currentFloor
  }

  def "Given the elevator is on the ground floor, moveDown() should not decrement its currentFloor"() {
      given:
      final int topFloor = 10

      and:
      final Elevator elevator = new Elevator(topFloor)

      when:
      elevator.moveDown()

      then:
      Elevator.GROUND_FLOOR == elevator.currentFloor
  }

  def "Given a valid elevator, openDoors() will set the doorState to OPEN"() {
      given:
      final int topFloor = 10

      and:
      final Elevator elevator = new Elevator(topFloor)

      when:
      elevator.openDoors()

      then:
      DoorsState.OPEN == elevator.doorsState
  }

    def "Given a valid elevator, closeDoors() will set the doorState to CLOSE"() {
        given:
        final int topFloor = 10

        and:
        final Elevator elevator = new Elevator(topFloor)

        when:
        elevator.closeDoors()

        then:
        DoorsState.CLOSED == elevator.doorsState
    }

}
