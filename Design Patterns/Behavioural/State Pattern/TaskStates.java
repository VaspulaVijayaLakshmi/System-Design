package Behavioural.State;

public interface TaskStates {

    public void moveToINPROGRESS(Task task, StateContext stateContext);

    public void moveToDone(Task task,  StateContext stateContext);

    public void moveToTODO(Task task,  StateContext stateContext);

    public void moveToACCEPTED(Task task,  StateContext stateContext);
}
