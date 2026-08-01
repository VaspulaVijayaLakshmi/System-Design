# Distributed Systems – Key Concepts

```text
                    DISTRIBUTED SYSTEMS
                           |
        +------------------+------------------+
        |                  |                  |
        ↓                  ↓                  ↓
   DATA & STORAGE      COORDINATION       ARCHITECTURE
        |                  |                  |
        |                  |                  |
   ┌────┴────┐        ┌────┴────┐       ┌────┴─────┐
   |         |        |         |       |          |
   ↓         ↓        ↓         ↓       ↓          ↓
Replication  Sharding  Consensus  Quorum  CQRS   Outbox
   |            |          |         |      |
   ↓            ↓          ↓         ↓      ↓
Caching    Consistent    Leader    Majority  Read/Write
           Hashing       Election  Agreement Separation




                 DISTRIBUTED SYSTEMS
                        │
                        ▼
                 COORDINATION
                        │
          ┌─────────────┼─────────────┐
          │             │             │
          ▼             ▼             ▼
      Consensus       Quorum      Distributed
                                      Lock
          │                           │
          ▼                           ▼
   Leader Election             Cache Stampede
                                Prevention




                         DISTRIBUTED SYSTEMS
                                  │
       ┌──────────────────────────┼──────────────────────────┐
       │                          │                          │
       ▼                          ▼                          ▼
 DATA & STORAGE              COORDINATION              ARCHITECTURE
       │                          │                          │
       ├─ Replication             ├─ Consensus              ├─ CQRS
       ├─ Sharding                ├─ Quorum                  ├─ Outbox
       ├─ Consistent Hashing      ├─ Leader Election         ├─ Materialized Views
       ├─ Partitioning            ├─ Distributed Locks       ├─ Denormalization
       ├─ Leader-Follower         └─ Coordination Services   └─ Eventual Consistency
       ├─ CAP Theorem
       └─ Consistency Models


---



# Distributed Messaging

```text
                    DISTRIBUTED MESSAGING
                            │
        ┌───────────────────┼───────────────────┐
        │                   │                   │
   Messaging Models     Kafka Concepts     Reliability
        │                   │                   │
   ├── Message Queue    ├── Topics         ├── Retry
   ├── Pub/Sub          ├── Partitions     ├── Dead Letter Queue
   └── Event Streaming  ├── Consumer Groups├── Idempotent Consumers
                         ├── Replication    ├── Delivery Semantics
                         ├── Leaders/Followers │   ├── At-most-once
                         ├── Offset Management │   ├── At-least-once
                         └── Rebalancing      │   └── Exactly-once
                                              ├── Ordering
                                              └── Backpressure
```

---

# 1. Messaging Models

| Concept | Purpose |
|---------|---------|
| **Message Queue (MQ)** | One producer, one consumer processes each message. |
| **Publish/Subscribe (Pub/Sub)** | One producer broadcasts events to multiple independent consumers. |
| **Event Streaming** | Persist events in an ordered log for replay and long-term processing (Kafka). |

---

# 2. Kafka Concepts

| Concept | Purpose |
|---------|---------|
| **Topic** | Logical category where events are stored. |
| **Partition** | Splits a topic for parallel processing and scalability. |
| **Consumer Group** | Multiple consumers cooperate to process partitions. |
| **Replication** | Replicate partitions for fault tolerance. |
| **Leader & Followers** | Leader serves reads/writes; followers replicate data. |
| **Offset Management** | Tracks which messages a consumer has processed. |
| **Rebalancing** | Redistributes partitions when consumers join or leave. |

---

# 3. Reliability

| Concept | Purpose |
|---------|---------|
| **Retry** | Retry processing transient failures. |
| **Dead Letter Queue (DLQ)** | Store messages that repeatedly fail processing. |
| **Idempotent Consumers** | Prevent duplicate processing during retries. |
| **Delivery Semantics** | Define delivery guarantees (at-most-once, at-least-once, exactly-once). |
| **Ordering** | Preserve event order, typically within a partition. |
| **Backpressure** | Slow producers or consumers to prevent overload. |

---



# Kafka Delivery Semantics

| Delivery Semantics | Kafka Configuration / Pattern | One-line Explanation |
|--------------------|-------------------------------|----------------------|
| **At-most-once** | Commit offset **before** processing (`enable.auto.commit=true` or early manual commit) | Messages are **never reprocessed**, but may be **lost** if the consumer crashes before processing. |
| **At-least-once** | Process message first, then commit offset only after successful processing | Messages are **never lost**, but may be **processed multiple times** if a crash occurs before committing the offset. |
| **Exactly-once** | Idempotent producer + Kafka transactions + atomic offset commits (or Kafka Streams EOS) | Each message is **processed exactly once**, with **no duplicates and no message loss**, even during failures. |



# Interview Tip

When asked **"Which delivery semantic do you usually use?"**

- **At-most-once** → Rare, when losing a few messages is acceptable.
- **At-least-once** → Most common in backend systems. Combine with **idempotent consumers** to safely handle retries.
- **Exactly-once** → Use only when duplicate processing is unacceptable and the extra complexity is justified.



---

# Typical Kafka Flow

```text
Producer
    │
    ▼
