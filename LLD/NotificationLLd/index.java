public class index {
    public static void main(String[] args) {

        // Notification notification=NotificationFactory.getNotification("WHATSAPP");

        // Notification reliableEmail= new RetryNotificationDecorator(notification, new FixedRetryStrategy(3, 1000));

        // reliableEmail.send("Important messsage");


        //step-2 Composite
        // Notification email =
        //         NotificationFactory.getNotification("EMAIL");

        // Notification sms =
        //         NotificationFactory.getNotification("SMS");

        // Notification push =
        //         NotificationFactory.getNotification("PUSH");

        // CompositeNotification multiChannel = new CompositeNotification();
        // multiChannel.add(email);
        // multiChannel.add(sms);
        // multiChannel.add(push);

        // // Client treats it SAME as single notification
        // multiChannel.send("System maintenance at 10 PM");


        //step-3  Decorator + Composite working together

        Notification email =
                NotificationFactory.getNotification("EMAIL");

        Notification reliableEmail =
                new RetryNotificationDecorator(
                        email,
                        new FixedRetryStrategy(3, 1000)
                );

        CompositeNotification composite = new CompositeNotification();
        composite.add(reliableEmail);
        composite.add(
                NotificationFactory.getNotification("SMS")
        );

        composite.send("Critical alert");


    }
}
