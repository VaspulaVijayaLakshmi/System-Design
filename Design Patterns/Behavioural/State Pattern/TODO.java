package Behavioural.State;

public class TODO implements TaskStates {

    @Override
    public void moveToINPROGRESS(Task task, StateContext stateContext){
        System.out.println("Task "+ task.title +" moved to INPROGRESS");
        task.state = STATE.IN_PROGRESS;
        stateContext.setStateContext(new INPROGRESS());
    }

    @Override
    public void moveToDone(Task task, StateContext stateContext){
        System.out.println("Invalid Transition from TODO to DONE");
    }

    @Override
    public void moveToTODO(Task task, StateContext stateContext){
        System.out.println("Task is already in TODO state");
    }

    @Override
    public void moveToACCEPTED(Task task, StateContext stateContext){
       System.out.println("Invalid Transition from TODO to ACCEPTED");
    }

}
