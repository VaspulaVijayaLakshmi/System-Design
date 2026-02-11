package Queue;

public class BlockingQUeue {
}

//BlockingQueue is part of the java.util.concurrent package and extends the Queue interface. It represents a thread-safe
//queue that supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available when
//storing an element.

//Thread Safe: BlockingQueue implementations are thread-safe, with all methods being atomic.
//Blocking Operation: Has blocking behavior if the queue is full (for producers) or empty (for consumers).

//public class GFG{
//
//    public static void main(String[] args) throws InterruptedException{
//
//        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
//
//        // Add elements
//        queue.put(1);
//        queue.put(2);
//        queue.put(3);
//
//        System.out.println("BlockingQueue: " + queue);
//    }
//}



//Unbounded Queue
//Unbounded Queue is a queue that has no fixed capacity limit, allowing elements to be added indefinitely until system memory is exhausted


//Bounded Queue
//Bounded Queue is a queue with a fixed capacity that limits the number of elements it can hold at a time.


//
//Classes that Implement BlockingQueue
//LinkedBlockingQueue: An optionally bounded blocking queue backed by linked nodes,
//ArrayBlockingQueue: A bounded blocking queue backed by an array that stores elements in FIFO order.










//INTERFACES CAN EXTEND EACH OTHER

//interface A {
//    void a();
//}
//
//interface B extends A {
//    void b();
//}