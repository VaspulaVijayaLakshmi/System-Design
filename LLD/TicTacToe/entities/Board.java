package LLD_Interview_Problems.TicTacToe.entities;

import LLD_Interview_Problems.TicTacToe.enums.Symbol;
import LLD_Interview_Problems.TicTacToe.exceptions.IllegalMoveException;

public class Board {

   private Symbol[][] grid;
   private int size;
    private int movesCount;

    public Board(int size) {

       this.size=size;
       this.grid = new Symbol[size][size];

         for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                grid[i][j] = Symbol.EMPTY;
              }

         }
    }

    public boolean isBoardFull() {
        return movesCount == size * size;
    }

    public int getSize() {
        return size;
    }

    public Symbol[][] getGrid() {
        return grid;
    }

    public Symbol getSymbol(int row,int col){
        return grid[row][col];
    }


    public void setCell(Symbol symbol, int row,int col){

        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalMoveException("Invalid position: out of bounds.");
        }

        if (getSymbol(row,col) != Symbol.EMPTY) {
            throw new IllegalMoveException("Invalid position: cell is already occupied.");
        }

        movesCount++;
        grid[row][col] = symbol;
    }

    public boolean IsCellEmpty(int row, int col){
        return grid[row][col] == Symbol.EMPTY;
    }

}
