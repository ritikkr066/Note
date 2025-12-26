// Step 2: Adaptee (Incompatible API)
public class PayPalService {
    public void makePayment(double amount) {
        System.out.println("Paid via PayPal: " + amount);
    }
}
