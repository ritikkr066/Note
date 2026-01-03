class ATM {

    ATMState noCardState;
    ATMState hasCardState;
    ATMState authenticatedState;
    ATMState outOfCashState;

    ATMState currentState;
    int cash = 5000;

    ATM() {
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        authenticatedState = new AuthenticatedState(this);
        outOfCashState = new OutOfCashState(this);
        currentState = noCardState;
    }

    void setState(ATMState state) {
        currentState = state;
    }

    void insertCard() {
        currentState.insertCard();
    }

    void ejectCard() {
        currentState.ejectCard();
    }

    void enterPin(int pin) {
        currentState.enterPin(pin);
    }

    void withdrawCash(int amount) {
        currentState.withdrawCash(amount);
    }
}
