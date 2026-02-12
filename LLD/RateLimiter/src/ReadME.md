Ratelimiter protects our system from abuse of our resources.

Each user cannot infinitely access our resources.
Fair usage of resources.

User Level ; 10 req per minute

if more requests than 10 per minute, then we will block the user for 1 minute.



They're r various rate limiter algorithms, Leaky bucket, such as token bucked, sliding winodw, fixed winodw.



____

Leaky Bucket Algorithm

Bucket has a hole at the bottom.
Water (requests) enter from top.
Water leaks at constant rate.

If bucket is full → new requests are dropped.


---

Token bucket -

You have a bucket.
Tokens are added to the bucket at a fixed rate.
Each request consumes 1 token.
If token available → allow request.
If no token → reject request.

---

Fixed window

Like in 1min user can make 10 req. and need to wait till the next min
Problem is burst at the ends.

like I can make req at 59sec and 1 min will elapse and I can make at the 1sec of next min.

---

Sliding Window

We wil slide the window , so the window requests wil be constant.




FR : 

Protect our system from abuse
Fair share of resources
Limit the number of requests a user can make in a given time frame.


NFR

highly available
Scalable - handle users and requests
Consistent - distributed system, consistent state across nodes
Low Latency - minimal delay in processing requests and enforcing limits
Return appropriate response (e.g., 429 Too Many Requests)


Redis we can store this, so this can be distributed across multiple nodes and we can have a consistent state across nodes. 
Redis also provides atomic operations which can help us to implement the rate limiter efficiently. 
We can use Redis' INCR command to increment the count of requests for a user and set an expiration time for the key 
to reset the count after a certain time frame.



Key - UserId
Value - Request Count
Expiry 



I can implement 

Token bucket and sliding window


Design patterns


Strategy pattern - acceptRequest

Token bucket
Sliding Window


RateLImiter 

capacity - 10
Rate at which bucket needs to be filled - per min -> 10 per minrute -> 10/60 ->
current Tokens

lastFIlledAT













