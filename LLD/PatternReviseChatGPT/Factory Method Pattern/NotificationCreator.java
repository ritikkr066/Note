// Step 3: Creator (Abstract Factory)
public abstract class NotificationCreator {

    // Factory Method
    protected abstract Notification createNotification();

    // Business logic uses factory method
    public void notifyUser(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}

// 👉 Client never uses new
