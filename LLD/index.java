public class index {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(2);

        EntryGate entry1 = new EntryGate(1, parkingLot);
        ExitGate exit1 = new ExitGate(1, parkingLot);

        DisplayBoard board = new DisplayBoard();

        Vehicle car1 = new Vehicle("KA01AB1234", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("KA01XY9999", VehicleType.BIKE);
        Vehicle truck1 = new Vehicle("KA01TR1111", VehicleType.TRUCK);

        board.showAvailability(parkingLot);

        entry1.enter(car1);
        entry1.enter(bike1);
        entry1.enter(truck1);

        board.showAvailability(parkingLot);

        exit1.exit(car1);

        board.showAvailability(parkingLot);
    }
}



// public class index {
//     public static void main(String args[]){
//         ParkingLot ps=new ParkingLot(2);
//         Vehicle v=new Vehicle("A123",VehicleType.BIKE);
//         Vehicle v1=new Vehicle("B123",VehicleType.CAR);
//         Vehicle v2=new Vehicle("C123",VehicleType.TRUCK);
//         Vehicle v3=new Vehicle("D123",VehicleType.TRUCK);
//         Vehicle v4=new Vehicle("E123",VehicleType.TRUCK);

       
//         ps.parkVehicle(v);
//         ps.parkVehicle(v1);
//         ps.parkVehicle(v2);
//         ps.parkVehicle(v3);
//         ps.parkVehicle(v4);
//         ps.removeVehicle(v);
//         ps.removeVehicle(v2);
//         ps.removeVehicle(v3);
//         ps.removeVehicle(v1);
//     }
// }
