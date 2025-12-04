package LLD_Interview_Problems.StackOverflow.models;

public class Answer extends Content{

    private boolean isAccepted;

    public Answer(String description,User author){
        super(description,author);
        this.isAccepted=false;
    }

    public boolean isAccepted(){
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted){
        this.isAccepted=isAccepted;
    }
}

