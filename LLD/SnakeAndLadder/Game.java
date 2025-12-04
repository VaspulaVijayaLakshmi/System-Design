package LLD_Interview_Problems.SnakeAndLadder;

import LLD_Interview_Problems.SnakeAndLadder.entities.Board;
import LLD_Interview_Problems.SnakeAndLadder.entities.Ladder;
import LLD_Interview_Problems.SnakeAndLadder.entities.Player;
import LLD_Interview_Problems.SnakeAndLadder.entities.Snake;
import LLD_Interview_Problems.SnakeAndLadder.enums.GameStatus;
import LLD_Interview_Problems.SnakeAndLadder.exceptions.IllegalMoveException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    //we can list of players , unline TICTACTOE
    //so to tract the current player, you can maintain index, pointing to
    //the curr index in the players list

    private Queue<Player> players;
    private Board board;
    private Player winner;

    //you can have gamestate also but not necessary here, refer tictactoe for that

    private GameStatus gameStatus;


    public Game(Builder builder){
       this.players = builder.players;
       this.board = builder.board;
       this.gameStatus = GameStatus.IN_PROGRESS;
    }


    //Builder Class

    public static  class Builder{

        private Queue<Player> players;
        private Board board;

        public Builder setPlayers(List<String> players){
            this.players = new LinkedList<>();

            for(String playerName: players){
                this.players.add(new Player(playerName));
            }

            return this;

        }

        public Builder setBoard(int size, List<Snake> snakes, List<Ladder> ladders){
            this.board = new Board(size, snakes, ladders);
            return this;
        }

        public Game build(){
            return new Game(this);
        }

    }

    public void play(){

        if(players.size()<2){
            System.out.println("We need atleast 2 Players to start the game");
            return;
        }

        while(this.gameStatus == GameStatus.IN_PROGRESS) {

            Player currPlayer = players.poll();
            makeMove(currPlayer);

            //add that player to the end.
            players.add(currPlayer);

        }

            System.out.println("GAME OVER!!");

        System.out.println("The winner is " + this.winner.getName());
    }



    public void makeMove(Player player) {
        try {

            int currPos = player.getCurrPosition();

            //roll dice
            int val = rollDice();
            int newPos = currPos + val;


            if (newPos > board.getSize()) {
                System.out.println("You reached out if bounds, try in next turn");

                return ;
            }


            if (newPos == board.getSize()) {
                players.remove(player);
                this.winner = player;
                this.gameStatus = GameStatus.GAME_OVER;

                System.out.println("Hurray! " + player.getName() + " has reached the end!!");

                return ;
            }

            //check if its a snake or ladder
            int snakeEnd = board.isSnake(newPos);
            if (snakeEnd != 0) {
                newPos = snakeEnd;
            }

            int ladderStart = board.isLadder(newPos);
            if (ladderStart != 0) {
                newPos = ladderStart;
            }

            player.setCurrPosition(newPos);

        }
        catch(IllegalMoveException e){
            System.out.println(e.getMessage());
        }

    }



    public int rollDice(){
        return (int)(Math.random() * 6) + 1;
    }


//    public void isCurrentPlayersTurn(Player player){
//
//        if(players.peek() != player) {
//            throw new IllegalMoveException("Not your turn");
//        }
//
//    }

}
