class Knight extends Piece {


    Knight(Color color, Position position) {
        super(color, position);
    }


    boolean isValidMove(Position target, Board board) {

        int rowDiff = Math.abs(
            position.row - target.row
        );

        int colDiff = Math.abs(
            position.col - target.col
        );


        return (rowDiff == 2 && colDiff == 1)
            || (rowDiff == 1 && colDiff == 2);
    }
}
