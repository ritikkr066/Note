class ExitGate {
    int gateNumber;
    ParkingLot parkingLot;

    ExitGate(int gateNumber, ParkingLot parkingLot) {
        this.gateNumber = gateNumber;
        this.parkingLot = parkingLot;
    }

    void exit(Vehicle vehicle) {
        System.out.println("Vehicle " + vehicle.number + " at Exit Gate " + gateNumber);
        parkingLot.removeVehicle(vehicle);
    }
}
