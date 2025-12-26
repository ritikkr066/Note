// Step 2: Subject Interface
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
