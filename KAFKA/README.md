Kafka Acknowledgment Model (Consumer Side)

No explicit "ack" from the consumer to Kafka.

Instead, Kafka uses consumer offsets to keep track of what messages have been "consumed."


How it works:
Each consumer periodically commits an offset (either automatically or manually).

What happens if a consumer crashes before committing?
Kafka will resend the uncommitted messages when the consumer restarts.

This means Kafka gives at-least-once delivery by default.




Kafka stores consumer offsets in a special internal topic called:

->  __consumer_offsets




Why store offsets in Kafka itself?


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

Producer --> Kafka Topic (3 partitions)
                      |
        Consumer Group G1
          ├── Consumer A (partition 0)
          ├── Consumer B (partition 1)
          └── Consumer C (partition 2)



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




How to ensure the messages ae not duplicated




How to make sure we are not losing data packets


how to retry failed msgs



Dead Letter Queue










