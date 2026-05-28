| Aspect             | Optimistic Locking   | Pessimistic Locking           |
| ------------------ | -------------------- | ----------------------------- |
| Assumption         | Conflicts are rare   | Conflicts are common          |
| Strategy           | No lock initially    | Lock immediately              |
| Conflict Detection | During commit/update | Before modification           |
| Performance        | Higher concurrency   | Lower concurrency             |
| Waiting            | No waiting usually   | Transactions may wait         |
| Failure Handling   | Retry transaction    | Block others                  |
| Best For           | Read-heavy systems   | High-conflict systems         |
| Common Mechanism   | Version column       | DB row locks                  |
| Scalability        | Better               | Poorer under heavy contention |




_______________


| Use Case                 | Why Optimistic?                   | Why Pessimistic?                       |
| ------------------------ | --------------------------------- | -------------------------------------- |
| E-commerce inventory     | Conflicts relatively low normally | During flash sales/high contention     |
| User profile updates     | Rare simultaneous edits           | Not needed usually                     |
| Social media likes/views | Small inconsistencies acceptable  | Overkill                               |
| Banking transactions     | Retry costly/dangerous            | Strong correctness needed              |
| Ticket booking           | Double booking unacceptable       | Prevents concurrent booking            |
| Seat reservation         | Rarely okay to retry              | Must lock immediately                  |
| Analytics dashboards     | Read-heavy, low conflict          | Unnecessary locking                    |
| Collaborative editing    | Many reads, occasional conflicts  | Locks hurt UX                          |
| Wallet balance updates   | Risk of lost updates              | Safer with locks                       |
| Order processing         | Sometimes optimistic enough       | Use pessimistic for critical inventory |


_______________________



# Concurrency Control

Concurrency control ensures multiple transactions can run simultaneously while maintaining data consistency and correctness.

---

# Components of Concurrency Control

```text id="szt0v8"
Concurrency Control
        │
        ├── Isolation Levels
        │       ├── Read Committed
        │       ├── Repeatable Read
        │       └── Serializable
        │
        ├── Pessimistic Locking
        │       └── Uses locks immediately
        │
        ├── Optimistic Locking
        │       └── Uses version checking
        │
        └── MVCC
                └── Keeps multiple row versions internally
```

---

# 1. Isolation Levels

Isolation levels define:

```text id="5gdrgm"
"What consistency guarantees should transactions have?"
```

They control what kind of anomalies are allowed.

---

## Read Committed

* Each query sees only committed data
* New queries can see newer committed values

Possible issue:

* Non-repeatable reads

---

## Repeatable Read

* Transaction sees same snapshot throughout execution
* Repeated reads return same result

Possible issue:

* Phantom reads (depending on DB)

---

## Serializable

* Highest isolation level
* Transactions behave as if executed one-by-one sequentially

Most correct but slowest.

---

# 2. Pessimistic Locking

Assumes:

```text id="0ok2na"
conflicts WILL happen
```

So rows are locked immediately.

Example:

```sql id="jlwm70"
SELECT * FROM account
WHERE id=1
FOR UPDATE;
```

Other transactions must wait until lock released.

---

## Best For

* Banking
* Ticket booking
* Flash sales
* Wallet systems

---

# 3. Optimistic Locking

Assumes:

```text id="jlwm71"
conflicts are rare
```

No lock initially.

Instead:

* read row
* modify
* during update check if row changed

Usually implemented using:

```text id="jlwm72"
version column
```

Example:

```sql id="jlwm73"
UPDATE account
SET balance=200,
    version=6
WHERE id=1
  AND version=5;
```

If version mismatch:

* conflict detected
* retry transaction

---

## Best For

* Social media systems
* User profile updates
* Collaborative editing
* Analytics systems

---

# 4. MVCC (Multi Version Concurrency Control)

MVCC is an internal DB mechanism.

Database keeps multiple versions of rows instead of overwriting immediately.

Conceptually:

| value | created_by | deleted_by |
| ----- | ---------- | ---------- |
| 100   | TX1        | TX2        |
| 200   | TX2        | null       |

This allows:

* readers and writers to work concurrently
* snapshot-based reads
* fewer locks

Used internally by:

* PostgreSQL
* MySQL InnoDB

---

# Overall Mapping

| Component           | Purpose                                     |
| ------------------- | ------------------------------------------- |
| Isolation Levels    | Define required consistency                 |
| Pessimistic Locking | Prevent conflicts using locks               |
| Optimistic Locking  | Detect conflicts during commit              |
| MVCC                | Internal mechanism for snapshots/versioning |

