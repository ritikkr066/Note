import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {

    private static final Map<String , Supplier<Notification>>registry=new HashMap<>();

    // public static void register(String type, Supplier<Notification> supplier){
    //     registry.put(type.toUpperCase(),supplier);
    // }

    static{
        registry.put("EMAIL",EmailNotification::new); // () -> new EmailNotification()
        registry.put("SMS", SMSNotification::new);
        registry.put("PUSH", PushNotification::new);
         registry.put("WHATSAPP", WhatsappNotification::new);
    }

    //<----Interview Question------>>
    // Why NOT do this? ❌ registry.put("EMAIL", new EmailNotification());
    // Because: That would create the object immediately, Factory should create on demand, 
    // Using Supplier: Object is created only when get() is called

    public static Notification getNotification(String type){
        Supplier<Notification>supplier=registry.get(type.toUpperCase());
        if(supplier==null){
            throw new IllegalArgumentException("Invalid notification type");
        }
        return supplier.get();
    }

    // <---- voilate OCP ----->>
    // public static Notification getNotification(String type){
    //     if(type.equalsIgnoreCase("EMAIL")){
    //         return new EmailNotification();
    //     }else if(type.equalsIgnoreCase("SMS")){
    //         return new SMSNotification();
    //     }else if(type.equalsIgnoreCase("PUSH")){
    //         return new PushNotification();
    //     }
    //     throw new IllegalArgumentException("Invalid type");
    // }
}
