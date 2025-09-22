https://algomaster.io/learn/design-patterns/java/state


For example, a Document class might use if-else blocks to determine what to do based on whether it's in "Draft", "Review", or "Published" state.


As the number of states grows, this approach becomes hard to scale, difficult to test, and violates the Open/Closed Principle — any new state requires modifying existing logic, 
increasing the risk of breaking current functionality.



In this, We have 3 things


Interface defining - operations we can do
Each state class - extends this interface




(LOOK AT THE DIAGRAM)

-> Define a State interface (or abstract class) that declares methods representing the actions the Context can perform.

-> Create ConcreteState classes, each implementing the State interface. 
   Each ConcreteState class implements the behavior specific to that particular state of the Context.

-> The Context class maintains an instance of a ConcreteState subclass that defines its current state.






*********

```java

interface State {
    void handle();
}


  class OnState implements State {
    @Override
    public void handle() {
        System.out.println("Device is ON");
    }
}

class OffState implements State {
    @Override
    public void handle() {
        System.out.println("Device is OFF");
    }
}
```


