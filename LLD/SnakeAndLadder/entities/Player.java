package LLD_Interview_Problems.SnakeAndLadder.entities;

public class Player {

    String name;
    int currPosition;

    public Player(String name){
        this.name = name;
        currPosition = 0;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
         this.name = name;
    }

    public int getCurrPosition(){
        return currPosition;
    }

    public void setCurrPosition(int currPosition){
        this.currPosition = currPosition;
    }

}
