Game
├── Board
│ └── Cell[8][8] 
│
├── Player (White / Black)
│
├── Piece
│ ├── King
│ ├── Queen
│ ├── Rook
│ ├── Bishop
│ └── Knight
│
└── Move



# Requirements (Simplified)

Support:

- ✅ Two players
- ✅ 8x8 board
- ✅ Pieces
- ✅ Moving pieces
- ✅ Capturing pieces
- ✅ Turn switching
- ✅ Game status




Piece Movement Design

Each PieceType needs to have its own movement behavior.

Instead of having a single Piece class with all movement logic, each piece type can have its own class.

Each chess piece has its own movement behavior, so we will model them as separate classes.

This follows:

Single Responsibility Principle because Knight only knows Knight movement, Bishop only knows Bishop movement.
Open/Closed Principle because adding a new piece does not require modifying existing code.
