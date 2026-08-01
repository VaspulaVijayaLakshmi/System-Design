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

                      CACHING
                       │
      ┌────────────────┼─────────────────┐
      │                │                 │
      ▼                ▼                 ▼
 Cache Patterns    Cache Management   Cache Problems
      │                │                 │
      ├─ Cache-Aside   ├─ TTL            ├─ Cache Stampede
      ├─ Read-Through  ├─ Eviction       ├─ Cache Penetration
      ├─ Write-Through ├─ Invalidation   ├─ Cache Breakdown
      └─ Write-Behind  └─ Refresh        └─ Cache Avalanche
                                            │
                                            ├─ Request Coalescing
                                            ├─ Distributed Lock
                                            ├─ Random TTL
                                            └─ Bloom Filter

                       │
                       ▼
                Distributed Cache
                       │
                       ├─ Redis Cluster
                       ├─ Sharding
                       ├─ Replication
                       ├─ Consistent Hashing
                       └─ High Availability


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











