import java.util.ArrayList;

class ElevatorSystem {
    ArrayList<Elevator>elevators;

    public ElevatorSystem(int numberOfElevators){
        elevators=new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            // elevators.add(new Elevator(i));
            Elevator e = new Elevator(i);
            elevators.add(e);

            Thread t = new Thread(e);
            t.start();   // 🚀 elevator starts moving independently
        }
    }

    public void handleRequest(Request request){
        Elevator bestElevator=findBestElevator(request);
        if(bestElevator!=null){
            bestElevator.addRequest(request.floor);
            //  System.out.println("Request added to Elevator " +  bestElevator.id +
            //            " for floor " + request.floor);
        }else{
            System.out.println("No elevator available");
        }
    }

    private Elevator findBestElevator(Request req) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        // 1️⃣ Same direction & on the way
        for (Elevator e : elevators) {
            if (e.state == ElevatorState.MOVING &&
                e.direction == req.direction) {

                if ((req.direction == Direction.UP && e.currentFloor <= req.floor) ||
                    (req.direction == Direction.DOWN && e.currentFloor >= req.floor)) {

                    int dist = Math.abs(e.currentFloor - req.floor);
                    if (dist < minDistance) {
                        minDistance = dist;
                        best = e;
                    }
                }
            }
        }

        if (best != null) return best;

        // 2️⃣ Idle elevators
        for (Elevator e : elevators) {
            if (e.state == ElevatorState.IDLE) {
                int dist = Math.abs(e.currentFloor - req.floor);
                if (dist < minDistance) {
                    minDistance = dist;
                    best = e;
                }
            }
        }

        if (best != null) return best;

        // 3️⃣ Fallback
        for (Elevator e : elevators) {
            int dist = Math.abs(e.currentFloor - req.floor);
            if (dist < minDistance) {
                minDistance = dist;
                best = e;
            }
        }

        return best;
    }


    // public Elevator findBestElevator(Request request){
    //     Elevator best=null;
    //     int minScore=Integer.MAX_VALUE;
    //     // for(Elevator e: elevators){
    //     //     int distance=Math.abs(e.currentFloor-request.floor);
    //     //     if(distance<minDistance){
    //     //         minDistance=distance;
    //     //         best=e;
    //     //     }
    //     // }
    //     for (Elevator e : elevators) {

    //     int load = e.upRequests.size() + e.downRequests.size();
    //     int distance = Math.abs(e.currentFloor - request.floor);

    //     // Lower score is better
    //     int score = (e.direction == Direction.IDLE ? 0 : 1000)
    //                 + load * 10
    //                 + distance;

    //     if (score < minScore) {
    //         minScore = score;
    //         best = e;
    //     }
    // }
    //     return best;
    // }
}
