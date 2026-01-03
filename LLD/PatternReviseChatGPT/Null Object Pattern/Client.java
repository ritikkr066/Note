public class Client {
    public static void main(String[] args) {
        Notification notification = getNotification(false);

        notification.send("Hello"); // SAFE
    }

    static Notification getNotification(boolean enabled) {
        if (enabled) {
            return new EmailNotification();
        }
        return new NullNotification();
    }
}
