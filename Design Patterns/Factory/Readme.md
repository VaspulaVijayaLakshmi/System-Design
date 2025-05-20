Notes : 


A Supplier interface has a single abstract method:
Java

T get();
This method returns a value of type T, which is the generic type parameter of the Supplier interface.
Each time the get() method is called, it can return a new or distinct value, but it is not required to do so.



Here's how Supplier can be used with a lambda expression:
Java

Supplier<String> messageSupplier = () -> "Hello, World!";
String message = messageSupplier.get(); // message will be "Hello, World!"


eg:

  Supplier for a random number
        Supplier<Double> randomNumberSupplier = () -> Math.random();
        System.out.println("Random number: " + randomNumberSupplier.get());

  Supplier for a greeting message
        Supplier<String> greetingSupplier = () -> "Hello, there!";
        System.out.println("Greeting: " + greetingSupplier.get());



___________________________________________________________________________

// Define the Notification interface
interface Notification {
    void send(String message);
}




// Implement concrete notification classes
class EmailNotification implements Notification {
    private String to;
    private String subject;
    private String body;

  public EmailNotification(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

  @Override
    public void send(String message) {
        System.out.println("Sending email to " + to + " with subject " + subject + " and body: " + body);
    }
}

>>>>>>>.............whatsapp notifiication, slack notigication........



// Implement the NotificationFactory
class NotificationFactory {
    private static final Map<String, Supplier<Notification>> registry = new HashMap<>();




  // Register default types
    static {
        registry.put("email", () -> new EmailNotification("default", "default", "default"));
        registry.put("sms", () -> new SMSNotification("default", "default"));
        registry.put("slack", () -> new SlackNotification("default", "default"));
        registry.put("whatsapp", () -> new WhatsAppNotification("default", "default"));
    }



Registers a  a new notification type in the map
  public static void register(String type, Supplier<Notification> creator) {
        registry.put(type.toLowerCase(), creator);
    }




  public static Notification create(String type) {
        Supplier<Notification> creator = registry.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }

        
  return creator.get();  sends the object of the type of notiifcation through which we can work on those objects, since all the notiifcation objects and interface is abstracted
    }
}







// Example usage
public class NotificationService {
    public static void main(String[] args) {

    
  // Create notifications using the factory
        Notification emailNotification = NotificationFactory.create("email");
        emailNotification.send("Hello, this is an email notification.");

  Notification smsNotification = NotificationFactory.create("sms");
    smsNotification.send("Hello, this is an SMS notification.");



        
// You can also register new notification types
        NotificationFactory.register("newType", () -> new Notification() {
            @Override
            public void send(String message) {
                System.out.println("Sending a new type of notification: " + message);
            }
        });


  Notification newNotification = NotificationFactory.create("newType");
 newNotification.send("Hello, this is a new type of notification.");






![image](https://github.com/user-attachments/assets/a0adcded-c54a-4c05-83db-0e56a59b15f2)
