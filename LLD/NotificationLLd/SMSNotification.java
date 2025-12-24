public class SMSNotification implements Notification{
    // static{
    //     NotificationFactory.register("SMS",SMSNotification::new);
    // }
    public void send(String message){
        System.out.println("SMS sent :"+ message);
    }
}
