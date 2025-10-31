

# HLD : 

- Video streaming services like Netflix: https://lnkd.in/gnHSyCj8 
- Autocomplete feature of Google: https://lnkd.in/g3VFcaYN
- Proximity service like Uber: https://lnkd.in/grtPbr6k
- Hotel booking services like Airbnb: https://lnkd.in/gWjrGwCM
- File sharing service like Dropbox: https://lnkd.in/gnSQ6rAd
- Web crawler: https://lnkd.in/gTkfCH8U
- Social media apps like Twitter: https://lnkd.in/guParNhY
- Messaging app like WhatsApp: https://lnkd.in/g5zJa_4W
- Online document editor like Google Docs: https://lnkd.in/gBvztEqV
- URL shortener or TinyURL: https://lnkd.in/gJPWZsX3
- Notifcation Service




________________________




# Design Leetcode : 

VMs: VMs run on physical hardware through a hypervisor (like VMware or Hyper-V).
Each VM includes a full copy of an operating system (OS), the application, necessary binaries, and libraries, 
making them larger in size and slower to start. 

VMs are fully isolated, running an entire OS stack, which adds overhead but provides strong isolation and security.



Containers: Containers, on the other hand, share the host system's kernel and isolate the application processes from each other. 
They include the application and its dependencies (libraries, binaries) but not a full OS, making them lightweight and enabling faster start times. 
Containers offer less isolation than VMs but are more efficient in terms of resource usage and scalability.


<img width="850" height="430" alt="image" src="https://github.com/user-attachments/assets/93f560fe-3bbe-4bfb-b4b6-c0e163a93c82" />


## SandBoxed Environment:

A sandboxed environment = a restricted, isolated execution environment where code or processes
run with limited access to the host system.

-> Isolation : 

Code runs separately from the rest of the system.
It can’t directly access files, memory, or network beyond what’s allowed.

-> Restricted permissions:

Only a narrow set of system calls, APIs, or resources are available.
Prevents malicious or buggy code from causing harm.

-> Temporary/Disposable

The environment can be reset/erased after execution.
Keeps things clean and safe.


## Examples :

-> Web browsers: JavaScript runs in a sandbox → can’t touch your local files (unless you allow).

-> Docker containers: Provide sandboxed runtime for apps.

-> Online coding judges (like HackerRank/LeetCode): Run your code in a sandbox → so you can’t access the server.

-> Mobile apps (iOS/Android): Each app runs in its own sandbox → can’t access other apps’ data.





# Redis

Sorted Sets:


Like a Set → all elements are unique (no duplicates).
But every element has an associated score (a floating-point number).
Redis keeps elements ordered by score automatically.





HMAC
Nonce and Idempotent Keys

| Concept             | Purpose                                      | Who Generates It                  | How It’s Used                                    |
| ------------------- | -------------------------------------------- | --------------------------------- | ------------------------------------------------ |
| **Nonce**           | Prevents replay attacks                      | Sender (and verified by receiver) | Stored temporarily; reject duplicates            |
| **Idempotency Key** | Prevents duplicate processing due to retries | Client                            | Stored longer; return same response for same key |
| **HMAC**            | Verifies authenticity/integrity              | Sender                            | Validates message hasn’t been tampered           |

