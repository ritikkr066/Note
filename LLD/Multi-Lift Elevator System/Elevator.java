import java.util.Collections;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.TreeSet;

class Elevator implements Runnable{
    int id;
    int currentFloor;
    ElevatorState state = ElevatorState.IDLE;
    Direction direction =  Direction.NONE;
    // Queue<Integer>requests;
    TreeSet<Integer>upRequests;
    TreeSet<Integer>downRequests;

    static final int MIN_FLOOR = 0;
    static final int MAX_FLOOR = 10;

    



        public Elevator(int id){
            this.id=id;
            this.currentFloor=0;
            this.direction=Direction.IDLE;
            // requests=new LinkedList<>();
            this.upRequests = new TreeSet<>();
            this.downRequests = new TreeSet<>(Collections.reverseOrder());
        }
    
        public synchronized void addRequest(int floor){
            if (floor == currentFloor) {
                System.out.println("Elevator " + id +
                    " already at floor " + floor + " — doors opened");
                return;
            }
            
            if(floor>currentFloor){
                upRequests.add(floor);
            }else if(floor<currentFloor){
                downRequests.add(floor);
            }
            if (direction == Direction.IDLE) {
                if (!upRequests.isEmpty()) direction = Direction.UP;
                else if (!downRequests.isEmpty()) direction = Direction.DOWN;
            }
            System.out.println("Request added to Elevator " + id + 
                           " for floor " + floor);
                           
        }

        // public void move() {
        //     if (direction == Direction.UP) {
        //         processUpRequests();
        //     } else if (direction == Direction.DOWN) {
        //         processDownRequests();
        //     } else {
        //         System.out.println("Elevator " + id + " is IDLE");
        //     }
        // }

        // private void processUpRequests() {
        //     if (upRequests.isEmpty()) {
        //         direction = !downRequests.isEmpty() ? Direction.DOWN : Direction.IDLE;
        //         return;
        //     }

        //     int nextFloor = upRequests.pollFirst();
        //     moveTo(nextFloor);
        // }
    
        // private void processDownRequests() {
        //     if (downRequests.isEmpty()) {
        //         direction = !upRequests.isEmpty() ? Direction.UP : Direction.IDLE;
        //         return;
        //     }

        //     int nextFloor = downRequests.pollFirst();
        //     moveTo(nextFloor);
        // }

        // private void moveTo(int floor) {
        //     System.out.println("Elevator " + id +
        //         " moving " + direction +
        //         " from " + currentFloor +
        //         " to " + floor);

        //     currentFloor = floor;

        //     System.out.println("Elevator " + id +
        //         " reached floor " + currentFloor);
        // }

        public synchronized void step() {

            if (upRequests.isEmpty() && downRequests.isEmpty()) {
                state = ElevatorState.IDLE;
                direction = Direction.IDLE;
                return;
            }

            state = ElevatorState.MOVING;

            // Decide direction if idle
            if (direction == Direction.IDLE) {
                if (!upRequests.isEmpty()) direction = Direction.UP;
                else if (!downRequests.isEmpty()) direction = Direction.DOWN;
                else return; // nothing to do
            }

            // Move ONE floor
            if (direction == Direction.UP) {
                if (currentFloor == MAX_FLOOR) {
                    direction = Direction.DOWN;
                    return;
                }

                currentFloor++;
                System.out.println("Elevator " + id + " at floor " + currentFloor);

                // Stop if request exists
                if (upRequests.contains(currentFloor)) {
                    upRequests.remove(currentFloor);
                    System.out.println("Elevator " + id +
                        " stopped at floor " + currentFloor);
                }

                // Switch direction if no more UP requests
                if (upRequests.isEmpty() && !downRequests.isEmpty()) {
                    direction = Direction.DOWN;
                }

            } else if (direction == Direction.DOWN) {
                if (currentFloor == MIN_FLOOR) {
                    direction = Direction.UP;
                    return;
                }

                currentFloor--;
                System.out.println("Elevator " + id + " at floor " + currentFloor);

                if (downRequests.contains(currentFloor)) {
                    downRequests.remove(currentFloor);
                    System.out.println("Elevator " + id +
                        " stopped at floor " + currentFloor);
                }

                if (downRequests.isEmpty() && !upRequests.isEmpty()) {
                    direction = Direction.UP;
                }
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    step();                 // move one floor if needed
                    Thread.sleep(1000);     // 1 second per floor
                }
            } catch (InterruptedException e) {
                System.out.println("Elevator " + id + " stopped.");
            }
        }


        // public void step() {
        //     if (direction == Direction.IDLE) {
        //         if (!upRequests.isEmpty()) direction = Direction.UP;
        //         else if (!downRequests.isEmpty()) direction = Direction.DOWN;
        //         else return;
        //     }

        //     if (direction == Direction.UP) {
        //         processUpRequests();
        //     } else {
        //         processDownRequests();
        //     }
        // }


    // public void processNextRequest(){
    //     if(requests.isEmpty()){
    //         direction=Direction.IDLE;
    //         return;
    //     }
    //     int nextFloor=requests.poll();
        

    //     System.out.println("Elevator " + id + 
    //         " moving from " + currentFloor + 
    //         " to " + nextFloor);
        
    //     currentFloor=nextFloor;
    //     direction=Direction.IDLE;

    //     System.out.println("Elevator " + id + 
    //         " reached floor " + currentFloor);
    // }

}