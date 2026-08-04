import enums.Direction;
import enums.ElevatorState;

import java.util.Comparator;
import java.util.TreeSet;

public class Elevator {

    int id;
    int currentFloor;
    ElevatorState currentState;
    Direction direction;

    TreeSet<Integer> upStops;
    TreeSet<Integer> downStops;

    public Elevator(int id) {

        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.currentState = ElevatorState.STOPPED;
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>(Comparator.reverseOrder());

    }


    
    // Called by ElevatorController
    // for external UP/DOWN request
    public void addExternalRequest(int floor) {
        addRequest(floor);
    }


    // Called when user selects destination
    // from inside the elevator
    public void addInternalRequest(int floor) {
        addRequest(floor);
    }



//since the elevatorSleectionSTregey have found the best eleveator that will be mving in the same direction we dont need to do it again.
 private void addRequest(int floor) {

    if (floor == currentFloor) {
        return;
    }

    if (floor > currentFloor) {
        upStops.add(floor);
    } else {
        downStops.add(floor);
    }

    startMovingIfIdle();
}


private void startMovingIfIdle() {

    if (direction != Direction.IDLE) {
        return;
    }

    if (!upStops.isEmpty()) {
        direction = Direction.UP;
    } else if (!downStops.isEmpty()) {
        direction = Direction.DOWN;
    }
}
    

    
    public void move(){
        if(direction == Direction.UP){
            moveUp();
        }
        else if(direction == Direction.DOWN){
            moveDown();
        }
    }


    private void moveUp() {

        if (!upStops.isEmpty()) {

            currentFloor =
                    upStops.pollFirst();

        } else if (!downStops.isEmpty()) {

            direction = Direction.DOWN;

        } else {

            direction = Direction.IDLE;
        }
    }


    
     private void moveDown() {

        if (!downStops.isEmpty()) {

            currentFloor =
                    downStops.pollFirst();

        } else if (!upStops.isEmpty()) {

            direction = Direction.UP;

        } else {

            direction = Direction.IDLE;
        }
    }


}
