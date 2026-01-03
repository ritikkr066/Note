class AuthenticatedState implements ATMState {
    ATM atm;

    AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Transaction in progress");
    }

    public void ejectCard() {
        System.out.println("Card ejected");
        atm.setState(atm.noCardState);
    }

    public void enterPin(int pin) {
        System.out.println("Already authenticated");
    }

    public void withdrawCash(int amount) {
        if (atm.cash >= amount) {
            atm.cash -= amount;
            System.out.println("Cash withdrawn: " + amount);
            ejectCard();
        } else {
            System.out.println("ATM out of cash");
            atm.setState(atm.outOfCashState);
        }
    }
}
