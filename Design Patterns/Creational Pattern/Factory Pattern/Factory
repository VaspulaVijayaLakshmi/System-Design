These 2 examples are the best.
Undertstnd the implementation thoroughly.


https://algomaster.io/learn/design-patterns/java/factory-method


Factory Design Pattern

The Factory Pattern provides an interface for creating objects but lets subclasses decide which class to instantiate.
It decouples object creation from usage, reducing tight coupling between client code and concrete classes.


🚦 How It Works

Define a common interface or abstract class for the product.
Implement concrete classes that implement the product interface.
Create a Factory class with a method that returns an object of the product interface.
The client calls the factory method instead of new to get objects.



```

// Base Product
interface Controller {
    void connect();
}

// Concrete Products
class PSController implements Controller {
    public void connect() {
        System.out.println("Connecting PlayStation Controller...");
    }
}

class XboxController implements Controller {
    public void connect() {
        System.out.println("Connecting Xbox Controller...");
    }
}

// Factory Method Creator
abstract class ControllerCreator {


//this is the create COntroller main fucntion tht will create objects
//so tht subclasses will implemn this.
    public abstract Controller createController();



//abstarct classes can have other methods as well
    public void setup() {
        Controller c = createController();
        c.connect();
    }
}

// Subclasses (decide which controller to make)
class PSControllerCreator extends ControllerCreator {
    public Controller createController() {
        return new PSController();
    }
}

class XboxControllerCreator extends ControllerCreator {
    public Controller createController() {
        return new XboxController();
    }
}

// Client
public class FactoryMethodDemo {
    public static void main(String[] args) {
        ControllerCreator creator = new XboxControllerCreator();
        creator.setup();  // Output: Connecting Xbox Controller...
    }
}
```
