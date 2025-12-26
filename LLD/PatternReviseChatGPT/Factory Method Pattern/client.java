// Step 5: Client Code
public class client {
    public static void main(String[] args) {

        NotificationCreator creator =
                new EmailNotificationCreator();

        creator.notifyUser("Your OTP is 1234");
    }
}
