public class WhatsappNotification implements Notification {
    // “Self-registration depends on class loading, which is usually handled by frameworks like Spring. For simplicity and reliability, I use a factory-level registry.”
    
    // static{
    //     NotificationFactory.register("WHATSAPP",WhatsappNotification::new);
    // }

    public void send(String message){
        System.out.println("Whatsapp message sent: "+message);
    }
}
