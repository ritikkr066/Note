class VendingMachine {
    State noCoinState;
    State hasCoinState;
    State currentState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        currentState = noCoinState;
    }

    public void setState(State state) {
        currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressButton() {
        currentState.pressButton();
    }
}
