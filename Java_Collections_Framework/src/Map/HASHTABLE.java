package Map;

public class HASHTABLE {
}

//Hashtable: every method is synchronized
//→ single lock → high contention
//
//HashMap: no locking at all
//
//Use ConcurrentHashMap instead of Hashtable
//
//
//
//        |    Feature         | Hashtable     | HashMap    |
//        | --------------- | ------------- | ---------- |
//        | Thread-safe     | ✅ Yes         | ❌ No       |
//        | Synchronization | Method-level  | None       |
//        | Performance     | Slower        | Faster     |

