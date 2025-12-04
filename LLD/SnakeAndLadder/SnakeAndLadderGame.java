package LLD_Interview_Problems.SnakeAndLadder;

import LLD_Interview_Problems.SnakeAndLadder.entities.Dimensions;
import LLD_Interview_Problems.SnakeAndLadder.entities.Ladder;
import LLD_Interview_Problems.SnakeAndLadder.entities.Snake;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderGame {

    public static void main(String[] args) {

        List<Snake> snakes = List.of(
                new Snake(17, 7), new Snake(54, 34),
                new Snake(62, 19), new Snake(98, 79)
                );

        List<Ladder> ladders = List.of(
                new Ladder(3, 38), new Ladder(24, 33),
                new Ladder(42, 93), new Ladder(72, 84)
        );


        List<String> players = Arrays.asList("Alice", "Bob", "Charlie");


        Game game = new Game.Builder()
                .setBoard(100,snakes,ladders)
                .setPlayers(players)
                .build();

        game.play();

    }
}
