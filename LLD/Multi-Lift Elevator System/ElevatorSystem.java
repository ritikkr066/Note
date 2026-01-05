import java.util.ArrayList;

class ElevatorSystem {
    ArrayList<Elevator>elevators;

    public ElevatorSystem(int numberOfElevators){
        elevators=new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            elevators.add(new Elevator(i));
        }
    }

    public void handleRequest(Request request){
        Elevator bestElevator=findBestElevator(request);
        if(bestElevator!=null){
            bestElevator.addRequest(request.floor);
            bestElevator.move();
        }else{
            System.out.println("No elevator available");
        }
    }

    public Elevator findBestElevator(Request request){
        Elevator best=null;
        int minDistance=Integer.MAX_VALUE;
        for(Elevator e: elevators){
            int distance=Math.abs(e.currentFloor-request.floor);
            if(distance<minDistance){
                minDistance=distance;
                best=e;
            }
        }
        return best;
    }
}
