package LLD_Interview_Problems.TicTacToe.State;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Game;
import LLD_Interview_Problems.TicTacToe.entities.Player;
import LLD_Interview_Problems.TicTacToe.enums.GameStatus;
import LLD_Interview_Problems.TicTacToe.exceptions.IllegalMoveException;

public class InProgressState implements GameState {

    @Override
    public void handleMove(Player player, Game game, int row, int col) {

         Board board = game.getBoard();

         //check if cell is already occupied
         if(!board.IsCellEmpty(row,col)){
             throw new IllegalMoveException("Cell is already occupied");
         }

         //check if its the correct users turn
         if(! player.equals(game.getCurrentPlayer())){
                throw new IllegalMoveException("Not your turn");
         }

         //handle the move
         board.setCell(player.getSymbol(),row,col);

         //check if the user won
         if(game.checkWinner(player,row,col)){
             //if he is the winner
             //update the game state
             game.setWinnerPlayer(player);
             game.setGameState(new GameOverState());
             game.setGameStatus(GameStatus.GAME_OVER);
         }

         //check if the board is full
            else if(board.isBoardFull()){
                //if its a draw
                game.setGameStatus(GameStatus.DRAW);
                game.setGameState(new DrawState());
         }

         else {
             //set the next player
             game.switchPlayer();
         }


     }

}
