package Behavioural.ChainOfResponsibility;

public class Main {

    public static void main(String[] args) {

        Approver hr = new HR();
        Approver manager = new Manager();
        Approver director = new Director();

        //setting next Approvers
        hr.setNextApprover(manager);
        manager.setNextApprover(director);


        hr.approveRequest("Sick Leave");

        hr.approveRequest("Casual Leave");

        manager.approveRequest("Project Leave");

    }
}
