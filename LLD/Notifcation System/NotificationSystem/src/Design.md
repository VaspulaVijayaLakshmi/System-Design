
Design a Notification System like:

Amazon / Flipkart order notifications
OTP system (login / payment)
Alerts (email, SMS, push)



One app -> different types of notifications


ENUMS: 

Notifications priority - High, Medium, Low

Notification Type - Order Placed, Order Delivered, Order Cancelled, Payment Sucess, Payment Failed

Notification channels - Email, SMS, Push


Classes 

Notifcation : notificaton tyoe, priority, created, 

User -> User name, email, phno, User preferences - channels

User preference - globalOptout, 
                  HashMap -> <Notification TYpe -> List<CHannels>>

               subscribe - channel type -> list of channel , put in the map
               cansend -> check



Notification Service ->
           
    - sendNotification -> User , Notification params
        -> check user preference
        -> if global optout -> return
        -> if channel optout -> return
        -> else send notification to the channels

Send to different services -> factory pattern -> Email Service, SMS service, Push Notifcations

Run a loop : 
            Interface -> Email, SMS, Push -> for channel in channel -> send notifcation















