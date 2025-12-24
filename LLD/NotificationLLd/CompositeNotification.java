import java.util.ArrayList;
import java.util.List;

public class CompositeNotification implements Notification {
    private final List<Notification> notifications = new ArrayList<>();

    public void add(Notification notification) {
        notifications.add(notification);
    }

    public void remove(Notification notification) {
        notifications.remove(notification);
    }

    @Override
    // public void send(String message) {
    //     for (Notification notification : notifications) {
    //         notification.send(message);
    //     }
    // }
    
    //upgraded: What if Email fails but SMS succeeds?
    public void send(String message) {
        for (Notification notification : notifications) {
            try {
                notification.send(message);
            } catch (Exception e) {
                System.out.println("Failed for one channel, continuing...");
            }
        }
    }
}
