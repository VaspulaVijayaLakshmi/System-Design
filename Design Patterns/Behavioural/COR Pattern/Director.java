package Behavioural.ChainOfResponsibility;

public class Director extends Approver {

    @Override
    public void approveRequest(String request) {

        if(request.equals("Project Leave")) {
            System.out.println("Director approve request");
        }
        else{
            if(nextApprover != null){
                nextApprover.approveRequest(request);
            }
        }
    }

}
