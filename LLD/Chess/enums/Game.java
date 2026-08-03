class Game {


    Board board;

    Player white;
    Player black;

    Color currentTurn;

    GameStatus status;



    Game(Player white, Player black) {

        this.white = white;
        this.black = black;

        board = new Board();

        currentTurn = Color.WHITE;

        status = GameStatus.STARTED;
    }



    boolean move(Position from, Position to) {


        Piece piece = board.getPiece(from);


        // no piece
        if(piece == null)
            return false;


        // wrong player turn
        if(piece.color != currentTurn)
            return false;



        // invalid movement
        if(!piece.isValidMove(to, board))
            return false;



        board.move(from,to);



        // switch turn

        if(currentTurn == Color.WHITE)
            currentTurn = Color.BLACK;
        else
            currentTurn = Color.WHITE;



        return true;
    }
}
