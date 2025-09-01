Design Leetcode : 

VMs: VMs run on physical hardware through a hypervisor (like VMware or Hyper-V).
Each VM includes a full copy of an operating system (OS), the application, necessary binaries, and libraries, 
making them larger in size and slower to start. 

VMs are fully isolated, running an entire OS stack, which adds overhead but provides strong isolation and security.



Containers: Containers, on the other hand, share the host system's kernel and isolate the application processes from each other. 
They include the application and its dependencies (libraries, binaries) but not a full OS, making them lightweight and enabling faster start times. 
Containers offer less isolation than VMs but are more efficient in terms of resource usage and scalability.


<img width="850" height="430" alt="image" src="https://github.com/user-attachments/assets/93f560fe-3bbe-4bfb-b4b6-c0e163a93c82" />
