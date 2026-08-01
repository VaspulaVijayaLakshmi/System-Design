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
