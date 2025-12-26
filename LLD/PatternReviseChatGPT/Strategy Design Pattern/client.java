public class client {
    public static void main(String[] args) {
        NotificationService service = new NotificationService(new EmailStrategy());
        service.notifyUser("Hello");

    }
}
