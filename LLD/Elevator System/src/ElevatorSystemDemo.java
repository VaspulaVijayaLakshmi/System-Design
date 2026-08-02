import enums.Direction;

public class Main {

    public static void main(String[] args) {

        // Create Elevator Controller with 5 elevators
        ElevatorController controller =
                new ElevatorController(5);

        // User on floor 3 presses UP
        ExternalRequest request =
                new ExternalRequest(
                        3,
                        Direction.UP
                );

        // Controller finds best elevator
        controller.handleElevatorRequest(request);

        // Get the assigned elevator
        Elevator elevator =
                controller.findBestElevator(request);

        System.out.println(
                "Assigned Elevator: "
                        + elevator.id
        );

        // Move elevator to requested floor
        elevator.move();

        System.out.println(
                "Elevator current floor: "
                        + elevator.currentFloor
        );

        // Passenger enters and selects floor 10
        elevator.addInternalRequest(10);

        // Move elevator to floor 10
        elevator.move();

        System.out.println(
                "Elevator current floor: "
                        + elevator.currentFloor
        );
    }
}
