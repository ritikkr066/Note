public class CardPayment extends PaymentProcess {

    @Override
    protected void debitAmount() {
        System.out.println("Debiting amount via Card");
    }

    @Override
    protected void notifyUser() {
        System.out.println("Sending SMS notification");
    }
}