Topic
    │
    ▼
Partition
    │
    ▼
Leader Broker
    │
    ├────────► Follower Replica
    │
    ▼
Consumer Group
    │
    ▼
Consumer
    │
    ▼
Commit Offset
```

---





              # Distributed Systems - Failure Handling

```text
                    DISTRIBUTED SYSTEMS
                    FAILURE HANDLING
                            │
        ┌───────────────────┴───────────────────┐
        │                                       │
   Failure Detection                     Failure Recovery
        │                                       │
   ├── Timeouts                           ├── Retries
   ├── Health Checks                      ├── Exponential Backoff
   └── Heartbeats                         ├── Jitter
                                          └── Idempotency
                                                   │
                                                   ▼
                                   Prevent duplicate side effects

        ┌───────────────────┴───────────────────┐
        │                                       │
   Failure Isolation                    User Experience
        │                                       │
   ├── Circuit Breaker                   ├── Graceful Degradation
   ├── Bulkhead                          ├── Fallbacks
   ├── Load Shedding                     └── Cached Responses
   └── Rate Limiting
```

---

# 1. Failure Detection

These mechanisms help identify when a service or node is unhealthy.

| Concept | Purpose |
|---------|---------|
| **Timeouts** | Detect requests taking too long and fail fast. |
| **Health Checks** | Periodically verify whether a service is alive and ready to serve traffic. |
| **Heartbeats** | Continuous signals exchanged between nodes to detect node failures. |

---

# 2. Failure Recovery

These techniques help recover from temporary failures.

| Concept | Purpose |
|---------|---------|
| **Retries** | Retry operations that fail due to transient issues. |
| **Exponential Backoff** | Increase delay between retries to avoid overwhelming the failing service. |
| **Jitter** | Randomize retry intervals to prevent synchronized retry storms. |
| **Idempotency** | Ensure repeated requests have the same effect as a single request, making retries safe. |

---

# 3. Failure Isolation

Prevent one failing component from impacting the rest of the system.

| Concept | Purpose |
|---------|---------|
| **Circuit Breaker** | Stop sending requests to an unhealthy dependency until it recovers. |
| **Bulkhead** | Isolate resources (threads, pools, connections) so one service cannot exhaust them all. |
| **Load Shedding** | Reject excess traffic during overload to protect the system. |
| **Rate Limiting** | Restrict request rates per user/client to prevent abuse and overload. |

---

# 4. User Experience

Keep the application usable even during failures.

| Concept | Purpose |
|---------|---------|
| **Graceful Degradation** | Continue serving core functionality while disabling non-critical features. |
| **Fallbacks** | Return alternate responses such as defaults or stale data when dependencies fail. |
| **Cached Responses** | Serve cached data instead of failing requests when downstream services are unavailable. |




___


# Caching

```text

                           CACHING
                              │
        ┌─────────────────────┼─────────────────────┐
        │                     │                     │
   Cache Patterns       Cache Management      Cache Reliability
        │                     │                     │
   ├── Cache-Aside      ├── TTL              ├── Cache Stampede
   ├── Read-Through     ├── Invalidation     ├── Request Coalescing
   ├── Write-Through    ├── Eviction         ├── Distributed Lock
   └── Write-Behind     └── Warming          └── Hot Keys
                              │
                              ▼
                     Cache Consistency
                              │
                     ├── Stale Data
                     ├── Refresh Ahead
                     └── Versioning





                              │
                              ▼
                     Distributed Caching
                              │
                     ├── Redis Cluster
                     ├── Sharding
                     ├── Replication
                     ├── Consistent Hashing
                     └── High Availability
