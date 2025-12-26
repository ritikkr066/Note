// Step 2: Concrete Products
public class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("EMAIL sent: " + message);
    }
}
