package LLD_Interview_Problems.TicTacToe.strategy;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Player;

public class ColumnWiseStrategy  implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Player player) {

        for (int col = 0; col < board.getSize(); col++) {
            boolean colWin = true;
            for (int row = 0; row < board.getSize(); row++) {
                if (board.getSymbol(row, col) != player.getSymbol()) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        return false;

    }
}
