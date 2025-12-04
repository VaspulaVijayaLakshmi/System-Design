package Behavioural.ChainOfResponsibility;

public class HR extends Approver{

    @Override
    public void approveRequest(String request) {

        if(request.equals("Sick Leave")) {
            System.out.println("HR approve request");
        }
        else{
            if(nextApprover != null){
                nextApprover.approveRequest(request);
            }
        }
    }

}
