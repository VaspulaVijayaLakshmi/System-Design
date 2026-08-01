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
├── DATA & STORAGE
│   ├── Replication
│   ├── Sharding
│   ├── Caching
│   └── Consistent Hashing
│
├── COORDINATION
│   ├── Consensus
│   ├── Quorum
│   └── Leader Election
│
└── ARCHITECTURE
    ├── CQRS
    │   └── Read / Write Separation
    │
    └── Outbox
        └── Reliable Event Publishing
