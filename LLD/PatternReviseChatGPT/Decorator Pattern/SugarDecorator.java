public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 5;
    }

    public String description() {
        return coffee.description() + ", Sugar";
    }
}
