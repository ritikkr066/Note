// Step 4: Concrete Observers
public class EmailObserver implements Observer {
    public void update(String status) {
        System.out.println("EMAIL: Order status changed to " + status);
    }
}
