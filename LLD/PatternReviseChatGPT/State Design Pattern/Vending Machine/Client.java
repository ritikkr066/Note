public class Client {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.insertCoin();
        vm.pressButton();
        vm.pressButton();
    }
}
