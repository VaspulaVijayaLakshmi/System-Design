class Rook extends Piece {


    Rook(Color color, Position position) {
        super(color, position);
    }


    boolean isValidMove(Position target, Board board) {

        return position.row == target.row
            || position.col == target.col;
    }
}
