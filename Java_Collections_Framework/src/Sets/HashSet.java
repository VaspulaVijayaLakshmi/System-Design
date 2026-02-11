package Sets;

public class HashSet {

//    HashSet in Java implements the Set interface of the Collections Framework. It is used to store the unique elements, and it doesn't maintain any specific order of elements.
//
//    HashSet does not allow duplicate elements.
//    Uses HashMap internally which is an implementation of hash table data structure.
//
//    HashSet is not thread-safe. To make it thread-safe, synchronization is needed externally.


//    Set<Integer> hs = new HashSet<>();
//       hs.add(1);


//    Capacity refers to the number of buckets in the hash table.
//    The default capacity of a HashSet is 16 and the load factor is 0.75.
//    When the number of elements exceeds the capacity automatically increases (resizes) to maintain performance.


//    Load Factor is a measure that controls how full the HashSet can get before resizing.
//    Default Load Factor = 0.75. If the number of elements exceeds the threshold, the capacity is doubled
//            new capacity = old capacity × 2



//    HashSet<String> hs = new HashSet<>();
//     hs.add("A");
//     hs.remove("B");
//


//    ITERATOR CLASS
//    Iterator<String> iterator = hs.iterator();

//      while (iterator.hasNext())
//      System.out.print(iterator.next() + ", ");

//    contains(), size(), isEmpty(), clear()



//    Hashset uses hashmap
//How HashSet works (internally)

//    HashSet is backed by a HashMap
//    Each element you add to a HashSet becomes a key in an internal HashMap


//    When you do:
//        set.add(x);


//    it actually does:
//    map.put(x, PRESENT);

//    Where hashing comes in
//
//    For every element:
//    hashCode() is called → decides the bucket
//    equals() is used → handles collisions



//    HashSet implements a Set interface. 	             HashMap implements a Map interface.
//    HashSet doesn't allow duplicate values.	             HashMap stores key-value pairs and doesn’t allow duplicate keys
//    HashSet requires only one object add(Object o).	     HashMap requires two objects put(K key, V Value)
//    HashSet internally uses a HashMap, where each element added is stored as a key with a dummy value.	             HashMap does not have any concept of dummy value.


}
