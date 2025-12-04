package Behavioural.State;

public class Main {

    public static void main(String[] args) {

        StateContext stateContext = new StateContext();
        Task task = new Task("Gift Finder","Develop a gift finder app");


        System.out.println("Current State " + task.getState());

        //should  print invalid transition
        stateContext.moveToDONE(task);

        //valid
        stateContext.moveToINPROGRESS(task);

        //valid
        stateContext.moveToDONE(task);

    }

}
