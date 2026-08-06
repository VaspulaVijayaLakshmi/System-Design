import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class Bucket<K,V> {

 LinkedList<Node<K,V>> nodes;
 ReentrantLock lock;

 public Bucket(){

     nodes=new LinkedList<>();
     lock=new ReentrantLock();
 }
}
