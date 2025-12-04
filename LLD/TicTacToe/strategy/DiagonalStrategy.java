package LLD_Interview_Problems.TicTacToe.strategy;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Player;
import LLD_Interview_Problems.TicTacToe.enums.Symbol;

public class DiagonalStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Player player) {

        // Main diagonal
        boolean mainDiagWin = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSymbol(i, i) != player.getSymbol()) {
                mainDiagWin = false;
                break;
            }
        }
        if (mainDiagWin) return true;

        // Anti-diagonal
        boolean antiDiagWin = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSymbol(i, board.getSize() - 1 - i) != player.getSymbol()) {
                antiDiagWin = false;
                break;
            }
        }
        return antiDiagWin;


    }
}
