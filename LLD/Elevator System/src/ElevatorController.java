import enums.Direction;
import enums.ElevatorState;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public ElevatorController(int numberOfElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }


    public void handleExternalRequest(ExternalRequest request){
        Elevator bestElevator = findBestElevator(request);
        bestElevator.addExternalRequest(request.floorNumber);
    }


    public Elevator findBestElevator(ExternalRequest request){

        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator elevator: elevators){

            if (elevator.isIdle()) {
                int distance = Math.abs(elevator.currentFloor - request.floorNumber);

                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }

        }

        if (bestElevator == null) {
            bestElevator = elevators.get(0);
        }

        return bestElevator;

    }

}
