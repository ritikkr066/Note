import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

// -------------------------
// Interfaces and Enums
// -------------------------
enum VehicleType { TWO_WHEELER, FOUR_WHEELER }

interface Vehicle {
    String getLicensePlate();
    VehicleType getType();
}

interface Observer {
    void update(String message);
}

interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers(String message);
}

// Strategy for pricing
interface PricingStrategy {
    // returns price in currency units
    double calculatePrice(LocalDateTime start, LocalDateTime end, VehicleType type);
}

// -------------------------
// Concrete Vehicles & Factory (Factory Pattern)
// -------------------------
class TwoWheeler implements Vehicle {
    private final String licensePlate;
    public TwoWheeler(String licensePlate) { this.licensePlate = licensePlate; }
    @Override public String getLicensePlate() { return licensePlate; }
    @Override public VehicleType getType() { return VehicleType.TWO_WHEELER; }
}

class FourWheeler implements Vehicle {
    private final String licensePlate;
    public FourWheeler(String licensePlate) { this.licensePlate = licensePlate; }
    @Override public String getLicensePlate() { return licensePlate; }
    @Override public VehicleType getType() { return VehicleType.FOUR_WHEELER; }
}

class VehicleFactory {
    // Simple factory method
    public static Vehicle createVehicle(VehicleType type, String licensePlate) {
        switch (type) {
            case TWO_WHEELER: return new TwoWheeler(licensePlate);
            case FOUR_WHEELER: return new FourWheeler(licensePlate);
            default: throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}

// -------------------------
// Ticket and TicketGenerator (Singleton for ID generation)
// -------------------------
class Ticket {
    private final String ticketId;
    private final String licensePlate;
    private final VehicleType vehicleType;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(String ticketId, String licensePlate, VehicleType type, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.vehicleType = type;
        this.entryTime = entryTime;
    }

    public String getTicketId() { return ticketId; }
    public String getLicensePlate() { return licensePlate; }
    public VehicleType getVehicleType() { return vehicleType; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }
    public Duration getParkDuration() {
        return Duration.between(entryTime, exitTime == null ? LocalDateTime.now() : exitTime);
    }
}

class TicketGenerator {
    // Simple thread-safe singleton for generating ticket IDs
    private static TicketGenerator instance;
    private long counter = 0;

    private TicketGenerator() {}

    public static synchronized TicketGenerator getInstance() {
        if (instance == null) instance = new TicketGenerator();
        return instance;
    }

    public synchronized String generateTicketId() {
        counter++;
        return "T" + String.format("%06d", counter);
    }
}

// -------------------------
// Parking Spot
// -------------------------
enum SpotType { TWO_WHEELER_SPOT, FOUR_WHEELER_SPOT }

class ParkingSpot {
    private final String id;
    private final SpotType type;
    private boolean occupied = false;
    private Ticket currentTicket = null;

    public ParkingSpot(String id, SpotType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() { return id; }
    public SpotType getType() { return type; }
    public boolean isOccupied() { return occupied; }

    public boolean assign(Ticket ticket) {
        if (occupied) return false;
        this.currentTicket = ticket;
        this.occupied = true;
        return true;
    }

    public Ticket remove() {
        if (!occupied) return null;
        Ticket t = currentTicket;
        this.currentTicket = null;
        this.occupied = false;
        return t;
    }
}

// -------------------------
// Pricing Strategies (Strategy Pattern)
// -------------------------
class HourlyPricingStrategy implements PricingStrategy {
    private final double twoWheelerRatePerHour;
    private final double fourWheelerRatePerHour;

    public HourlyPricingStrategy(double twoWheelerRatePerHour, double fourWheelerRatePerHour) {
        this.twoWheelerRatePerHour = twoWheelerRatePerHour;
        this.fourWheelerRatePerHour = fourWheelerRatePerHour;
    }

    @Override
    public double calculatePrice(LocalDateTime start, LocalDateTime end, VehicleType type) {
        long minutes = Duration.between(start, end).toMinutes();
        double hours = Math.ceil(minutes / 60.0); // charge for partial hour as full
        if (type == VehicleType.TWO_WHEELER) return hours * twoWheelerRatePerHour;
        return hours * fourWheelerRatePerHour;
    }
}

class FlatBlockPricingStrategy implements PricingStrategy {
    // e.g., first 2 hours flat 50 for two-wheeler
    private final double twoWheelerFlat;
    private final double fourWheelerFlat;
    private final double afterRatePerHourTwo;
    private final double afterRatePerHourFour;

    public FlatBlockPricingStrategy(double twoWheelerFlat, double fourWheelerFlat,
                                    double afterRatePerHourTwo, double afterRatePerHourFour) {
        this.twoWheelerFlat = twoWheelerFlat;
        this.fourWheelerFlat = fourWheelerFlat;
        this.afterRatePerHourTwo = afterRatePerHourTwo;
        this.afterRatePerHourFour = afterRatePerHourFour;
    }

    @Override
    public double calculatePrice(LocalDateTime start, LocalDateTime end, VehicleType type) {
        long minutes = Duration.between(start, end).toMinutes();
        double hours = Math.ceil(minutes / 60.0);
        if (type == VehicleType.TWO_WHEELER) {
            if (hours <= 2) return twoWheelerFlat;
            return twoWheelerFlat + (hours - 2) * afterRatePerHourTwo;
        } else {
            if (hours <= 2) return fourWheelerFlat;
            return fourWheelerFlat + (hours - 2) * afterRatePerHourFour;
        }
    }
}

// -------------------------
// ParkingLot (Singleton + Subject for Observer Pattern)
// -------------------------
class ParkingLot implements Subject {
    private static ParkingLot instance;

    // Observers (e.g., EntranceGate, display panels)
    private final List<Observer> observers = new ArrayList<>();

    // Spot pools
    private final Map<SpotType, Queue<ParkingSpot>> freeSpots = new HashMap<>();
    private final Map<String, ParkingSpot> occupiedSpots = new HashMap<>(); // ticketId -> spot

    // Pricing (Strategy)
    private PricingStrategy pricingStrategy;

    private ParkingLot(int twoWheelerSpots, int fourWheelerSpots, PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;

        Queue<ParkingSpot> two = new LinkedList<>();
        for (int i = 1; i <= twoWheelerSpots; i++) two.add(new ParkingSpot("T" + i, SpotType.TWO_WHEELER_SPOT));
        Queue<ParkingSpot> four = new LinkedList<>();
        for (int i = 1; i <= fourWheelerSpots; i++) four.add(new ParkingSpot("F" + i, SpotType.FOUR_WHEELER_SPOT));

        freeSpots.put(SpotType.TWO_WHEELER_SPOT, two);
        freeSpots.put(SpotType.FOUR_WHEELER_SPOT, four);
    }

    // Initialize singleton with configuration once
    public static synchronized ParkingLot init(int twoWheelerSpots, int fourWheelerSpots, PricingStrategy pricingStrategy) {
        if (instance == null) instance = new ParkingLot(twoWheelerSpots, fourWheelerSpots, pricingStrategy);
        return instance;
    }

    public static ParkingLot getInstance() {
        if (instance == null) throw new IllegalStateException("ParkingLot not initialized. Call init() first.");
        return instance;
    }

    // Subject interface
    @Override
    public void register(Observer o) { observers.add(o); }
    @Override
    public void unregister(Observer o) { observers.remove(o); }
    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) o.update(message);
    }

    // Try to park a vehicle: returns assigned ticket if success
    public synchronized Ticket parkVehicle(Vehicle v) {
        SpotType requiredSpot = v.getType() == VehicleType.TWO_WHEELER ? SpotType.TWO_WHEELER_SPOT : SpotType.FOUR_WHEELER_SPOT;
        Queue<ParkingSpot> pool = freeSpots.get(requiredSpot);
        if (pool == null || pool.isEmpty()) {
            notifyObservers("No free spots for " + requiredSpot);
            return null;
        }

        ParkingSpot spot = pool.poll();
        Ticket ticket = new Ticket(TicketGenerator.getInstance().generateTicketId(), v.getLicensePlate(), v.getType(), LocalDateTime.now());
        boolean assigned = spot.assign(ticket);
        if (!assigned) {
            // fallback (shouldn't happen)
            pool.add(spot);
            return null;
        }
        occupiedSpots.put(ticket.getTicketId(), spot);

        // Notify observers about new status
        notifyObservers("Vehicle parked. Ticket: " + ticket.getTicketId() + " at spot " + spot.getId());
        if (isFull()) notifyObservers("ParkingLot FULL");
        return ticket;
    }

    // Unpark -> returns price
    public synchronized double unParkVehicle(String ticketId) {
        ParkingSpot spot = occupiedSpots.get(ticketId);
        if (spot == null) throw new IllegalArgumentException("Invalid ticketId or not parked.");

        Ticket ticket = spot.remove();
        ticket.setExitTime(LocalDateTime.now());

        // compute price using strategy
        double price = pricingStrategy.calculatePrice(ticket.getEntryTime(), ticket.getExitTime(), ticket.getVehicleType());

        // free spot back to pool
        freeSpots.get(spot.getType()).add(spot);
        occupiedSpots.remove(ticketId);

        notifyObservers("Vehicle exited. Ticket: " + ticketId + ". Price: " + price);
        if (!isFull()) notifyObservers("ParkingLot has free spots");

        return price;
    }

    public boolean isFull() {
        // Parking lot is full if any spot type has no free spots (simplified definition)
        for (Queue<ParkingSpot> q : freeSpots.values()) {
            if (q.isEmpty()) return true;
        }
        return false;
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy; // open for extension (OCP)
        notifyObservers("Pricing strategy changed");
    }

    // Helpers for diagnostics
    public int availableSpots(SpotType type) { return freeSpots.get(type).size(); }
}

// -------------------------
// Gates and Observers (Observer Pattern)
// -------------------------
class EntranceGate implements Observer {
    private final String id;
    public EntranceGate(String id) { this.id = id; }
    // Entry request - interacts with ParkingLot to get a ticket
    public Ticket admitVehicle(Vehicle v) {
        ParkingLot lot = ParkingLot.getInstance();
        Ticket t = lot.parkVehicle(v);
        if (t == null) System.out.println("EntranceGate " + id + ": Cannot admit vehicle " + v.getLicensePlate() + " (no spot)");
        else System.out.println("EntranceGate " + id + ": Vehicle admitted. Ticket " + t.getTicketId());
        return t;
    }
    @Override public void update(String message) {
        System.out.println("[EntranceGate " + id + " received]: " + message);
    }
}

class ExitGate implements Observer {
    private final String id;
    private PricingStrategy pricingStrategy;

