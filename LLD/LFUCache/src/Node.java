public class Node {

    int key;
    int val;
    int freq;
    Node next;
    Node prev;


    public Node(int key, int val){
        this.key = key;
        this.val = val;
        freq=1;

        next=null;
        prev=null;

    }


}
