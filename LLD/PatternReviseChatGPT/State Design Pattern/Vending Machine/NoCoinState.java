// Step 2: Concrete States
class NoCoinState implements State {
    VendingMachine vm;

    NoCoinState(VendingMachine vm) {
        this.vm = vm;
    }
    public void insertCoin() {
        System.out.println("Coin inserted");
        vm.setState(vm.hasCoinState);
    }

    public void pressButton() {
        System.out.println("Insert coin first");
    }
}

class HasCoinState implements State {
    VendingMachine vm;

    HasCoinState(VendingMachine vm) {
        this.vm = vm;
    }

    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    public void pressButton() {
        System.out.println("Dispensing item");
        vm.setState(vm.noCoinState);
    }
}
