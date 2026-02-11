package Map;

public class HASHMAP {

//    A HashMap is a part of Java’s Collection Framework and implements the Map interface. It stores elements in key-value pairs, where, Keys are unique. and Values can be duplicated.
//
//    Internally uses Hashing, hence allows efficient key-based retrieval, insertion, and removal with an average of O(1) time.
//    HashMap is not thread-safe, to make it synchronized, use Collections.synchronizedMap().
//    Insertion order is not preserved in HashMap. To preserve the insertion order, LinkedHashMap is used and to maintain sorted order, TreeMap is used.


//
//    HashMap<String, Integer> hashMap = new HashMap<>();
//
//    // Add elements to the HashMap
//        hashMap.put("John", 25);
//        hashMap.put("Jane", 30);
//        hashMap.put("Jim", 35);
//
//    // Iterate through the HashMap
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//        System.out(entry.getKey() + " " + entry.getValue() );
//}


//The capacity of a HashMap is the number of buckets it can hold for storing entries.
//
//            new capacity=old capacity×2
//
//    Default capacity: Default capacity of hashmap is 16.
//    Load factor: 0.75 (default): when 75% of the capacity is filled, the capacity is doubled.
