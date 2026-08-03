Game
 ├── Board
 │    └── Cell[8][8]
 ├── Player (White / Black)
 ├── Piece
 │    ├── King
 │    ├── Queen
 │    ├── Rook
 │    ├── Bishop
 │    └── Knight
 └── Move



Requirements (simplified)

Support:

✅ Two players
✅ 8x8 board
✅ Pieces
✅ Moving pieces
✅ Capturing pieces
✅ Turn switching
✅ Game status



A single Piece class with a type field is possible:

class Piece {
    Color color;
    PieceType type;
}


where:

enum PieceType {
    KING,
    QUEEN,
    ROOK,
    BISHOP,
    KNIGHT,
    PAWN
}


ANd Also each pieceType needs to have its own movement.SO instead of this 
Each peuce type can have its own CLass.



"Each chess piece has its own movement behavior, so I will model them as separate classes. 
This follows Single Responsibility Principle because Knight only knows Knight movement, Bishop only knows Bishop movement. 
It also follows Open/Closed Principle because adding a new piece does not require modifying existing code."



abstract class Piece {
    Color color;
    Position position;

    abstract boolean isValidMove(Position target, Board board);
}


Then:

class Knight extends Piece {

    boolean isValidMove(Position target, Board board) {
        int rowDiff = Math.abs(position.row - target.row);
        int colDiff = Math.abs(position.col - target.col);

        return (rowDiff == 2 && colDiff == 1) ||
               (rowDiff == 1 && colDiff == 2);
    }
}
class Bishop extends Piece {

    boolean isValidMove(Position target, Board board) {
        // diagonal movement logic
    }
}










