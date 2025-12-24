public class PushNotification implements Notification {
    // static{
    //     NotificationFactory.register("PUSH",PushNotification::new);
    // }
    public void send(String message){
        System.out.println("Push Notification sent: "+message);
    }
}
