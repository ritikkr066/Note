import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;

class Elevator implements Runnable{
    int id;
    int currentFloor;
    ElevatorState state = ElevatorState.IDLE;
    Direction direction =  Direction.NONE;
    TreeMap<Integer,StopType>upRequests;
    TreeMap<Integer,StopType>downRequests;

    private final int minFloor;
    private final int maxFloor;

        public Elevator(int id,int minFloor,int maxFloor){
            this.id=id;
            this.currentFloor=0;
            this.direction=Direction.IDLE;
            this.minFloor = minFloor;
            this.maxFloor = maxFloor;
    
            this.upRequests = new TreeMap<>();
            this.downRequests = new TreeMap<>(Collections.reverseOrder());
        }
    
        public synchronized void addPickupRequest(int floor, Direction reqDirection){
            if (floor == currentFloor) {
                System.out.println("Elevator " + id +
                    " already at floor " + floor + " — doors opened");
                
                onPassengerEntered();
                return;
            }

            // 🔑 Use REQUEST direction (not relative position)
            if (reqDirection == Direction.UP) {
                upRequests.put(floor, StopType.PICKUP);
            } else if (reqDirection == Direction.DOWN) {
                downRequests.put(floor, StopType.PICKUP);
            }

            // Wake up elevator if idle
            if (direction == Direction.IDLE) {
                // direction = reqDirection;
                 if(!upRequests.isEmpty()) direction = Direction.UP;
                else if(!downRequests.isEmpty()) direction = Direction.DOWN;
            }

            System.out.println(
                "Pickup request added to Elevator " + id +
                " for floor " + floor +
                " direction " + reqDirection
            );
                           
        }

        public synchronized void addInternalRequest(int floor) {
            if (floor < minFloor || floor > maxFloor) {
                System.out.println(
                    "Invalid internal request " + floor +
                    " for Elevator " + id
                );
                return;
            }

            if (floor == currentFloor) {
                // System.out.println("Elevator " + id +
                //     " already at floor " + floor + " ? doors opened");

                // onPassengerEntered();
                return;
            }

            if (floor > currentFloor) {
                upRequests.put(floor,StopType.DROPOFF);
            } else {
                downRequests.put(floor,StopType.DROPOFF);
            }

            System.out.println("Elevator " + id +
                " internal request added for floor " + floor);
        }

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
                else {
                    state = ElevatorState.IDLE;
                    return; 
                }// nothing to do
                // 🚫 Do NOT move if no requests in current direction
                
            }

            if (direction == Direction.UP && upRequests.isEmpty()) {
                    if (!downRequests.isEmpty()) {
                        direction = Direction.DOWN;
                    } else {
                        direction = Direction.IDLE;
                        state = ElevatorState.IDLE;
                        return;
                    }
                }

                if (direction == Direction.DOWN && downRequests.isEmpty()) {
                    if (!upRequests.isEmpty()) {
                        direction = Direction.UP;
                    } else {
                        direction = Direction.IDLE;
                        state = ElevatorState.IDLE;
                        return;
                    }
                }
            if (direction == Direction.UP && currentFloor == maxFloor) {
                if (!downRequests.isEmpty()) {
                    direction = Direction.DOWN;
                } else {
                    direction = Direction.IDLE;
                    state = ElevatorState.IDLE;
                }
                return;
            }

            if (direction == Direction.DOWN && currentFloor == minFloor) {
                if (!upRequests.isEmpty()) {
                    direction = Direction.UP;
                } else {
                    direction = Direction.IDLE;
                    state = ElevatorState.IDLE;
                }
                return;
            }


            // Move ONE floor
            if (direction == Direction.UP) {
                if (currentFloor == maxFloor) {
                    direction = Direction.DOWN;
                    return;
                }

                currentFloor++;
                System.out.println("Elevator " + id + " at floor " + currentFloor);

                // Stop if request exists
                if (upRequests.containsKey(currentFloor)) {
                    StopType type = upRequests.remove(currentFloor);
                    // upRequests.remove(currentFloor);
                    System.out.println("Elevator " + id +
                        " stopped at floor " + currentFloor);
                    
                    if (type == StopType.PICKUP) {
                        onPassengerEntered(); // ✅ NOW passenger boards
                    }
                }

                // Switch direction if no more UP requests
                if (upRequests.isEmpty() && !downRequests.isEmpty()) {
                    direction = Direction.DOWN;
                }

            } else if (direction == Direction.DOWN) {
                if (currentFloor == minFloor) {
                    direction = Direction.UP;
                    return;
                }

                currentFloor--;
                System.out.println("Elevator " + id + " at floor " + currentFloor);

                if (downRequests.containsKey(currentFloor)) {
                    StopType type=downRequests.remove(currentFloor);
                    System.out.println("Elevator " + id +
                        " stopped at floor " + currentFloor);
                    
                    if (type == StopType.PICKUP) {
                        onPassengerEntered(); // ✅ NOW passenger boards
                    }
                }

                if (downRequests.isEmpty() && !upRequests.isEmpty()) {
                    direction = Direction.UP;
                }
            }
        }

        private synchronized void onPassengerEntered() {
            int destination = getRandomDestination();

            System.out.println(
                "Passenger boarded Elevator " + id +
                " at floor " + currentFloor +
                ", destination: " + destination
            );

            addInternalRequest(destination);
        }

        private synchronized int getRandomDestination() {
            int dest;
            do {
                dest = minFloor +
                    new Random().nextInt(maxFloor - minFloor + 1);
            } while (dest == currentFloor);
            return dest;
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
}