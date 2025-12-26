// Step 4: Concrete Decorators
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 10;
    }

    public String description() {
        return coffee.description() + ", Milk";
    }
}
