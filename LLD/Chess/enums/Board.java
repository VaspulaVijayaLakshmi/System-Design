class Board {

    Cell[][] cells;


    Board() {

        cells = new Cell[8][8];


        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                cells[i][j] = 
                    new Cell(new Position(i,j));
            }
        }
    }


    Piece getPiece(Position position) {

        return cells[position.row][position.col] .piece;
    }


  
   void move(Position from, Position to) {

        Piece piece = getPiece(from);


        cells[to.row][to.col].piece = piece;

        cells[from.row][from.col].piece = null;


        piece.position = to;
    }
}

  
