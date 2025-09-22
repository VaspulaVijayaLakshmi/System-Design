https://algomaster.io/learn/design-patterns/java/chain-of-responsibility


Decouples the logic of request handling from the client code.
Series of handlers -> linked through links -> and the request processes the request or choose to pass it  through the next handler in series of handlers .


Create an Interface

create an abstract class, that would implement the common methods of forward request.
Then we can have concrete set of request handlers. extending the abstract class.

```java


// Handler
abstract class Approver {
    protected Approver nextApprover;
    
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
    
    public abstract void processRequest(PurchaseRequest request);
}



// Request
class PurchaseRequest {
    private double amount;
    private String purpose;
    
    public PurchaseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }
    
}



// Concrete Handlers
class TeamLead extends Approver {
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("TeamLead approved $" + request.getAmount());
        } else if (nextApprover != null) {

          //we have set teal lead nextApprover to manager object.
         //so next approver would be Manager.prcoessRequest

            nextApprover.processRequest(request);
        }
    }
}

class Manager extends Approver {
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Manager approved $" + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        }
    }
}



// Usage
public class Main {
    public static void main(String[] args) {


        Approver teamLead = new TeamLead();
        Approver manager = new Manager();


//setting the next handler of team lead to manager
        teamLead.setNextApprover(manager);
      
        PurchaseRequest req1 = new PurchaseRequest(500, "Office Supplies");
          
        teamLead.processRequest(req1);

    }
}


```
