public class Client {
    public static void main(String[] args) {

        Order order = new Order();

        order.register(new EmailObserver());
        order.register(new SMSObserver());

        order.setStatus("SHIPPED");
    }
}
