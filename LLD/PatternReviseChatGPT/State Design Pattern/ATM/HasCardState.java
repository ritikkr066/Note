class HasCardState implements ATMState {
    ATM atm;

    HasCardState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card already inserted");
    }

    public void ejectCard() {
        System.out.println("Card ejected");
        atm.setState(atm.noCardState);
    }

    public void enterPin(int pin) {
        if (pin == 1234) {
            System.out.println("PIN correct");
            atm.setState(atm.authenticatedState);
        } else {
            System.out.println("Wrong PIN");
            atm.setState(atm.noCardState);
        }
    }

    public void withdrawCash(int amount) {
        System.out.println("Enter PIN first");
    }
}
