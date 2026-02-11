package Sets;

//public class ConcurrentSkipListSet {


//    In Java, the ConcurrentSkipListSet is the part of the java.util.concurrent package
//    and provides a scalable, thread-safe alternative to TreeSet.


//    It is a sorted set that lets multiple threads safely access and modify the set
//    at the same time without causing issues.

//    It is thread-safe.
//    Elements are in sorted order, and it supports navigable set operations (e.g., floor, ceiling, higher, lower).
//    Designed for high concurrency and to avoid contention between threads.

//    ConcurrentSkipListSet<Integer> s
//            = new ConcurrentSkipListSet<>();

//    ConcurrentSkipListSet

//✅ Thread-safe
//
//✅ High concurrency
//
//    Uses lock-free / fine-grained mechanisms
//
//    Backed by Skip List, not RB tree
//
//    Implements NavigableSet


}


//SkipList
//
//A Skip List is:
//
//Multiple linked lists layered on top of each other
//Bottom level is a normal sorted linked list
//
//Upper levels are “express lanes” that skip nodes
//
//Distance between nodes decreases as you go down
//
//
//Typically singly linked (forward pointers)
//
//Java’s ConcurrentSkipListSet uses forward links



//Search intuition
//
//Start at top-left
//
//Move right while value < target
//
//Drop down when you can’t move right
//
//Finish at bottom level