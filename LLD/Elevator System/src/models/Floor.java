package models;

import enums.Direction;

public class Floor {

    int floorNumber;
    Direction direction;

    public Floor(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

     public int getFloorNumber() {
        return floorNumber;
    }

        public Direction getDirection() {
            return direction;
        }
}
