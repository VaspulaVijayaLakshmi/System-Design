Producer Acknowledgments (acks setting) : 



This setting controls how many Kafka brokers must acknowledge a write before it's considered successful.
Kafka responds asynchronously, so the producer doesn’t block unless explicitly waited upon.




What if the ack fails?
The producer gets a TimeoutException, RetriableException, or RecordTooLargeException, etc.
Kafka producer can be configured to retry automatically (retries, retry.backoff.ms).




| **Yes** — Kafka **does support producer-side acknowledgments**      |
| ------------------------------------------------------------------- |
| Use `acks=all` for maximum durability (replication-safe)            |
| Use `acks=1` for a good balance of speed and safety                 |
| Use `acks=0` only if you’re OK losing some messages for low latency |



________




Kafka Acknowledgment Model (Consumer Side) :

No explicit "ack" from the consumer to Kafka.
Instead, Kafka uses consumer offsets to keep track of what messages have been "consumed."


How it works:
Each consumer periodically commits an offset (either automatically or manually).

What happens if a consumer crashes before committing?
Kafka will resend the uncommitted messages when the consumer restarts.

This means Kafka gives at-least-once delivery by default.




__________



Why store offsets in Kafka itself?


Kafka stores consumer offsets in a special internal topic called  ->   __consumer_offsets


✅ Scalable: Multiple consumers and brokers can handle offsets efficiently.

✅ Fault-tolerant: Replicated like other topics — won’t lose offsets if a broker fails.

✅ Consumer-group based: Each group tracks its own position independently.

_________




TOPIC  VS PARTITION :


![image](https://github.com/user-attachments/assets/6ceffdda-85d8-4384-99d8-b15c5bb45cc4)





_____

DIfference between conusmer and COnsumer group


| Term                | **Consumer**                                                                         | **Consumer Group**                                                                              |
| ------------------- | ------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------- |
| **Definition**      | A single application instance that subscribes to Kafka topics and processes messages | A group of one or more consumers that share the same GROUP ID                  
| **Unit of Work**    | Consumes messages **from one or more partitions**                                    | A **logical group** that ensures **each partition is consumed by only one member** of the group |
| **Uniqueness**      | Identified by a unique `client.id`                                                   | Identified by a unique `group.id`                                                               |
| **Message Sharing** | A consumer gets **all messages** from its assigned partitions                        | Messages are **load balanced** across consumers in the group                                    |
| **Parallelism**     | One consumer = one thread/process                                                    | Multiple consumers can run **in parallel**, one per partition                                   |




______


CONSUMER :


Producer --> Kafka Topic (3 partitions)
                     |
                 Consumer A


Consumer A will have to read from all partitions by itself.
No horizontal scaling.


________


CONSUMER GROUP :

               +----------------+
               |    Producer    |
               +--------+-------+
                        |
                        v
            +-----------------------+
            |    Kafka Topic: orders|
            |   (3 Partitions)      |
            +--------+--------+-----+
                     |        |
           +---------+--------+----------+
           |         |        |          |
     Partition 0  Partition 1  Partition 2
           |         |              |
           |         |              |
           A         B              C




Each consumer in the group reads from a unique partition.
No message duplication inside the group.
Scalable and parallel processing.




At-most-one consumer reads from a partition at a time in a group	
Multiple groups can read the same topic independently	
Each group tracks its own offsets	



Adding more consumers than partitions?	Some consumers will be idle





________






KAFKA VS RABBIT MQ



| Feature              | **RabbitMQ**                                           | **Kafka**                                        |
| -------------------- | ------------------------------------------------------ | ------------------------------------------------ |
| **Message Delivery** | Delivered to a consumer and **removed** from the queue | Messages are **retained** and can be re-read     |
| **Ordering**         | Preserved per queue                                    | Preserved per **partition**                      |
| **Consumers**        | Competes for messages (one message per consumer)       | Multiple consumers can read **independently**    |
| **Acks**             | Required for successful processing                     | Offset-based, consumers track their own progress |




__________




How to ensure the messages are not duplicated?

How to make sure we are not losing data packets?

How to retry failed messages?


TECHNIQUES : 


_____

1. Replication : 
Each Kafka topic partition is replicated across multiple brokers.

There is one leader and multiple followers.
If Broker 1 crashes, Kafka promotes one of the followers to be the new leader.

_____

2. Retention Policy
Messages are retained even after they're read (unless deleted).

_____


3. Consumer Offset Management
Consumers track read position using offsets.

Kafka stores this in __consumer_offsets topic.

If a consumer crashes, it can resume from the last committed offset.

____


4.Durable Log on Disk
Kafka writes all data to disk before acknowledging it.

Durable, append-only ordered storage of messages for streaming and replay

Messages are appended to disk in orde

_____


5. Idempotent Producer : 

Idempotent producer in Kafka does NOT generate a UUID per message. Instead, it relies on a combination of producer ID and sequence numbers to achieve idempotence.



When you enable enable.idempotence=true, Kafka assigns your producer a unique Producer ID (PID) when it connects to the broker.

For each partition the producer writes to, it maintains a monotonically increasing sequence number for every message sent.


The broker tracks (Producer ID, Partition, Sequence Number) pairs.
This trio uniquely identifies every message from a producer to a partition. Kafka uses it to detect duplicates if the producer retries.


If a message with the same PID + sequence number is received again (due to retries), the broker deduplicates it and does not write a duplicate to the log.



Benefit - 	Prevents duplicates on retries without extra message overhead


_____







Dead Letter Queue:


What is a Dead Letter Queue (DLQ)?
A DLQ is a special topic where problematic messages are sent if they cannot be processed successfully after retries.

Consumer detects a problematic message:
The message causes processing errors (e.g., data format issues, validation failures).

The consumer retries a configured number of times.

2. On failure after retries:
The consumer publishes the problematic message to a separate Kafka topic (the DLQ topic).

Logs the error or alerts for manual inspection or automated reprocessing.




so what if a reuqest was prcoessed and trasaction was completed but writing to db failed
Now how does he syste recongnise UUID since it not in db




1. Client sends a request with a UUID (e.g., a payment).

2. Server processes the request successfully (e.g., money deducted, service delivered).

3. But the DB write (to persist UUID or result) fails (e.g., crash, network issue).

4. Now, if the client retries... 💥 The server can’t find the UUID in DB to detect a duplicate.





Idempotency Key Cache (Short-Term Memory)
If DB write fails:

Store the UUID in a temporary in-memory cache (Redis, Memcached, etc.) with a TTL.

On retry, check cache to see if this UUID was already processed.





Deduplicating Message Brokers
If you're using message queues (Kafka, SQS, etc.):

Use UUID as the message key or ID.

Brokers (or consumers) keep a log of processed IDs.

If a retry happens, they discard the duplicate.




 Write-Ahead Log (WAL) / Event Log First
Instead of writing to DB first, write the request or outcome to an append-only durable log first:

Think: Kafka, filesystem log, or WAL.

Then process the request.

Then write to DB.

On crash recovery, replay the log and detect duplicates.





