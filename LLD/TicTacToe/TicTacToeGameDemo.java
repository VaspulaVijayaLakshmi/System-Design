package LLD_Interview_Problems.TicTacToe;

import LLD_Interview_Problems.TicTacToe.entities.Board;
import LLD_Interview_Problems.TicTacToe.entities.Game;
import LLD_Interview_Problems.TicTacToe.entities.Player;
import LLD_Interview_Problems.TicTacToe.enums.Symbol;

public class TicTacToeGameDemo {

    public static void main(String[] args) {

    Board board = new Board(3);

    Player alice = new Player("Alice", Symbol.X);
    Player bob = new Player("Bob", Symbol.O);


    Game game = new Game(board, alice, bob);

    //ALice Wins

        game.play(alice, 0, 0);
        game.play(bob, 1, 0);
        game.play(alice, 0, 1);
        game.play(bob, 1, 1);
        game.play(alice, 0, 2);

        System.out.println(game.getWinner().getName());
        System.out.println(game.getGameStatus());

        System.out.println("----------------------------------------\n");

        Board board2 = new Board(3);
        Game game2 = new Game(board2, alice, bob);

        game2.play(alice, 0, 0);
        game2.play(bob, 1, 0);
        game2.play(alice, 0, 1);
        game2.play(bob, 1, 1);
        game2.play(alice, 2, 2);
        game2.play(bob, 1, 2); // Bob wins,

        System.out.println(game2.getWinner().getName());
        System.out.println(game2.getGameStatus());

        System.out.println("----------------------------------------\n");


        //DRAW GAME

        //for draw game we were throwing exception

        Board board3 = new Board(3);
        Game game3 = new Game(board3, alice, bob);

        game3.play(alice, 0, 0);
        game3.play(bob, 0, 1);
        game3.play(alice, 0, 2);
        game3.play(bob, 1, 1);
        game3.play(alice, 1, 0);
        game3.play(bob, 1, 2);
        game3.play(alice, 2, 1);
        game3.play(bob, 2, 0);
        game3.play(alice, 2, 2);


        System.out.println(game3.getGameStatus());
        //        System.out.println(game3.getWinner().getName());

}

}
