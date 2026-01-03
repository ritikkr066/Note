public class Client {
    public static void main(String[] args) {
        Element pizza = new Pizza();
        Element burger=new Burger();
        Visitor discountVisitor = new DiscountVisitor();

        pizza.accept(discountVisitor);
        burger.accept(discountVisitor);

    }
}
