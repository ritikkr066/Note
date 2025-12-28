// Step 2: Concrete Implementations
public class UpiPayment extends PaymentProcess {

    @Override
    protected void debitAmount() {
        System.out.println("Debiting amount via UPI");
    }
}
