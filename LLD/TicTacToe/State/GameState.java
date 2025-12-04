package LLD_Interview_Problems.TicTacToe.State;


import LLD_Interview_Problems.TicTacToe.entities.Game;
import LLD_Interview_Problems.TicTacToe.entities.Player;

 public interface GameState {

     void handleMove(Player player, Game game, int row, int col);

}
