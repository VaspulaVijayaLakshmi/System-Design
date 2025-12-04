package LLD_Interview_Problems.SnakeAndLadder.entities;

import java.util.List;

public class Board {

    private List<Snake> snakes;
    private List<Ladder> ladders;
    private int size;
    private int[] board;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders){

        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.board = new int[size];
    }

    public int isSnake(int position){

        for(Snake snake: snakes){
            if(snake.getStart() == position){
                return snake.getEnd();
            }
        }
        return 0;
    }

    public int isLadder(int position){

        for(Ladder ladder: ladders){
            if(ladder.getEnd() == position){
                return ladder.getStart();
            }
        }
        return 0;
    }

    public int getSize(){
        return this.size;
    }

}
