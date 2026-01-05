import java.util.Collections;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.TreeSet;

class Elevator{
    int id;
    int currentFloor;
    Direction direction;
    // Queue<Integer>requests;
    TreeSet<Integer>upRequests;
    TreeSet<Integer>downRequests;

        public Elevator(int id){
            this.id=id;
            this.currentFloor=0;
            this.direction=Direction.IDLE;
            // requests=new LinkedList<>();
            this.upRequests = new TreeSet<>();
            this.downRequests = new TreeSet<>(Collections.reverseOrder());
        }
    
        public void addRequest(int floor){
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

        public void move() {
            if (direction == Direction.UP) {
                processUpRequests();
            } else if (direction == Direction.DOWN) {
                processDownRequests();
            } else {
                System.out.println("Elevator " + id + " is IDLE");
            }
        }

        private void processUpRequests() {
            if (upRequests.isEmpty()) {
                direction = !downRequests.isEmpty() ? Direction.DOWN : Direction.IDLE;
                return;
            }

            int nextFloor = upRequests.pollFirst();
            moveTo(nextFloor);
        }
    
        private void processDownRequests() {
            if (downRequests.isEmpty()) {
                direction = !upRequests.isEmpty() ? Direction.UP : Direction.IDLE;
                return;
            }

            int nextFloor = downRequests.pollFirst();
            moveTo(nextFloor);
        }

        private void moveTo(int floor) {
            System.out.println("Elevator " + id +
                " moving " + direction +
                " from " + currentFloor +
                " to " + floor);

            currentFloor = floor;

            System.out.println("Elevator " + id +
                " reached floor " + currentFloor);
        }

        public void step() {
            if (direction == Direction.IDLE) {
                if (!upRequests.isEmpty()) direction = Direction.UP;
                else if (!downRequests.isEmpty()) direction = Direction.DOWN;
                else return;
            }

            if (direction == Direction.UP) {
                processUpRequests();
            } else {
                processDownRequests();
            }
        }


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