public class Client {
    public static void main(String[] args) {

        PaymentProcessor processor =
                new PayPalAdapter(new PayPalService());

        processor.pay(500);
    }
}
