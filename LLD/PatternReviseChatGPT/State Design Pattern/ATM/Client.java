public class Client {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.insertCard();
        atm.enterPin(1234);
        atm.withdrawCash(2000);
    }
}
