Design Notification System which should allow users to send and receive notifications through various channels. The goal is to design an efficient and modular class hierarchy that facilitates the sending and receiving of notifications while adhering to object-oriented design principles.

Requirements:
Users: The system should support users, each identified by a unique user ID. Users can subscribe to different types of notifications and manage their notification preferences.


Notification Channels: The system should support multiple notification channels, such as email, SMS, push notifications, and in-app notifications. Each channel has its own delivery mechanism and requirements.

Notification Types: Users can subscribe to different types of notifications, such as new messages, friend requests, system alerts, or custom events. Each notification type may have specific content and delivery requirements.


Bonus Requirements:

Personalization: Notifications may need to be personalized with user-specific information, such as the user's name or specific details related to the notification type.
Opt-out and Preferences: Users should have the ability to opt out of specific notification types or unsubscribe from the notification service altogether. They should be able to manage their notification preferences, such as frequency or delivery channels.
Design and implement the class structure that satisfies the above requirements. Consider the following aspects:

Identify the classes and interfaces required for the notification system.
Define the relationships between the classes and their responsibilities.
Incorporate appropriate encapsulation, inheritance, and polymorphism principles.
Ensure the classes adhere to SOLID principles and promote loose coupling and high cohesion.
Consider extensibility and modularity to accommodate future changes or additions to the notification system.
Your design should focus on class structure and organization while promoting code reusability and maintainability. It should provide a clear and intuitive way to handle user subscriptions, notification creation, and delivery across different channels.




Design enterprise level system architecture to support email, SMS, Chat and other public social app integrations using API:

Email
SMS/OTP
Push notifications (Mobile and Web browser)
Chat – Whatsapp/Telegram



FR : 

Send notifications
Prioritize notifications
Send notifications based on customer’s saved preferences
Single/simple and bulk notification messages
Analytics use cases for various notifications
Reporting of notification messages


NFR : 

High performance
high avaivality
Scalable
LOw latency


Extendable/ Pluggable to different vendors and systems

________

Components:


Notifcation Service - single/BULK

Validation Service

Scheduling Service

Preference Service

Priotisation Service


__________

QUEUES:

EVENT PRIORITY QUEUE -> High
                        Medium
                         Low



DB : Notifcation DB - Leader , Follower


_____________


ARCHITECTURE DIAGRAM :          


                                                                                    User profile Servince+
                             Notifcaton DB                                          Preference Service
                               |

                            Validation Service     
Notification Service   ->   Scheduling Service        ->  EVENT PRIORITY QUEUE  ->   OutBound Handler -> 
                                                           HIGH, MEDIUM, LOW
                            Priotisation Service


Template Service -> 



Bulk Notification Service -> Validation Service -> Scheduling Service -> EVENT PRIORITY QUEUE -> OutBound Handler -> outbound -> chNNELS

                                  |

                               Notification DB

                                  |

                              Analytics Service

___________



-> Notification clients:

These clients will request for single and bulk messages using API calls.
These clients will send notification messages to simple and bulk notification services:

Bulk Notification clients: These clients send bulk notification(s).
Simple Notification clients: These clients send single notification(s).


-> Template Service - This service manages all ready-to use templates for OTP, SMS, Email,chat and other push notification
messages. It also provides REST APIs to create, update, delete and manage templates.


-> Notifcation Service - exposes APIS -> enturyt services -> for clients to send messages 

This service will manage notification messages. It wills persist sent messages to databases and maintain activity log. Same message can be resent using APIs of these services. 
It will provide APIs to add/update/delete and view old and new messages



-> User Profile Service:
This service will provide various features including managing users profile and their preferences . 
It will also provide feature to unsubscribe for notifications and also notification receiving frequency etc. 
Notification Service will be dependent on this service.


-> Scheduling Service:
This service will provide APIs to schedule notifications like immediate or any given time.



->Validation & Prioritization:
This service solely responsible for validating notification messages against business rules and expected format.

It will also prioritize notification based on high, medium and low priorities. OTP notification messages have higher priority with 
a timebound expiry time, they will always be sent in higher priority. 

Notification Handler Service will consume messages and process and send based on the same priorities from reading in three 
different queues high, medium and low. Another use case of bulk messages can be send using
low priority during off hours. Application notifications during transactions could be sent to medium priority like email etc.
Business will decide priority based on criticality of the notifications.



-
-> EVENT PRIORITY QUEUE:

It will persist all notification messages with their delivery time, status etc. It will have a cluster of databases 
with a leader which will be used to perform 
all write operations and read will be on read replica/followers. It should be No-SQL database.

Event Priority Queues (Event Hub):
It will provide event hub service which will consume messages from notification services in high, medium and low topics. It sends processed and validated messages to Notification Handler Service which internally uses Notification Preferences Service to check users personal preferences.

It will have these three topics, which will be used to consume/send messages based on business priority:

High
Medium
Low


->Notification Handler Service:
This service will consume notification messages from Event QUEUE by polling event priority queues based on their priority.
High precedence will be given to “High” queue and so on so forth. Finally It will send notification 
messages to message specific ADAPTERS LIKE -> Email Adapter, SMS Adapter, Chat Adapter etc. These adapters will be responsible for sending messages to respective channels.
