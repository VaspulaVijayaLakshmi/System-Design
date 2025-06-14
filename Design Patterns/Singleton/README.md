Notes :

Checks if an instance already exists (instance == null).

If not, it creates a new instance.

If an instance already exists, it skips the creation step.

This implementation is not thread-safe. If multiple threads call getInstance() simultaneously when instance is null, it's possible to create multiple instances.

This is achieved by making the getInstance() method synchronized ensuring only one thread can execute this method at a time.

When a thread enters the synchronized method, it acquires a lock on the class object. Other threads must wait until the method is executed.


![image](https://github.com/user-attachments/assets/02d7d0cb-83dd-44a2-bc43-f02d1104182b)

