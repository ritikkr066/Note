import java.util.*;

public class ParkingFloor {
    int floorNumber;
    List<ParkingSlot>slots=new ArrayList<>();

    ParkingFloor(int floorNumber,int smallCount,int mediumCount,int largeCount){
        this.floorNumber=floorNumber;
        int slotNo=1;
        for(int i=1;i<=smallCount;i++){
            slots.add(new ParkingSlot(floorNumber,slotNo++,SlotSize.SMALL));
        }
        for(int i=1;i<=mediumCount;i++){
            slots.add(new ParkingSlot(floorNumber,slotNo++,SlotSize.MEDIUM));
        }
        for(int i=1;i<=largeCount;i++){
            slots.add(new ParkingSlot(floorNumber,slotNo++,SlotSize.LARGE));
        }
    }

    ParkingSlot getFreeSlot(Vehicle vehicle){
        for(ParkingSlot slot:slots){
            if(slot.canFit(vehicle)){
                return slot;
            }
        }
        return null;
    }
}
