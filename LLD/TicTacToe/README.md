So classes and entities



# Tic Tac Toe - Low Level Design

We can have strategy Pattern

since we have 3 checks everytime

checkMethod

row strategy
Column Strategy
Diagonal Strategy



We can have state pattern

IN progress - people can play
Draw - its draw or reset the board?
Win - After winning you can continue to play, tell game is over


Game Clas -  which will have all players, board, the game status, current player ..



We can have Board class
Player class
Game Clas
Symbols - enum( X , O , EMPTY )
GAMESTATUS - enum ( IN_PROGRESS, DRAW, WIN )



in state pattern

can play() -> check the progess and then based on ststaet we can proceeed or give message;


