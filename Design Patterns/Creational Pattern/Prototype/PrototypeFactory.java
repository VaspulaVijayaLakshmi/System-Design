package Creational.Prototype;

public class PrototypeFactory{

    private GameCharacter gameCharacter;

    public PrototypeFactory() {
        //default constructor
        gameCharacter = new GameCharacter("defaultUserName","defaultEmail",
                "defaultPhoneNumber","defaultName",
                1,"defaultBadge");
    }

    public GameCharacter cloneWithBadgeUpdate(String badgeName) throws CloneNotSupportedException {
        GameCharacter newPrototypeCharacter  = gameCharacter.clone();
        newPrototypeCharacter.setBadge(badgeName);
        return newPrototypeCharacter;

    }


    public GameCharacter cloneWithLevelUpdate(int level) throws CloneNotSupportedException {
        GameCharacter newPrototypeCharacter = gameCharacter.clone();
        newPrototypeCharacter.setLevel(level);
        return newPrototypeCharacter;

    }

}
