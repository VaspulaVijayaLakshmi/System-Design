package ConcurrencyCOllection;
//
//Concurrent collections are designed for multi-threaded environments. They ensure thread-safe access without compromising performance.
//
//In Java, the ConcurrentHashMap is a thread-safe implementation of the Map interface. It allows multiple threads to read and write data simultaneously,
//without the need for locking the entire map. Unlike a regular HashMap, which is not thread-safe, ConcurrentHashMap ensures that the operations are thread-safe, making it ideal for scenarios where
//multiple threads need to access and modify the map concurrently.
//
//
//
//Provides thread-safe operations without locking the entire map.
//Allows multiple threads to operate concurrently by dividing the map into segments.
//Supports atomic operations like putIfAbsent(), replace() and remove()



//Concurrency-Level: It is the number of threads concurrently updating the map. The implementation performs internal sizing to try to accommodate this many threads.
//Load-Factor: It’s a threshold, used to control resizing.
//Initial Capacity: Accommodation of a certain number of elements initially provided by the implementation. if the capacity of this map is 10. It means that it can store 10 entries.



//ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

//_________________


//CopyOnWriteArrayList in Java

//
//
//It is an enhanced version of ArrayList in which all modifications (add, set, remove, etc) are implemented by making a fresh copy. It is found in java.util.concurrent package. It is a data structure created to be used in a concurrent environment.



//As the name indicates, CopyOnWriteArrayList creates a Cloned copy of underlying ArrayList, for every update operation at a certain point both will be synchronized automatically, which is taken care of by JVM. Therefore, there is no effect for threads that are performing read operation.
//It is costly to use because for every update operation a cloned copy will be created. Hence, CopyOnWriteArrayList is the best choice if our frequent operation is read operation.
//The underlined data structure is a grow-able array.
//It is a thread-safe version of ArrayList.


//static CopyOnWriteArrayList<String> l
//        = new CopyOnWriteArrayList<String>();