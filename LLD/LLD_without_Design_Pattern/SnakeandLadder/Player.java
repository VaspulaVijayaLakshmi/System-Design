package LLD_without_Design_Pattern.SnakeandLadder;

public class Player{

    String playerId;
    String playerName;
    int currPos;

    //if there r multiple players and if one alredy one, we can make him inelgible to continue
//    bool isEligibleToPlay;

    public Player(String playerId, String playerName){
        this.playerId = playerId;
        this.playerName = playerName;
        this.currPos = 1; //initial position


        //this.isEligibleToPlay = true; //initially eligible to play

    }


}