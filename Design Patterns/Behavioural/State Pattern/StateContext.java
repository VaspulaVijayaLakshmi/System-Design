package Behavioural.State;


public class StateContext {

   TaskStates taskState;

    public StateContext() {
        taskState = new TODO();
    }

    public void setStateContext(TaskStates taskState){
        this.taskState = taskState;
    }


    //this I noticed while testing...

//    Current State TO_DO
//    Task Gift Finder moved to INPROGRESS
//    Invalid Transition from TODO to DONE

    //even after micing to INPORGRESS it was still in TODO state because the stateContext object passed was different

    //hence we need to use the curr object reference, and pass 'this'.

//    public void moveToINPROGRESS(Task task,  StateContext stateContext){
//        taskState.moveToINPROGRESS(task,stateContext);
//    }
//

    public void moveToINPROGRESS(Task task){
        taskState.moveToINPROGRESS(task,this);
    }


    public void moveToDONE(Task task){
        taskState.moveToDone(task,this);
    }

    public void moveToAccepted(Task task){
        taskState.moveToACCEPTED(task, this);
    }







    public TaskStates getCurrentState(){
        return taskState;
    }

}
