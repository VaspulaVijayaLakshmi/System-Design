package Behavioural.State;

public class Task {

    String title;
    String description;
    STATE state;

    public Task(String title, String description){
        this.description = description;
        this.title = title;
        this.state = STATE.TO_DO;
    }


    public STATE getState() {
        return state;
    }
}