```

---

# 1. Cache Patterns

These define **how the application interacts with the cache**.

| Pattern |
|---------|
| **Cache-Aside (Lazy Loading)** 
| **Read-Through** 
| **Write-Through** 
| **Write-Behind (Write-Back)** 

---

# 2. Cache Management

Controls **how data is stored and expires**.

| Concept | Purpose |
|---------|---------|
| **TTL (Time-To-Live)** | Automatically expire cached entries after a configured duration. |
| **Cache Invalidation** | Remove or update stale cache entries after underlying data changes. |
| **Eviction Policies** | Decide which entries to remove when the cache is full (LRU, LFU, FIFO, etc.). |
| **Cache Warming** | Preload frequently accessed data before traffic arrives to reduce cold starts. |

---

# 3. Cache Reliability

Protects the cache during high traffic and failures.

| Concept | Purpose |
|---------|---------|
| **Cache Stampede** | Many requests hit the database simultaneously after a cache miss or expiry. |
| **Request Coalescing** | Ensure only one request fetches missing data while others wait for the result. |
| **Distributed Lock** | Coordinate cache population across multiple application instances. |
| **Hot Keys** | Prevent a single popular key from overwhelming the cache or backend. |

---

# 4. Cache Consistency

Ensures cached data remains reasonably fresh.

| Concept | Purpose |
|---------|---------|
| **Stale Data** | Data in the cache differs from the database due to delayed updates or expiration. |
| **Refresh Ahead** | Refresh popular cache entries before they expire. |
| **Versioning** | Use version numbers or timestamps to avoid serving outdated values. |

---

# 5. Distributed Caching

Scale the cache across multiple nodes.

| Concept | Purpose |
|---------|---------|
| **Redis Cluster** | Distribute data across multiple Redis nodes. |
| **Sharding** | Split keys across multiple cache servers. |
| **Replication** | Maintain replica nodes for fault tolerance. |
| **Consistent Hashing** | Minimize key movement when nodes are added or removed. |
| **High Availability** | Ensure cache remains available despite node failures (Sentinel, Cluster). |

---

# Cache Access Patterns

## Cache-Aside (Lazy Loading)

```text
# Cache-Aside Write Flow (Update)

```text
Application
      │
      ▼
Update Database
      │
      ▼
Delete Cache Entry
      │
      ▼
Return Success

        Next Read
            │
            ▼
        Cache Miss
            │
            ▼
       Read Database
            │
            ▼
     Populate Cache
            │
            ▼
        Return Data
```

---

## What if cache deletion fails?

```text
Application
      │
      ▼
Update Database ✅
      │
      ▼
Delete Cache ❌
```

Now:

- Cache still contains the **old value**
- Users may read stale data
- Eventually, the cache entry expires because of **TTL**
- The next cache miss reloads fresh data from the database

This is why **TTL acts as a safety net**, limiting how long stale data can persist.



## Why delete instead of updating the cache?

If the update fails, cache has no way of knowing value updated. If we delete ,
The next read automatically loads the latest value from the database and repopulates the cache.

Benefits:

- Simpler implementation
- Avoids keeping database and cache updates perfectly synchronized
- Works well when writes are much less frequent than reads
        
```

---

## Write-Through

```text
Application
      │
      ▼
   Write Cache
      │
      ▼
Write Database
```

---

## Write-Behind

```text
Application
      │
      ▼
   Write Cache
      │
      ▼
 Return Immediately
      │
      ▼
Background Worker
      │
      ▼
Database
```

---









