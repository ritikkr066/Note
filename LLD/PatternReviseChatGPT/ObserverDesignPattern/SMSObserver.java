public class SMSObserver implements Observer {
    public void update(String status) {
        System.out.println("SMS: Order status changed to " + status);
    }
}
