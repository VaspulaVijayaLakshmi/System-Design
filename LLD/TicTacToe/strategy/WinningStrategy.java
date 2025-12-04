package LLD_Interview_Problems.TicTacToe.strategy;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Player;
import LLD_Interview_Problems.TicTacToe.enums.Symbol;

public interface WinningStrategy {

    boolean checkWinner(Board board, Player player);
}
