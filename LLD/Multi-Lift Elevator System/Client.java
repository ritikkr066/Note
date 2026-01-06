public class Client {
    public static void main(String[] args) throws InterruptedException {
        ElevatorSystem system=new ElevatorSystem(3);
        system.handleRequest(new Request(9, Direction.UP));
        Thread.sleep(2000);

        system.handleRequest(new Request(2, Direction.DOWN));
        Thread.sleep(2000);

        system.handleRequest(new Request(4, Direction.UP));
        system.handleRequest(new Request(3, Direction.UP));
        system.handleRequest(new Request(9, Direction.DOWN));
        Thread.sleep(2000);

        system.handleRequest(new Request(4, Direction.UP));

        // while (true) {
        //     for (Elevator e : system.elevators) {
        //         e.step();
        //     }
        //     Thread.sleep(1000); // 1 second per floor
        // }
    }
}
