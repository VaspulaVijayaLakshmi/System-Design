abstract class Piece {

    Color color;
    Position position;

    Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }


    abstract boolean isValidMove(Position target, Board board);
}
