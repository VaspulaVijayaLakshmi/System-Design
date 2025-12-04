package Behavioural.State;

public class INPROGRESS  implements TaskStates{

    @Override
    public void moveToINPROGRESS(Task task,  StateContext stateContext){
        System.out.println("Task is already in INPROGRESS state");
    }

    @Override
    public void moveToDone(Task task,  StateContext stateContext){
        System.out.println("Task moved to DONE");
//        stateContext.setStateContext(new Done());
        task.state = STATE.DONE;
    }

    @Override
    public void moveToTODO(Task task, StateContext stateContext){
        System.out.println("Task moved to TODO");
        stateContext.setStateContext(new TODO());
        task.state = STATE.TO_DO;
    }

    @Override
    public void moveToACCEPTED(Task task,  StateContext stateContext){
        task.state = STATE.ACCEPTED;
        System.out.println("Moved to ACCEPTED");
    }

}
