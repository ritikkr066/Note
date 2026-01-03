public class Client {
    public static void main(String[] args) {

        Pizza basePizza = new Pizza("L", true, false);

        Pizza pizza1 = (Pizza) basePizza.clone();
        pizza1.setCheese(false);

        Pizza pizza2 = (Pizza) basePizza.clone();

        pizza1.print(); // L false false
        pizza2.print(); // L true false
    }
}
