

LRU

Cache is of limited size

So once the size is full , we need to evict the least recently used item
so we need to keep track of the item used

also if the element is already in the cache we need to move it from lru to most recently used
if its not there it will be most recently used 


so what to use...

HashMap to store double linkedlist nodes
DLL to keep track of nodes in order of usage

when an element is accessed we move it to the head 
when cache is full we need to remove the tail and add the new element to the head.


When an element is not present -> add to hashmap + head of DLL
When an elemnt is present -> move to front DLL
When cache is full -> remove tail of DLL + remove from hashmap









