import java.util.ArrayList;
import java.util.HashMap;

class ParkingLot {
    ArrayList<ParkingFloor>floors=new ArrayList<>();
    HashMap<String,ParkingSlot>vehicleTrack=new HashMap<>();
    ParkingLot(int floor){
        for(int i=1;i<=floor;i++){
            floors.add(new ParkingFloor(i,1,1,1));
        }
    }

    

    public synchronized void parkVehicle(Vehicle vehicle){
        if (vehicleTrack.containsKey(vehicle.number)) {
            System.out.println("Vehicle already parked");
            return;
        }
        for(ParkingFloor floor : floors){
            ParkingSlot slot=floor.getFreeSlot(vehicle);
            if(slot!=null){
                slot.park(vehicle);
                vehicleTrack.put(vehicle.number,slot);
                System.out.println("parked "+ vehicle.type +" at floor "+ floor.floorNumber +" , slot "+ slot.slotnumber);
                return;
            }
        }
        System.out.println("No free slot");
    }

    public synchronized void removeVehicle(Vehicle vehicle){
        String vehicleNumber=vehicle.number;
        if(!vehicleTrack.containsKey(vehicleNumber)){
            System.out.println("vehicle not found"); 
            return;
        }
      
            ParkingSlot slotLocation=vehicleTrack.get(vehicleNumber);
             PricingStrategy pricing = new HourlyPricing();
            double fee = pricing.calculateFee(slotLocation.entryTime,System.currentTimeMillis());
            slotLocation.remove();
            vehicleTrack.remove(vehicleNumber);
            System.out.println(vehicle.type +" removed from Floor " +slotLocation.floorNumber + " Slot "+slotLocation.slotnumber);
            System.out.println("Parking fee :"+ fee); 
            
    }
}
