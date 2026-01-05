public class Client {
    public static void main(String[] args) {
        ElevatorSystem system=new ElevatorSystem(3);
        system.handleRequest(new Request(9, Direction.UP));
        system.handleRequest(new Request(2, Direction.DOWN));
        system.handleRequest(new Request(4, Direction.UP));
        system.handleRequest(new Request(3, Direction.UP));
        system.handleRequest(new Request(9, Direction.UP));
        system.handleRequest(new Request(4, Direction.UP));

        for (int i = 0; i < 10; i++) {
            for (Elevator e : system.elevators) {
                e.step();
            }
        }
    }
}
