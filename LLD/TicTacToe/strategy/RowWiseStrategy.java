package LLD_Interview_Problems.TicTacToe.strategy;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Player;
import LLD_Interview_Problems.TicTacToe.enums.Symbol;

public class RowWiseStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Player player) {

        for (int row = 0; row < board.getSize(); row++) {
            boolean rowWin = true;
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getSymbol(row, col) != player.getSymbol()) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        return false;

    }
}
