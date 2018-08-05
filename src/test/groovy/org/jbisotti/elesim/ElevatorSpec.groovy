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

}
