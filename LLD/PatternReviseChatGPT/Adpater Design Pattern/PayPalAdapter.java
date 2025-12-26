// Step 3: Adapter
public class PayPalAdapter implements PaymentProcessor {

    private PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void pay(int amount) {
        // adapting interface
        payPalService.makePayment((double) amount);
    }
}
