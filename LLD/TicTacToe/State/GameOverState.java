package LLD_Interview_Problems.TicTacToe.State;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Game;
import LLD_Interview_Problems.TicTacToe.entities.Player;

public class GameOverState implements GameState {

    @Override
    public void handleMove(Player player, Game game, int row, int col) {
        throw new IllegalStateException("Game is already over.");
    }
}
