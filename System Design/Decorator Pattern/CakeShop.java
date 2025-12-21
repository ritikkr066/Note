// Step 1: Base Component
interface Cake {
    String getDescription();
    double getCost();
}

// Step 2: Concrete Component
class BasicCake implements Cake {
    @Override
    public String getDescription() {
        return "Basic Cake";
    }

    @Override
    public double getCost() {
        return 200.0;  // base price
    }
}

// Step 3: Abstract Decorator
abstract class CakeDecorator implements Cake {
    protected Cake tempCake;

    public CakeDecorator(Cake newCake) {
        this.tempCake = newCake;
    }

    public String getDescription() {
        return tempCake.getDescription();
    }

    public double getCost() {
        return tempCake.getCost();
    }
}

// Step 4: Concrete Decorators
class PuddingDecorator extends CakeDecorator {
    public PuddingDecorator(Cake newCake) {
        super(newCake);
    }

    @Override
    public String getDescription() {
        return tempCake.getDescription() + " + Pudding";
    }

    @Override
    public double getCost() {
        return tempCake.getCost() + 80.0;
    }
}

class ChocolateDecorator extends CakeDecorator {
    public ChocolateDecorator(Cake newCake) {
        super(newCake);
    }

    @Override
    public String getDescription() {
        return tempCake.getDescription() + " + Chocolate Syrup";
    }

    @Override
    public double getCost() {
        return tempCake.getCost() + 50.0;
    }
}

class FruitDecorator extends CakeDecorator {
    public FruitDecorator(Cake newCake) {
        super(newCake);
    }

    @Override
    public String getDescription() {
        return tempCake.getDescription() + " + Fruits";
    }

    @Override
    public double getCost() {
        return tempCake.getCost() + 70.0;
    }
}

// Step 5: Demo / Test
public class CakeShop {
    public static void main(String[] args) {
        Cake cake1 = new BasicCake();
        System.out.println(cake1.getDescription() + " costs: Rs. " + cake1.getCost());

        Cake cake2 = new PuddingDecorator(new BasicCake());
        System.out.println(cake2.getDescription() + " costs: Rs. " + cake2.getCost());

        Cake cake3 = new ChocolateDecorator(new PuddingDecorator(new BasicCake()));
        System.out.println(cake3.getDescription() + " costs: Rs. " + cake3.getCost());

        Cake cake4 = new FruitDecorator(new ChocolateDecorator(new PuddingDecorator(new BasicCake())));
        System.out.println(cake4.getDescription() + " costs: Rs. " + cake4.getCost());
    }
}
