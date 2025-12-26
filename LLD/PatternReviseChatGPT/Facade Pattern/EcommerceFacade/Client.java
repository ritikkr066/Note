public class Client {
    public static void main(String[] args) {

        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("P123");
    }
}
