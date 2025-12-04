package Creational.Prototype;

public class Main {

    public static void main(String[] args) {

        PrototypeFactory prototype1 = new PrototypeFactory();

        try {
            GameCharacter character1 = prototype1.cloneWithBadgeUpdate("Radiator Badge");
            System.out.println("Character1 : " + character1.badge);


            GameCharacter character2 = prototype1.cloneWithLevelUpdate(10);
            System.out.println("character2: " + character2.level + " , " + character2.badge);

        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported");

        }
    }
}
