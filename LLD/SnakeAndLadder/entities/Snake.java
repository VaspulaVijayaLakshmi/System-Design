package LLD_Interview_Problems.SnakeAndLadder.entities;

import LLD_Interview_Problems.SnakeAndLadder.exceptions.IllegalPositioningException;

public class Snake extends Dimensions{

    public Snake(int start, int end){

        super(start,end);
        if(start < end){
          throw new IllegalPositioningException("Check proper positioning if Ladder");
        }

    }
}
