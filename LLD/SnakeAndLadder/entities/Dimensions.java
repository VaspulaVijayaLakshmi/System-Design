package LLD_Interview_Problems.SnakeAndLadder.entities;

public class Dimensions {

    //we dont need dimenions of start and end
    //all we care is head of snake and tail of ladder

    int start;
    int end;

    public Dimensions(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