    public ExitGate(String id, PricingStrategy pricingStrategy) {
        this.id = id;
        this.pricingStrategy = pricingStrategy; // dependency injection of strategy (DIP)
    }

    // Exit process - calculates price by delegating to ParkingLot.unParkVehicle
    public void processExit(String ticketId) {
        ParkingLot lot = ParkingLot.getInstance();
        try {
            double price = lot.unParkVehicle(ticketId);
            System.out.println("ExitGate " + id + ": Vehicle with Ticket " + ticketId + " has been charged: " + price);
        } catch (Exception e) {
            System.out.println("ExitGate " + id + ": Error processing exit: " + e.getMessage());
        }
    }

    @Override public void update(String message) {
        System.out.println("[ExitGate " + id + " received]: " + message);
    }
}

// -------------------------
// Demo / Main
// -------------------------
public class ParkingLotLLD {
    public static void main(String[] args) throws InterruptedException {
        // choose pricing strategy (Strategy Pattern)
        PricingStrategy hourly = new HourlyPricingStrategy(10.0, 20.0); // 10 per hour for two-wheeler, 20 per hour four-wheeler
        PricingStrategy flatBlock = new FlatBlockPricingStrategy(15.0, 30.0, 8.0, 15.0);

        // Initialize parking lot singleton
        ParkingLot.init(2, 2, hourly);
        ParkingLot lot = ParkingLot.getInstance();

        // Create gates and register them as observers
        EntranceGate entryA = new EntranceGate("A");
        ExitGate exit1 = new ExitGate("1", hourly);

        lot.register(entryA);
        lot.register(exit1);

        // Create vehicles via factory
        Vehicle v1 = VehicleFactory.createVehicle(VehicleType.TWO_WHEELER, "KA01AA1111");
        Vehicle v2 = VehicleFactory.createVehicle(VehicleType.FOUR_WHEELER, "MH02BB2222");
        Vehicle v3 = VehicleFactory.createVehicle(VehicleType.FOUR_WHEELER, "DL03CC3333");
        Vehicle v4 = VehicleFactory.createVehicle(VehicleType.TWO_WHEELER, "UP04DD4444");

        // Vehicles enter
        Ticket t1 = entryA.admitVehicle(v1); // park two-wheeler
        Thread.sleep(1000); // sleep to create time separation in demo (not needed in real system)
        Ticket t2 = entryA.admitVehicle(v2); // park four-wheeler
        Thread.sleep(1000);
        Ticket t3 = entryA.admitVehicle(v3); // park four-wheeler
        Thread.sleep(1000);
        Ticket t4 = entryA.admitVehicle(v4); // park two-wheeler (should fail if no spot)

        // simulate passage of time (for pricing demo)
        Thread.sleep(2000);

        // Vehicles exit
        if (t1 != null) exit1.processExit(t1.getTicketId());
        if (t2 != null) exit1.processExit(t2.getTicketId());

        // Change pricing strategy at runtime (Strategy Pattern + OCP)
        lot.setPricingStrategy(flatBlock);
        System.out.println("Changed pricing to flat-block strategy at runtime.");

        // New vehicle enters after pricing change
        Vehicle v5 = VehicleFactory.createVehicle(VehicleType.TWO_WHEELER, "TN05EE5555");
        Ticket t5 = entryA.admitVehicle(v5);
        Thread.sleep(1000);
        if (t5 != null) exit1.processExit(t5.getTicketId());
    }
}
