package Creational.Builder;

public class User {

    String userName;
    String email;
    String phoneNumber;
    String address;
    int age;
    String gender;

    private User(Builder builder) {
        this.userName = builder.userName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.age = builder.age;
        this.gender = builder.gender;


        System.out.println("User created");
    }


    static class Builder{

        String userName;
        String email;
        String phoneNumber;
        String address;
        int age;
        String gender;

        public Builder setUserName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Builder setAge(int age){
        this.age = age;
        return this;
        }


        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }


        public User build(){
            return new User(this);
        }
    }





}
