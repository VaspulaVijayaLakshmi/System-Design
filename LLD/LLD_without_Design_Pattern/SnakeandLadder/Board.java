package LLD_without_Design_Pattern.SnakeandLadder;

import java.util.List;

public class Board {

    int size;

    List<Snake> snakes;
    List<Ladder> ladders;
    List<Player> players;


    public Board(int size,
                 List<Snake> snakes,
                 List<Ladder> ladders,
                 List<Player> players) {

        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;

    }

    //move
    public boolean movePlayer(Player player, int moves){

     int currPos = player.currPos;
     int nextPos = currPos + moves;

     boolean isSnake=false;

     //check if the next move is snake/ladder
     for(Snake snake : snakes){
         if(snake.start == nextPos){
             nextPos= snake.end;
             isSnake = true;
             break;
         }
     }

     if(!isSnake){
         for(Ladder ladder : ladders){
             if(ladder.end == nextPos){
                 nextPos=ladder.start;
                 break;
             }
         }
     }


     player.currPos=nextPos;

     //check if the player won
        if(player.currPos >= size){
            System.out.println("Player "+ player.playerName + " has won the game!");
            return true;
        }

        return false;

    }











}