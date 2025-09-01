#Tools
https://systemdesignschool.io/resource-estimator


# System-Design



1. Scalability: https://lnkd.in/gPGhW-qK
2. Availability: https://lnkd.in/gQk2p4_6
3. CAP Theorem: https://lnkd.in/g_tFqJJb
4. SPOF: https://lnkd.in/gw_uHZWn
5. Consistent Hashing: https://lnkd.in/gR9wFDpz
6. Load Balancers: https://lnkd.in/dzM7VDKq
7. Load Balancing Algorithm: https://lnkd.in/gvxfwEUr
8. Caching: https://lnkd.in/gBSeTstS
9. Caching Strategies: https://lnkd.in/dVk7nZ_Y
10. Cache Eviction Strategies: https://lnkd.in/gQAEXEmq
11. Distributed Caching: https://lnkd.in/gf6pCqdi
12. CDNs: https://lnkd.in/g2zvPhkA
13. Database Types: https://lnkd.in/gDxtZVE2
14. SQL vs NoSQL: https://lnkd.in/gHyC9qWc
15. ACID Transactions: https://lnkd.in/dB3QHiMz
16. Database Indexes: https://lnkd.in/g_-bQWtA
17. Database Sharding: https://lnkd.in/g9mc-d5m
18. Database Scaling: https://lnkd.in/gSUtAwc7
19. APIs: https://lnkd.in/dsbwPZ6N
20. API Gateway: https://lnkd.in/gtyXmvf4
21. WebSockets: https://lnkd.in/gD-TUZep
22. Message Queues: https://lnkd.in/g-jnNGDC
23. Service Discovery: https://lnkd.in/gRj_QeP8
24. Bloom Filters: https://lnkd.in/gfGjCrSZ
25. Rate Limiting Algorithms: https://lnkd.in/gYDxg8XY
26. Idempotency: https://lnkd.in/gDB3AJij
27. Concurrency vs Parallelism: https://lnkd.in/gGZXhjBD
28. Proxy vs Reverse Proxy: https://lnkd.in/gMTtidBq
29. Batch vs Stream Processing: https://lnkd.in/gKtj_qWh
30. Stateful vs Stateless Architecture: https://lnkd.in/gz_ccK-Y


_________


1. Clarify both functional and non-functional requirements before designing.
2. Assume everything can and will fail. Make it fault tolerant.
3. Don't add functionality until it's necessary. Avoid over-engineering.
4. There is no perfect solution. It’s all about tradeoffs.
5. Prefer horizontal scaling over vertical scaling for scalability.
6. Use load balancers to distribute traffic and ensure high availability.
7. Consider using SQL databases for structured data and ACID transactions.
8. Opt for NoSQL databases when dealing with unstructured data.
9. Use database sharding to scale SQL databases horizontally.
10. Use database indexing to optimize read queries.
11. Use rate limiting to prevent system overload and DOS attacks.
12. Use websockets for real-time communication.
13. Employ heartbeats / health checks for failure detection.
14. Consider using a message queue for asynchronous communication.
15. Implement data partitioning and sharding for large datasets.
16. Consider denormalizing databases for read-heavy workloads.
17. Consider using event-driven architecture for decoupled systems.
18. Use CDNs to reduce latency for a global user base.
19. Use write-through cache for write-heavy applications.
20. Use read-through cache for read-heavy applications.
21. Use blob storage to store media files like files, images, videos etc..
22. Implement data replication and redundancy to avoid single point of failures.
23. Implement autoscaling to handle traffic spikes smoothly.
24. Use asynchronous processing to run non-urgent/background tasks.
25. Make operations idempotent where possible to simplify retry logic and error handling.
26. Prefer microservices architecture over monoliths for scalability, modularity, and maintainability.
27. Consider using an API gateway when you have multiple microservices.
28. Use the circuit breaker pattern to prevent cascading failures
29. Design clear and consistent APIs and incorporate security.
30. Consider using a data lake or data warehouse for analytics and reporting.



__________________


#HLD : 

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


__________________


#Books : 

1. Designing Data Intensive Application
2. Amazon : Dynamo DB paper
3. Data Structures  behing DataBases
4. Grokking System Design Interview


Book : https://github.com/VaspulaVijayaLakshmi/System-Design/tree/main/Books
_____________



TradeOffs : https://blog.algomaster.io/p/system-design-top-15-trade-offs

Design Problems and template : https://systemdesignschool.io/primer#master-template


HLD : REVISION BOOK
https://github.com/VaspulaVijayaLakshmi/System-Design/blob/main/Algomasterio_System_Design_Interview_Handbook.pdf


HLD : https://blog.algomaster.io/archive?sort=top
      https://github.com/karanpratapsingh/system-design
      
LLD : https://algomaster.io/learn/lld



KAFKA : https://github.com/VaspulaVijayaLakshmi/System-Design/blob/main/KAFKA/README.md

REDIS : https://github.com/VaspulaVijayaLakshmi/System-Design/blob/main/Why%20is%20Redis%20so%20Fast%20and%20Efficient%3F

GRAPHQL : https://github.com/VaspulaVijayaLakshmi/System-Design/blob/main/GraphQL.md



_________________________


SHA → Secure Hash Algorithm
MD5 → Message Digest 5

Both are hashing algorithms, but:

-> MD5 is older, produces a 128-bit hash, and is considered broken (collisions possible).

-> SHA is a family of algorithms (SHA-1, SHA-2, SHA-3, etc.), more secure, widely used in digital signatures, TLS, blockchain, etc.


____________________________




Locks : 

Distributed lock with a TTL (Time To Live) using a distributed system like Redis. 
Redis is an in-memory data store that supports distributed locks and is well-suited for high-concurrency environments. 

It offers high availability and can be used to implement a distributed lock mechanism for the ticket booking process. 

Here is how it would work:

When a user selects a ticket, acquire a lock in Redis using a unique identifier (e.g., ticket ID) with a predefined TTL (Time To Live). This TTL acts as an automatic expiration time for the lock.

If the user completes the purchase, the ticket's status in the database is updated to "Booked", and the lock in Redis is manually released by the application after the TTL.

If the TTL expires (indicating the user did not complete the purchase in time), Redis automatically releases the lock. This ensures that the ticket becomes available for booking by other users without any additional intervention.


___________________________





https://www.hellointerview.com/learn/system-design/deep-dives/redis


