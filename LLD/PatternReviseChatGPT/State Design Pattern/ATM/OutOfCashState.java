class OutOfCashState implements ATMState {
    ATM atm;

    OutOfCashState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("ATM out of service");
    }

    public void ejectCard() {
        System.out.println("No card");
    }

    public void enterPin(int pin) {
        System.out.println("ATM out of service");
    }

    public void withdrawCash(int amount) {
        System.out.println("ATM out of service");
    }
}
