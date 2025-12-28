public class Client {
    public static void main(String[] args) {

        PaymentProcess payment = new UpiPayment();
        payment.processPayment();

        System.out.println("----");

        payment = new CardPayment();
        payment.processPayment();
    }
}
