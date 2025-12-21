class EntryGate {
    int gateNumber;
    ParkingLot parkingLot;

    EntryGate(int gateNumber, ParkingLot parkingLot) {
        this.gateNumber = gateNumber;
        this.parkingLot = parkingLot;
    }

    void enter(Vehicle vehicle) {
        System.out.println("Vehicle " + vehicle.number + " arrived at Entry Gate " + gateNumber);
        parkingLot.parkVehicle(vehicle);
    }
}
