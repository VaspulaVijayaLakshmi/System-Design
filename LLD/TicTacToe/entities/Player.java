package LLD_Interview_Problems.TicTacToe.entities;

import LLD_Interview_Problems.TicTacToe.enums.Symbol;

public class Player {

    private String name;
    private final Symbol symbol;;

    public Player(String name, Symbol symbol) {
        this.name=name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
