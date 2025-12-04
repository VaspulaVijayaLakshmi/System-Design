package Creational.Builder;

public class Main {

    public static void main(String[] args) {

        User user = new User.Builder().
                setUserName("Vijaya").
                setEmail("abc@target.com").
                setAddress("Hyderabad").
                build();

        System.out.println("User Details:");
        System.out.println(user.userName);
        System.out.println(user.email);

    }
}
