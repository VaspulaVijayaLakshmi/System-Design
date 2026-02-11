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


___________________


API Gateway: The entry point for client requests (e.g., promotional alerts or OTPs). It handles authentication, rate limiting, and request validation.

Notification Service: Receives requests from the Gateway. It performs basic processing and sends messages to the message queue. It interacts with the User Preference Service to determine which channels (Email, SMS, Push) a user has opted into.

Message Queue (Kafka/SQS): Decouples the notification service from the delivery workers. It allows for priority-based processing (e.g., OTPs in a high-priority queue vs. newsletters in a low-priority queue).

Notification Workers: These microservices consume messages from the queue. Each worker is dedicated to a specific channel (e.g., SMS worker, Push worker) to allow independent scaling.

Third-Party Providers: Workers call external APIs like Twilio (SMS), SendGrid (Email), or Firebase Cloud Messaging (Push).

Retry & Dead Letter Queue (DLQ): If a delivery fails, the system retries with exponential backoff. Persistent failures are moved to a DLQ for manual inspection.


_______________



The LLD focuses on class structures, design patterns, and internal logic to make the system maintainable.

-> Factory Pattern: Used to create the appropriate NotificationSender (SMS, Email, or Push) based on the channel type. This makes the system easily extendable to new channels like WhatsApp.
-> Strategy Pattern: Each delivery method implements a common interface (e.g., send(Notification n)). This decouples the core logic from specific provider implementations.


Core Entities:

-> User: Unique ID and contact info.
-> Notification: Payload containing message, subject, and priority.
-> UserPreference: Stores opt-in/opt-out settings for different notification types.
-> Idempotency: To prevent duplicate notifications (e.g., during a retry), each notification should have a unique requestID stored in a distributed cache like Redis.

_____________


