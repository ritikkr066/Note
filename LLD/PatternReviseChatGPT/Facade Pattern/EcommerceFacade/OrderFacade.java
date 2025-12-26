// Step 2: Facade Class
public class OrderFacade {

    private Inventory inventory;
    private Payment payment;
    private Shipping shipping;

    public OrderFacade() {
        this.inventory = new Inventory();
        this.payment = new Payment();
        this.shipping = new Shipping();
    }

    public void placeOrder(String productId) {
        if (inventory.checkStock(productId)) {
            payment.makePayment();
            shipping.shipProduct();
        }
    }
}
