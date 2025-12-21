class ParkingSlot {
    int slotnumber;
    boolean isFree;
    Vehicle vehicle;
    long entryTime;
    int floorNumber;
    SlotSize slotSize;
    
    ParkingSlot(int floorNumber,int slotnumber,SlotSize slotSize){
        this.floorNumber=floorNumber;
        this.slotnumber=slotnumber;
        this.slotSize=slotSize;
        this.isFree=true;
    }

    boolean canFit(Vehicle vehicle){
        if(!isFree)return  false;
        switch (vehicle.type) {
            case BIKE:
                return true;
            case CAR:
                return slotSize ==SlotSize.MEDIUM || slotSize==SlotSize.LARGE;
            case TRUCK:
                return slotSize==SlotSize.LARGE;
            default:
               return false;
        }
    }

    void park(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isFree=false;
        this.entryTime = System.currentTimeMillis();
    }

    void remove(){
        this.vehicle=null;
        this.isFree=true;
    }
}
