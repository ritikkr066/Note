class DisplayBoard {

    void showAvailability(ParkingLot parkingLot) {
        int bike = 0, car = 0, truck = 0;

        for (ParkingFloor floor : parkingLot.floors) {
            for (ParkingSlot slot : floor.slots) {
                if (slot.isFree) {
                    if (slot.slotSize == SlotSize.SMALL) bike++;
                    else if (slot.slotSize== SlotSize.MEDIUM) car++;
                    else truck++;
                }
            }
        }

        System.out.println("Available Slots:");
        System.out.println("Bike: " + bike);
        System.out.println("Car: " + car);
        System.out.println("Truck: " + truck);
    }
}
