package Creational.FactoryPattern;

//public class Main{
//public static void main(String[] args){
//
//    Vehicle car= new Car();
//    car.start();
//
//    Vehicle bike = new Bike();
//    bike.start();
//
//}



//with Factory Pattern

 public class Main{
        public static void main(String[] args){

            VehicleFactory vehicleFactory = new VehicleFactory();
            Vehicle car = vehicleFactory.vehicle(VehicleType.CAR);
            car.start();

        }

}
