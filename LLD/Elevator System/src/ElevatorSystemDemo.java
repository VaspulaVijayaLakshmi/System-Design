import enums.Direction;

public class ElevatorSystemDemo {

        public static void main(String[] args) {

            ElevatorController controller = new ElevatorController(2);

            // External request: Floor 3 wants to go UP
            ExternalRequest req1 = new ExternalRequest(3, Direction.UP);
            controller.handleExternalRequest(req1);

            // External request: Floor 7 wants to go DOWN
            ExternalRequest req2 = new ExternalRequest(7, Direction.DOWN);
            controller.handleExternalRequest(req2);

            // Simulate elevator movement
            for (int i = 0; i < 5; i++) {
                for (Elevator elevator : controller.elevators) {
                    elevator.move();
                    System.out.println("Elevator " + elevator.id +
                            " at floor " + elevator.currentFloor +
                            " direction " + elevator.direction);
                }
                System.out.println("----");
            }

//            // Simulate internal request inside elevator 0
//            Elevator elevator0 = controller.elevators.get(0);
//            elevator0.addInternalRequest(new InternalRequest(10));
//
//            // Move again
//            for (int i = 0; i < 5; i++) {
//                elevator0.move();
//                System.out.println("Elevator " + elevator0.id +
//                        " at floor " + elevator0.currentFloor +
//                        " direction " + elevator0.direction);
//            }
        }
    }


