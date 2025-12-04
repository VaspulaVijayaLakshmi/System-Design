package LLD_without_Design_Pattern.SnakeandLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SnakeandLadderDemo{

    public static void main(String args[]){
        System.out.println("Snake and Ladder Game Started");

        Random random = new Random();

        // Snakes
        Snake snake1 = new Snake(17, 7);
        Snake snake2 = new Snake(54, 34);
        Snake snake3 = new Snake(62, 19);
        Snake snake4 = new Snake(64, 60);
        Snake snake5 = new Snake(98, 79);

        List<Snake> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);
        snakes.add(snake5);

        // Ladders
        Ladder ladder1 = new Ladder(3, 22);
        Ladder ladder2 = new Ladder(5, 8);
        Ladder ladder3 = new Ladder(20, 29);
        Ladder ladder4 = new Ladder(27, 56);
        Ladder ladder5 = new Ladder(72, 90);

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);
        ladders.add(ladder4);
        ladders.add(ladder5);

//      players
        Player player1 = new Player("P1","player1");
        Player player2 = new Player("P2","player2");

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);


        //Initalise the board
        Board board = new Board(100,snakes,ladders,players);

        //Players will take turns to roll the dice and play
        while(true){

            for(Player player: players){

                //dice roll;
                int diceRoll = random.nextInt(6) + 1;
                if(board.movePlayer(player,diceRoll)){
                    return ;
                }

            }

        }

    }
}




//Board - players , snakes, laders, dimensions - default 10*10
//Player - Name/Id, position....
//Snakes - List<strt,end>
//Ladders - List<strt,end>
//Game - starts the game - maintains player......