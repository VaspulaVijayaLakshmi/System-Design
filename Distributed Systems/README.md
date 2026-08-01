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


              │
              ▼
         CACHING
              │
              ├─ Cache-Aside
              ├─ Read-Through
              ├─ Write-Through
              ├─ Write-Behind
              ├─ Cache Invalidation
              ├─ TTL
              ├─ Eviction Policies
              ├─ Cache Stampede
              ├─ Request Coalescing
              ├─ Distributed Lock
              └─ Redis Cluster


                     │
                     ▼
              DISTRIBUTED MESSAGING
                     │
                     ├─ Message Queue
                     ├─ Pub/Sub
                     ├─ Kafka
                     ├─ Consumer Groups
                     ├─ Partitions
                     ├─ Replication
                     ├─ Offset Management
                     ├─ Delivery Semantics
                     │    ├─ At-most-once
                     │    ├─ At-least-once
                     │    └─ Exactly-once
                     ├─ Ordering
                     ├─ Retry
                     ├─ Dead Letter Queue
                     └─ Backpressure




                            │
                            ▼
                   DISTRIBUTED SYSTEM
                   FAILURE HANDLING
                            │
                            ├─ Timeouts
                            ├─ Retries
                            ├─ Exponential Backoff
                            ├─ Jitter
                            ├─ Circuit Breaker
                            ├─ Bulkhead
                            ├─ Idempotency
                            └─ Graceful Degradation










