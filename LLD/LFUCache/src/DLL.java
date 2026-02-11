import java.util.HashMap;
import java.util.Map;

public class DLL {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int size=0;

    public DLL(){

        head = new Node(-1,-1) ;
        tail = new Node(-1, -1);
        map = new HashMap<>() ;

        head.next = tail;
        tail.prev=head;

    }


    //remove node
    public void remove(Node node){

        if(size==0) return ;

        node.next.prev = node.prev;
        node.prev.next=node.next;
        size--;

    }

    //add node to the head of LL
    public void addToHead(Node node){

        head.next.prev = node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
        size++;
    }


    //size hits
    public Node removeFromTail(){

        if(size==0) return null;

        Node node = tail.prev;

        tail.prev.prev = tail;
        tail.prev=tail.prev.prev;
        size--;

        return node;
    }


}
