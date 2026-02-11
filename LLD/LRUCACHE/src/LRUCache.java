import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head;
    Node tail;
    int capacity;

    int size;

    Map<Integer, Node> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        size=0;

        map= new HashMap<>();

        head = new Node(-1,-1);
        tail=new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public int getCapacity(){
        return capacity;
    }

    public int get(int key){

        //check if its present in map
        Node node = map.getOrDefault(key,null);

        if(node==null)
             return -1;

        //if yes access the address , bring tht node to head and adjust pointers
        node.next.prev = node.prev;
        node.prev.next = node.next;

        head.next.prev=node;
        node.next=head.next;

        node.prev=head;
        head.next=node;

        return node.val;

     }


    public void put(int key, int val){

        //check if it present in map

        Node node = map.getOrDefault(key,null);

        //not present
        if(node==null){

            //check if size is full
            if(size==capacity){

                //remove the last node
                Node lastNode = tail.prev;

                lastNode.prev.next=tail;
                tail.prev=lastNode.prev;

                map.remove(lastNode.key);
                size--;

            }


                Node newNode = new Node(key, val);
                map.put(key, newNode);

                //add to the front the list
                newNode.next = head.next;
                head.next.prev= newNode;
                head.next = newNode;
                newNode.prev = head;

               size++;

        }


        //present in map
        else{

            //bring to the front of the list
            node.next.prev = node.prev;
            node.prev.next = node.next;

            head.next.prev=node;
            node.next=head.next;

            node.prev=head;
            head.next=node;

            node.val=val;

        }



     }











}
