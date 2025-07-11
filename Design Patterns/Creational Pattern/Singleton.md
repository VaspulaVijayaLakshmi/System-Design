
Notes :

Checks if an instance already exists (instance == null).

If not, it creates a new instance.

If an instance already exists, it skips the creation step.

This implementation is not thread-safe. If multiple threads call getInstance() simultaneously when instance is null, it's possible to create multiple instances.

This is achieved by making the getInstance() method synchronized ensuring only one thread can execute this method at a time.

When a thread enters the synchronized method, it acquires a lock on the class object. Other threads must wait until the method is executed.

___________

Static methods can’t directly access non-static variables
Because they don’t belong to any object — and non-static variables do.


To implement the singleton pattern, we must prevent external objects from creating instances of the singleton class. Only the singleton class should be permitted to create its own objects.

In Java, one of the ways to implement Singleton is by making the constructor private and providing a static method for external objects to access it.


__________

![image](https://github.com/user-attachments/assets/6e8207a1-8db8-4b35-936d-3eb7c31f5303)
