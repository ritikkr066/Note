public class EmailNotification implements Notification {
    // static{
    //     NotificationFactory.register("EMAIL",EmailNotification::new);
    // }
    public void send(String message){
        System.out.println("Email sent "+ message);
    }
}
