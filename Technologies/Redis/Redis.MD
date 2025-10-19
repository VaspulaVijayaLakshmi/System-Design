https://www.hellointerview.com/learn/system-design/deep-dives/redis


Redis can run as a single node, with a high availability (HA) replica, or as a cluster.


When operating as a cluster, Redis clients cache a set of "hash slots" which map keys to a specific node.

Redis does not use consistent hashing

Fixed "HASH SLOTS"




how redis handles expiration? and ttl of keys does it scan the entire table each time?

1. Lazy Expiration

Redis only checks a key’s TTL when you access it.


If it’s expired → Redis deletes it on the spot and returns “nil”.
If it’s not expired → it’s returned normally.

 Advantage: Zero overhead unless key is touched.
 Disadvantage: Expired keys can sit in memory unused until someone accesses them.

____


2. Active Expiration (background process)

Redis also runs a background task every 100ms (configurable) to actively clean up expired keys.

It does NOT scan the entire database.

Instead, it samples a small random subset of keys with expiration times (from the “expires dictionary”).

It deletes the expired ones.

If too many expired keys are found (like >25%), Redis repeats the process immediately (to catch up).

So over time, most expired keys get cleaned up automatically — even if nobody accesses them.

 Advantage: Keeps memory clean over time.
 No full DB scan ever!



Redis uses a hybrid of lazy + active expiration — it never scans the whole table, just random samples and access-time checks.





_________


how master and replica stay consistent during expiration will both run the random sampling jobs independenlty?


Master runs expiration normally

The master node runs the active expiration loop (sampling expired keys).

It also lazily expires keys when clients access them.

Whenever a key expires:

The master deletes it locally, and

It propagates a deletion command to all replicas (as if a client executed DEL key).

So replicas just replay that command — staying in sync.



Replicas never do random expiry themselves

Replicas do not run the active expiration job.

They don’t delete keys even if they’re technically expired in their local memory.

They just wait for the master’s instruction.

This means replicas might temporarily have expired keys sitting around — but those keys are invisible to clients anyway because the replica won’t serve them if they’re expired (checked on read).
