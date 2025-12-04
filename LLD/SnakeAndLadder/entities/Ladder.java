package LLD_Interview_Problems.SnakeAndLadder.entities;

import LLD_Interview_Problems.SnakeAndLadder.exceptions.IllegalPositioningException;

public class Ladder extends Dimensions {

    public Ladder(int start, int end) {

        //first statement in costructor should be super
        super(start, end);
        if(start > end){
          throw new IllegalPositioningException("Check proper positioning if snake");
        }
    }
}
