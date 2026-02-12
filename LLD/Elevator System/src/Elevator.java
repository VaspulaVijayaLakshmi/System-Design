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


    //addExternalREquest
    public void addExternalRequest(int floor){
        if(currentFloor > floor){
            downStops.add(floor);
        }
        else{
            upStops.add(floor);
        }

    }

    //addInternal Request
    public void addInternalRequest(int floor){
        if(currentFloor > floor){
            downStops.add(floor);
        }
        else{
            upStops.add(floor);
        }
    }

    public void move(){
        if(direction == Direction.UP){
            moveUp();
        }
        else if(direction == Direction.DOWN){
            moveDown();
        }
        else{
            setDirection();
        }
    }


    //move Up
    public void moveUp(){
        if(!upStops.isEmpty()){
            this.currentFloor = upStops.pollFirst();
        }
        else{
            direction = Direction.DOWN;
        }
    }

    //move Down
    public void moveDown(){
        if(!downStops.isEmpty()){
            this.currentFloor = downStops.pollFirst();
        }
        else{
            direction = Direction.UP;
        }

    }

    private void setDirection() {
        if (!upStops.isEmpty()) {
            direction = Direction.UP;
        } else if (!downStops.isEmpty()) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.IDLE;
        }
    }

    public boolean isIdle() {
        return direction == Direction.IDLE;
    }

}
