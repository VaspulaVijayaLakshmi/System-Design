package LLD_Interview_Problems.TicTacToe.entities;

import LLD_Interview_Problems.TicTacToe.State.GameState;
import LLD_Interview_Problems.TicTacToe.State.InProgressState;
import LLD_Interview_Problems.TicTacToe.enums.GameStatus;
import LLD_Interview_Problems.TicTacToe.strategy.ColumnWiseStrategy;
import LLD_Interview_Problems.TicTacToe.strategy.DiagonalStrategy;
import LLD_Interview_Problems.TicTacToe.strategy.RowWiseStrategy;
import LLD_Interview_Problems.TicTacToe.strategy.WinningStrategy;

import java.util.List;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameState gameState;
    private GameStatus gameStatus;
    private List<WinningStrategy> winningStrategy;
    private Player WinnerPlayer;


    public Game(Board board, Player player1, Player player2){
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameState = new InProgressState();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategy = List.of(new RowWiseStrategy(),
                        new ColumnWiseStrategy(),
                        new DiagonalStrategy());
    }

    public void play(Player player, int row, int col){
        gameState.handleMove(player ,this, row, col);
    }

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

    public void setWinnerPlayer(Player WinnerPlayer){
        this.WinnerPlayer = WinnerPlayer;
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public Board getBoard(){
        return this.board;
    }

    public boolean checkWinner(Player player, int row, int col){
        for(WinningStrategy strategy : winningStrategy){
            if(strategy.checkWinner(this.board, player)){
                return true;
            }
        }
        return false;
    }

    public void switchPlayer(){
        if(this.currentPlayer.equals(this.player1)){
            this.currentPlayer = this.player2;
        }else{
            this.currentPlayer = this.player1;
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner(){
        return WinnerPlayer;
    }
}
