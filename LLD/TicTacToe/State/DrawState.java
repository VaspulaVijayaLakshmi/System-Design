package LLD_Interview_Problems.TicTacToe.State;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Game;
import LLD_Interview_Problems.TicTacToe.entities.Player;

public class DrawState implements GameState {

    @Override
    public void handleMove(Player player, Game game, int row, int col) {
        throw new IllegalStateException("Game is already a draw. No more moves allowed.");
    }
}
