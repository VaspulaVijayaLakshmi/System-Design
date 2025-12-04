package Behavioural.ChainOfResponsibility;

public class Manager extends Approver{

        @Override
        public void approveRequest(String request) {

            if(request.equals("Casual Leave")) {
                System.out.println("Manager approve request");
            }
            else{
                if(nextApprover != null){
                    nextApprover.approveRequest(request);
                }
            }

        }
}
