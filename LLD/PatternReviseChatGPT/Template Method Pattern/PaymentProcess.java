// Step 1: Abstract Class (Template)
public abstract class PaymentProcess {

    // Template Method
    public final void processPayment() {
        validate();
        debitAmount();
        notifyUser();
    }

    protected void validate() {
        System.out.println("Validating payment");
    }

    protected abstract void debitAmount();

    // Hook (optional override)
    protected void notifyUser() {
        System.out.println("Sending default notification");
    }
}
