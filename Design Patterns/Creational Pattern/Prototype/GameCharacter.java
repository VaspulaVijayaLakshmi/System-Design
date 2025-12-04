package Creational.Prototype;

public class GameCharacter implements Cloneable {

    String userName;
    String email;
    String phoneNumber;
    String name;
    int level;
    String badge;


    public GameCharacter(String userName, String email, String phoneNumber, String name, int level, String badge) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.level = level;
        this.badge = badge;

        System.out.println("GameCharacter object created with userName: " + userName + ", email: " + email +
                ", phoneNumber: " + phoneNumber + ", name: " + name + ", level: " + level + ", badge: " + badge);

    }

    @Override
    public GameCharacter clone() throws CloneNotSupportedException {
        return  (GameCharacter) super.clone();
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }


    public void setLevel(int level) {
        this.level = level;
    }

}
