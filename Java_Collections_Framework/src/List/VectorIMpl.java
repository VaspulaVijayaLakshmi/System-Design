package List;

import java.util.List;
import java.util.Vector;

public class VectorIMpl {

    //            VECTOR
    List<String> vector = new Vector<>();
            vector.add("Red");
            vector.add("Blue");

//     Thread-safe: All methods are synchronized for safe multi-threaded access.

//When a Vector is created using the default constructor, it is initialized with a default capacity of 10. This means it can hold up to 10 elements before needing to grow in size. If the number of elements exceeds the current capacity, the Vector automatically increases its capacity.


//    Vector: synchronized → thread-safe, but slower

//    ArrayList: not synchronized → faster, not thread-safe

//    When a Vector is created using the default constructor, it is initialized with a default capacity of 10.
//    This means it can hold up to 10 elements before needing to grow in size. If the number of elements exceeds the current capacity, the Vector automatically increases its capacity.



//    Both Vector and ArrayList are backed by a dynamic array
//    Both have a capacity (internal array size) and grow automatically
//    You can add more than the initial capacity; resizing happens under the hood


//    Mehtods

//    add, remove, get, set, size, isEmpty, clear, contains, indexOf, lastIndexOf

}
